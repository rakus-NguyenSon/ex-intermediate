package com.example.demo.repository;

import java.awt.Color;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Clothe;


/**
 * clothesテーブルを操作用のクラスです．
 * 
 * @author nhson
 *
 */
@Repository
public class ClotheRepository {
private final static String COLOTHES_TABLE = "clothes";
	
	/** SpringFrameworkにある機能を利用するための変数 */
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/** Clotheオブジェクトを生成するローマッパー. */
	private static final RowMapper<Clothe> CLOTHE_ROW_MAPPER = (rs,i)->{
		
		Clothe clothe = new Clothe();
		
		clothe.setId(rs.getInt("id"));
		clothe.setCategory(rs.getString("category"));
		clothe.setGenre(rs.getString("genre"));
		clothe.setGender(rs.getInt("gender"));
		clothe.setColor(rs.getString("color"));
		clothe.setPrice(rs.getInt("price"));
		clothe.setSize(rs.getString("size"));
		return clothe;
	};
	
	/**
	 * 色と性別から衣類情報を取得します．
	 * 
	 * @param gender　性別
	 * @param color　色
	 * @return　条件に当たる衣類情報
	 */
	public List<Clothe> findByGenderAndColor(Integer gender, String color) {
		String sql = "Select id, category, genre, gender, color, price, size from "
				+ COLOTHES_TABLE + " where gender=:gender And color=:color order by price;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
		
		List<Clothe> clothes = template.query(sql, param,CLOTHE_ROW_MAPPER);
		return clothes;
	}
}
