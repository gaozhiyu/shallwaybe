package com.william.to;

import com.william.vo.CommonVO;

public class GISDTO extends CommonVO{
	public String[] countryArray;
	public String[] provinceArray;
	public String[] cityArray;

	public String[] getCityArray() {
		return cityArray;
	}

	public void setCityArray(String[] cityArray) {
		this.cityArray = cityArray;
	}

	public String[] getCountryArray() {
		return countryArray;
	}

	public void setCountryArray(String[] countryArray) {
		this.countryArray = countryArray;
	}

	public String[] getProvinceArray() {
		return provinceArray;
	}

	public void setProvinceArray(String[] provinceArray) {
		this.provinceArray = provinceArray;
	}
	
}
