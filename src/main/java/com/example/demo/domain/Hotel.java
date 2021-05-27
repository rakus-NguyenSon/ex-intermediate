package com.example.demo.domain;

/**
 * ホテルの情報を表すドメインクラスです．
 * 
 * @author nhson
 *
 */
public class Hotel {

	/**　ID　*/
	private Integer id;
	
	/**　エリア　*/
	private String areaName;
	
	/**　名前　*/
	private String hotelName;
	
	/**　アドレス　*/
	private String address;
	
	/**　一番近くの駅名　*/
	private String nearestStation;
	
	/**　値段　*/
	private Integer price;
	
	/**　駐車場の無有　*/
	private String parking;

	public Hotel() {
	}

	public Hotel(Integer id, String areaName, String hotelName, String address, String nearestStation, Integer price,
			String parking) {
		this.id = id;
		this.areaName = areaName;
		this.hotelName = hotelName;
		this.address = address;
		this.nearestStation = nearestStation;
		this.price = price;
		this.parking = parking;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNearestStation() {
		return nearestStation;
	}

	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", areaName=" + areaName + ", hotelName=" + hotelName + ", address=" + address
				+ ", nearestStation=" + nearestStation + ", price=" + price + ", parking=" + parking + "]";
	}

}
