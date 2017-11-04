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
	@Column(name="travelId")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long travelId; 
	@Column (name="taxiDriverId")
	private long taxiDriverId;
	@Column (name="customerId")
	private long customerId;
	@Column (name="travelComment")
	private String travelComment;
	@Column (name="travelDate")
	private Date travelDate;
	@Column(name="starRating")
	private String starRating;
	
	public TravelSatisfactionInformation(long travelId,long taxiDriverId,long customerId,String travelComment,Date travelDate,String starRating) {
	this.travelId=travelId;
	this.taxiDriverId=taxiDriverId;
	this.customerId=customerId;
	this.travelComment=travelComment;
	this.travelDate=travelDate;
	this.starRating=starRating;
	
	}
	
	
	public double getTravelId() {
		return travelId;
	}
	
	public long getTaxidriverid() {
		return taxiDriverId;
	}
	public void setTaxidriverid(long taxiDriverId) {
		this.taxiDriverId = taxiDriverId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public void setTravelId(long travelId) {
		this.travelId = travelId;
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
