package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Hotel;
import com.example.demo.repository.HotelRepository;

@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	/**
	 * ホテル一覧を取得します．
	 * 
	 * @return　値段の降順で並び替え全ホテル情報を返します。
	 */
	public List<Hotel> loadAllHotels(){
		return hotelRepository.findAll();
	}
	
	/**
	 * priceの値段以下のホテルを取得します．
	 * 
	 * @param price　値段
	 * @return　全てprice以下の値段のホテルを返します。
	 */
	public List<Hotel> loadLessThanPrice(Integer price){
		return hotelRepository.findLessThanPrice(price);
	}
	
}
