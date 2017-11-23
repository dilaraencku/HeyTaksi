package com.ismek.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="TBL_TRAVEL_SATISFACTION_INFORMATION")

public class TravelSatisfactionInformation {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id; 
	
	@Column (name="taxi_driver_id")
	private long taxiDriverId;
	
	@Column (name="customer_Id")
	private long customerId;
	
	@Column (name="travel_Comment")
	private String travelComment;
	
	@Column (name="travel_rate")
	private Date travelDate;
	
	@Column(name="star_rating")
	private String starRating;
	
	public TravelSatisfactionInformation(long id,long taxiDriverId,long customerId,String travelComment,Date travelDate,String starRating) {
	this.id=id;
	this.taxiDriverId=taxiDriverId;
	this.customerId=customerId;
	this.travelComment=travelComment;
	this.travelDate=travelDate;
	this.starRating=starRating;
	
	}
	
	
	public double getId() {
		return id;
	}
	
	public long getTaxiDriverId() {
		return taxiDriverId;
	}
	public void setTaxiDriverId(long taxiDriverId) {
		this.taxiDriverId = taxiDriverId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public void setId(long id) {
		this.id=id;
	}
	public String getTravelComment() {
		return travelComment;
	}
	public void setTravelComment(String travelComment) {
		this.travelComment = travelComment;
	}
	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	public String getStarRating() {
		return starRating;
	}
	public void setStarRating(String starRating) {
		this.starRating = starRating;
	}
	
}
