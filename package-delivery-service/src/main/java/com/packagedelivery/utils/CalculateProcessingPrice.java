package com.packagedelivery.utils;

import java.util.HashMap;
import java.util.Map;

import com.terra.pojos.ComponentType;

public class CalculateProcessingPrice {
	public static Map<String, Integer> processingCharge = null;

	public static int getProcessingCharge(ComponentType componentType) {
		int result = 0;
		if (processingCharge == null) {
			setProcessingCharge();
		}
		if (componentType.equals(ComponentType.ACCESSORY)) {
			result = processingCharge.get(componentType.name());
		} else if (componentType.equals(ComponentType.INTEGRAL)) {
			result = processingCharge.get(componentType.name());
		}
		return result;
	}

	private static void setProcessingCharge() {
		Map<String, Integer> processingChrg = new HashMap<>();
		processingChrg.put(ComponentType.ACCESSORY.name(), 300);
		processingChrg.put(ComponentType.INTEGRAL.name(), 500);
		processingCharge = processingChrg;
	}
}
