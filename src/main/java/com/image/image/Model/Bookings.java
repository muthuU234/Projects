package com.image.image.Model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Bookings")
public class Bookings {
	@Id
	@Column(name="BID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	@Column(name="PRODNAME")
	private String prodname;
	@Column(name="SRC")
	private String src;
	@Column(name="DEST")
	private String dest;
	@Column(name="WEIGHT")
	private double weight;
	@Column(name="PRICE")
	private double price;
	@Column(name="STATUS")
	private String status;
	@ManyToOne
	@JoinColumn(name="CID",referencedColumnName="CID")
	private Client client;
	@Override
	public String toString() {
		return "Bookings [bid=" + bid + ", prodname=" + prodname + ", src=" + src + ", dest=" + dest + ", weight="
				+ weight + ", price=" + price + ", status=" + status + ", client=" + client + ", bkddate=" + bkddate
				+ "]";
	}
	@Column(name="BOOKED_TIME")
	private  LocalDateTime bkddate;
	
	
	public LocalDateTime getBkddate() {
		return bkddate;
	}
	public void setBkddate(LocalDateTime bkddate) {
		this.bkddate = bkddate;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client clients) {
		this.client = clients;
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
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
