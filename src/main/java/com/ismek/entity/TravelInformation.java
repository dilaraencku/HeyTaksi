package com.ismek.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_TRAVEL_INFORMATION")
public class TravelInformation {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "price")
	private double price;

	@Column(name = "start_longitude")
	private double startLongitude;

	@Column(name = "start_latitude")
	private double startLatitude;

	@Column(name = "end_longitude")
	private double endLongitude;

	@Column(name = "end_latitude")
	private double endLatitude;

	@Column(name = "start_date")
	private Date start_date;

	@Column(name = "end_date")
	private Date end_date;

	@Column(name = "user_id")
	private long user_id;

	@Column(name = "driver_id")
	private long driver_id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getStartLongitude() {
		return startLongitude;
	}

	public void setStartLongitude(double startLongitude) {
		this.startLongitude = startLongitude;
	}

	public double getStartLatitude() {
		return startLatitude;
	}

	public void setStartLatitude(double startLatitude) {
		this.startLatitude = startLatitude;
	}

	public double getEndLongitude() {
		return endLongitude;
	}

	public void setEndLongitude(double endLongitude) {
		this.endLongitude = endLongitude;
	}

	public double getEndLatitude() {
		return endLatitude;
	}

	public void setEndLatitude(double endLatitude) {
		this.endLatitude = endLatitude;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public TravelInformation(double price, double startLongitude, double startLatitude, double endLongitude,
			double endLatitude, long user_id, long driver_id, Date start_date, Date end_date) {
		super();
		this.price = price;
		this.startLongitude = startLongitude;
		this.startLatitude = startLatitude;
		this.endLongitude = endLongitude;
		this.endLatitude = endLatitude;
		this.user_id = user_id;
		this.driver_id = driver_id;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public TravelInformation() {
		super();
	}

}
