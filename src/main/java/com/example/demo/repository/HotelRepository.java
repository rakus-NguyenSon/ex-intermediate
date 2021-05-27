package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Hotel;

/**
 * hotelsテーブルを操作用のクラスです．
 * 
 * @author nhson
 *
 */
@Repository
public class HotelRepository {

	private final static String HOTELS_TABLE = "hotels";
	
	/** SpringFrameworkにある機能を利用するための変数 */
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/** Hotelオブジェクトを生成するローマッパー. */
	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs,i)->{
		
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;
	};
	
	/**
	 * ホテル一覧を取得します．
	 * 
	 * @return　値段の降順で並び替え全ホテル情報を返します。
	 */
	public List<Hotel> findAll(){
		String sql = "Select id, area_name, hotel_name, address, "
				+ "nearest_station, price, parking from " + HOTELS_TABLE + " Order by price DESC;";
		
		List<Hotel> hotels = template.query(sql, HOTEL_ROW_MAPPER);
		return hotels;
	}
	
	
	/**
	 * 値段がprice以下のホテル一覧を取得します．
	 * 
	 * @param price　値段
	 * @return　値段が値段がprice以下で値段の降順で並び替え全ホテル情報を返します。
	 */
	public List<Hotel> findLessThanPrice(Integer price){
		String sql = "Select id, area_name, hotel_name, address, "
				+ "nearest_station, price, parking from " + HOTELS_TABLE + 
				" where price<= :price Order by price DESC;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		
		List<Hotel> hotels = template.query(sql,param, HOTEL_ROW_MAPPER);
		return hotels;
	}
}
