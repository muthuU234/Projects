package com.image.image.Dto;

public class MessageDTO {
	private String msg;
	private int booking_id;
	private String product_name;
	private String Status;
	private int user_id;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getMsg() {
		return msg;
	}

	public MessageDTO(String msg, int booking_id, String product_name, String status,int user_id) {
		this.msg = msg;
		this.booking_id = booking_id;
		this.product_name = product_name;
		Status = status;
		this.user_id= user_id;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

}
