package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Clothe;
import com.example.demo.repository.ClotheRepository;

/**
 * 衣類情報を処理用サービスクラスです．
 * 
 * @author nhson
 *
 */
@Service
@Transactional
public class ClotheService {

	@Autowired
	private ClotheRepository clotheRepository;
	
	/**
	 * 性別と色により、衣類情報を取得します．
	 * 
	 * @param gender　性別
	 * @param color　色
	 * @return　条件に当たる衣類情報
	 */
	public List<Clothe> loadByGenderAndColor(String gender, String color){
		Integer genderValue = 1;
		if(gender.equals("Woman")) {
			genderValue = 0;
		}
		
		return clotheRepository.findByGenderAndColor(genderValue, color);
	}
}
