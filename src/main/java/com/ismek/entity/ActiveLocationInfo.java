package com.ismek.entity;
import com.ismek.util.DateAndTimeDeserialize;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "TBL_ACTIVELOCATIONINFO")
public class ActiveLocationInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "driverId")
	private long driverId;
	@Column(name = "longitude") // boylam
	private double longitude;
	@Column(name = "latitude") 	// enlem
	private double latitude;
	@Column(name = "cdate") 	// konum olusma tarihi
    @JsonDeserialize(using=DateAndTimeDeserialize.class)
	private Date cdate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getDriverId() {
		return driverId;
	}
	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude; //comment
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

}