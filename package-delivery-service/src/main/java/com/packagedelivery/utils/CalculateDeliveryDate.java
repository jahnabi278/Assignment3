package com.packagedelivery.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.terra.pojos.ComponentType;

public class CalculateDeliveryDate {
	public static Date getDeliveryDate(ComponentType componentType, Date date) {
		LocalDate localdate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate date2 = null;
		if (componentType.equals(ComponentType.ACCESSORY)) {
			date2 = localdate.plusDays(2);
		} else if (componentType.equals(ComponentType.INTEGRAL)) {
			date2 = localdate.plusDays(5);
		}
		return Date.from(date2.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

}
