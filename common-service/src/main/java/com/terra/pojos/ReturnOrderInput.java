package com.terra.pojos;

public class ReturnOrderInput {
	private String requestId;
	private String creditCardNumber;
	private int creditLimit;
	private float processingCharge;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public int getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}

	public float getProcessingCharge() {
		return processingCharge;
	}

	public void setProcessingCharge(float processingCharge) {
		this.processingCharge = processingCharge;
	}
}
