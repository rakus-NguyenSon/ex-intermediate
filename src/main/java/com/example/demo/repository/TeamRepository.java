package com.example.demo.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Team;


/**
 * Teamsテーブルを操作用のクラスです．
 * 
 * @author nhson
 *
 */
@Repository
public class TeamRepository {
	
	private final static String TEAMS_TABLE = "teams";
	
	/** SpringFrameworkにある機能を利用するための変数 */
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/** Teamオブジェクトを生成するローマッパー. */
	private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs,i)->{
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy年M月d日");
		LocalDate inauguration = LocalDate.parse(rs.getString("inauguration"),format);
		team.setInauguration(inauguration);
		team.setHistory(rs.getString("history"));
		return team;
	};
	
	/**
	 * チーム一覧を取得します．
	 * 
	 * @return　順番になってないで全チーム一覧を返します。
	 */
	public List<Team> findAll(){
		String sql = "Select id, league_name, team_name, headquarters,"
				+ "inauguration, history from " + TEAMS_TABLE +";";
		List<Team> teams= template.query(sql, TEAM_ROW_MAPPER);
		return teams;
	}
	
	/**
	 * 主キーからチーム情報を取得します．
	 * 
	 * @param id　情報を取得したいチームのID
	 * @return　取得したいチームの情報
	 */
	public Team detail(int id) {
		String sql =  "Select id, league_name, team_name, headquarters,"
				+ "inauguration, history from " + TEAMS_TABLE +" where id =:id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
		return team;
	}
}
