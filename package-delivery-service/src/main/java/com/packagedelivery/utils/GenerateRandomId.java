package com.packagedelivery.utils;

import java.util.UUID;

public class GenerateRandomId {

	public static String generateRandomId() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
