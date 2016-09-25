package com.william.to;

public class ValidationResult {
	private String resultString;
	private boolean resultValid;
	
	public ValidationResult() {
		super();
	}

	public ValidationResult(String resultString, boolean result) {
		super();
		this.resultString = resultString;
		this.resultValid = result;
	}

	public String getResultString() {
		return resultString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	public boolean isResultValid() {
		return resultValid;
	}

	public void setResultValid(boolean resultValid) {
		this.resultValid = resultValid;
	}



}
