package com.op.login.model;

public class UserInfo {

	private String First_name;
	private String Last_name;
	private String Image_url;
	
	
	public UserInfo() {
		super();
	}


	public UserInfo(String first_name, String last_name, String image_url) {
		super();
		First_name = first_name;
		Last_name = last_name;
		Image_url = image_url;
	}


	public String getFirst_name() {
		return First_name;
	}


	public void setFirst_name(String first_name) {
		First_name = first_name;
	}


	public String getLast_name() {
		return Last_name;
	}


	public void setLast_name(String last_name) {
		Last_name = last_name;
	}


	public String getImage_url() {
		return Image_url;
	}


	public void setImage_url(String image_url) {
		Image_url = image_url;
	}
	
	
	
}
