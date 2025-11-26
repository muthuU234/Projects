package com.image.image.Model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Accpted Couriers
@Entity
@Table(name="ACCEPTED")
public class Accepted {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AID")
	private int aid;
	@Column(name="CID")
	private int cid;
	@Column(name="BID")
	private int bid;
	@Column(name="ACCEPTED_TIME")
	private LocalDateTime acceptedtime;
	@Column(name="BOOKED_TIME")
	private LocalDateTime booked_time;
	@Column(name="PRODNAME")
	private String Prodname;
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
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
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
	public LocalDateTime getAcceptedtime() {
		return acceptedtime;
	}
	public void setAcceptedtime(LocalDateTime acceptedtime) {
		this.acceptedtime = acceptedtime;
	}
}
