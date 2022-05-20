package com.packagedelivery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packagedelivery.utils.CalculateDeliveryDate;
import com.packagedelivery.utils.CalculatePackageAndDeliveryCharge;
import com.packagedelivery.utils.CalculateProcessingPrice;
import com.packagedelivery.utils.GenerateRandomId;
import com.terra.pojos.PackageDeliveryInput;
import com.terra.pojos.PackageDeliveryOutput;
import com.terra.pojos.ProcessInput;
import com.terra.pojos.ProcessOutput;

@RestController
@RequestMapping("api")
public class PackageDeliveryController {

	@GetMapping("GetPackagingDeliveryCharge")
	public PackageDeliveryOutput getDetails(@RequestBody PackageDeliveryInput input) {
		PackageDeliveryOutput pckDeliveryOutput = new PackageDeliveryOutput();
		pckDeliveryOutput.setPackageDeliveryCharge(
				CalculatePackageAndDeliveryCharge.getPackageAndDeliveryCharge(input.getType(), input.getQuantity()));
		return pckDeliveryOutput;
	}

	@GetMapping("GetPackageDeliveryAndProcessingCharge")
	public ProcessOutput get(@RequestBody ProcessInput input) {
		ProcessOutput processOutput = new ProcessOutput();
		processOutput.setPackagingAndDeliveryCharge(CalculatePackageAndDeliveryCharge.getPackageAndDeliveryCharge(
				input.getDefectiveComponent().getComponentType(), input.getDefectiveComponent().getQuantity()));

		processOutput.setDateOfDelivery(CalculateDeliveryDate.getDeliveryDate(
				input.getDefectiveComponent().getComponentType(), input.getDefectiveComponent().getSystemDate()));

		processOutput.setProcessingCharge(
				CalculateProcessingPrice.getProcessingCharge(input.getDefectiveComponent().getComponentType()));
		processOutput.setRequestId(GenerateRandomId.generateRandomId());
		return processOutput;
	}
}
