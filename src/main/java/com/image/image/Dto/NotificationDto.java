package com.image.image.Dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class NotificationDto {



	private int bid;
	private String prodname;
	private double weight;
	private Timestamp booked_time;
	private String cname;
	private String courier_status;
	private int cid;

	
	
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Timestamp getBooked_time() {
		return booked_time;
	}

	public void setBooked_time(Timestamp booked_time) {
		this.booked_time = booked_time;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCourier_status() {
		return courier_status;
	}

	public void setCourier_status(String courier_status) {
		this.courier_status = courier_status;
	}

	
	public NotificationDto(int bid, String prodname, double weight, Timestamp booked_time, String cname,
			String courier_status, int cid) {
		this.bid = bid;
		this.prodname = prodname;
		this.weight = weight;
		this.booked_time = booked_time;
		this.cname = cname;
		this.courier_status = courier_status;
		this.cid = cid;
	}
}
