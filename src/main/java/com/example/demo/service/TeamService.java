package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Team;
import com.example.demo.repository.TeamRepository;

@Service
@Transactional
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	/**
	 * チーム一覧を取得します．
	 * 
	 * @return　順番になってる全チーム一覧を返します。
	 */
	public List<Team> loadAllTeam() {
		List<Team> teams = teamRepository.findAll();
		teams.sort((team1,team2) -> team1.getInauguration().compareTo(team2.getInauguration()));
		return teams;
	}
	
	/**
	 * 主キーからチーム情報を取得します．
	 * 
	 * @param id　情報を取得したいチームのID
	 * @return　取得したいチームの情報
	 */
	public Team showDetail(Integer ID) {
		Team team = teamRepository.detail(ID);
		return team;
	}
}
