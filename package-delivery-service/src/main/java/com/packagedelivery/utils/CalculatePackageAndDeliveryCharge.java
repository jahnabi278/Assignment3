package com.packagedelivery.utils;

import java.util.HashMap;
import java.util.Map;

import com.terra.pojos.ComponentType;

public class CalculatePackageAndDeliveryCharge {
	public static Map<String, Integer> packagingCharge = null;
	public static Map<String, Integer> deliveryCharge = null;

	private static int getPackagingCharge(ComponentType componentType) {
		int result = 0;
		if (packagingCharge == null) {
			setPackagingCharge();
		}
		if (componentType.equals(ComponentType.ACCESSORY)) {
			result = packagingCharge.get(componentType.name());
		} else if (componentType.equals(ComponentType.INTEGRAL)) {
			result = packagingCharge.get(componentType.name());
		}
		return result;

	}

	private static void setPackagingCharge() {
		Map<String, Integer> pckCharge = new HashMap<>();
		pckCharge.put(ComponentType.INTEGRAL.name(), 100);
		pckCharge.put(ComponentType.ACCESSORY.name(), 50);
		pckCharge.put(ComponentType.PROTECTIVE_SHEATH.name(), 50);
		packagingCharge = pckCharge;
	}

	private static int getDeliveryCharge(ComponentType componentType) {
		int result = 0;
		if (deliveryCharge == null) {
			setDeliveryCharge();
		}
		if (componentType.equals(ComponentType.ACCESSORY)) {
			result = deliveryCharge.get(componentType.name());
		} else if (componentType.equals(ComponentType.INTEGRAL)) {
			result = deliveryCharge.get(componentType.name());
		}
		return result;
	}

	private static void setDeliveryCharge() {
		Map<String, Integer> deliverCharge = new HashMap<>();
		deliverCharge.put(ComponentType.ACCESSORY.name(), 200);
		deliverCharge.put(ComponentType.INTEGRAL.name(), 100);
		deliveryCharge = deliverCharge;
	}

	public static float getPackageAndDeliveryCharge(ComponentType componentType, int quantity) {
		return (getPackagingCharge(componentType) * quantity) + getDeliveryCharge(componentType);
	}

}
