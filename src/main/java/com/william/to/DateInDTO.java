package com.william.to;

import com.mysql.jdbc.StringUtils;
import com.william.vo.CommonInput;

public class DateInDTO extends CommonInput{
	//private String userid;
	private String page;
	private String dateid;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getDateid() {
		return dateid;
	}

	public void setDateid(String dateid) {
		this.dateid = dateid;
	}
	
	public boolean isValid(){
		boolean flag = true;
		if(StringUtils.isEmptyOrWhitespaceOnly(dateid)){
			flag = false;
		}
		try{
			int pageNO = Integer.parseInt(page);
			if(Integer.parseInt(page)<0){
				flag = false;
			}
		}catch (Exception e){
			flag = false;
		}
		
		return flag;
	}

}
