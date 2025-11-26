package com.image.image.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="REJECTED")
public class Rejected {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RID")
	private int rid;
	@Column(name="CID")
	private int cid;
	@Column(name="BID")
	private int bid;
	@Column(name="REJECTED_TIME")
	private LocalDateTime rejectedtime;
	@Column(name="BOOKED_TIME")
	private LocalDateTime booked_time;
	@Column(name="PRODNAME")
	private String Prodname;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
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
	public LocalDateTime getRejectedtime() {
		return rejectedtime;
	}
	public void setRejectedtime(LocalDateTime rejectedtime) {
		this.rejectedtime = rejectedtime;
	}
	public LocalDateTime getBooked_time() {
		return booked_time;
	}
	public void setBooked_time(LocalDateTime booked_time) {
		this.booked_time = booked_time;
	}
	public String getProdname() {
		return Prodname;
	}
	public void setProdname(String prodname) {
		Prodname = prodname;
	}

}
