package com.returnorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.returnorder.service.ReturnOrderService;
import com.terra.dto.ReturnOrderDTO;
import com.terra.pojos.ProcessInput;
import com.terra.pojos.ProcessOutput;
import com.terra.pojos.ReturnOrderInput;
import com.terra.result.Result;

@RestController
@RequestMapping("/returnorder")
public class ReturnOrderController {
	@Autowired
	ReturnOrderService returnOrderService;
	@Autowired
	RestTemplate restTemplate;

	@PostMapping(value = "/create")
	public Result create(@RequestBody ReturnOrderInput returnOrderInput) {
		ReturnOrderDTO dto = new ReturnOrderDTO();
		dto.setCreditCardNumber(returnOrderInput.getCreditCardNumber());
		dto.setCreditLimit(returnOrderInput.getCreditLimit());
		dto.setProcessingCharge(returnOrderInput.getProcessingCharge());
		dto.setRequestId(returnOrderInput.getRequestId());
		return returnOrderService.saveReturnOrder(dto);
	}

	@GetMapping
	public ProcessOutput getPensioners(@RequestBody ProcessInput processInput) {
		ResponseEntity<ProcessOutput> rs = callmeforCreateProduct(processInput);
		return convertResponseEntityToReturnObject(rs);
	}

	private ProcessOutput convertResponseEntityToReturnObject(ResponseEntity<ProcessOutput> rs) {
		ProcessOutput output = new ProcessOutput();
		output.setDateOfDelivery(rs.getBody().getDateOfDelivery());
		output.setPackagingAndDeliveryCharge(rs.getBody().getPackagingAndDeliveryCharge());
		output.setProcessingCharge(rs.getBody().getProcessingCharge());
		output.setRequestId(rs.getBody().getRequestId());
		return output;
	}

	private ResponseEntity<ProcessOutput> callmeforCreateProduct(@RequestBody ProcessInput processInput) {
		if (restTemplate == null) {
			restTemplate = new RestTemplate();
		}
		return restTemplate.postForEntity("http://localhost:8080/api/GetPackageDeliveryAndProcessingCharge", processInput,
				ProcessOutput.class);
	}

}
