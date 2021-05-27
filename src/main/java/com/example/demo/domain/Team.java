package com.example.demo.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * チームクラスです．
 * 
 * @author nhson
 *
 */
public class Team {
	/**　ID*/
	private Integer id;
	/**　同盟の名前*/
	private String leagueName;
	/**　チームの名前*/
	private String teamName;
	/**　本部*/
	private String headquarters;
	/**　発足日*/
	private LocalDate inauguration;
	/**　歴史*/
	private String history;
	
	public Team() {
	}
	
	public Team(Integer id, String leagueName, String teamName,
			String headquarters, LocalDate inauguration, String history){
		this.id = id;
		this.leagueName = leagueName;
		this.teamName = teamName;
		this.headquarters = headquarters;
		this.inauguration = inauguration;
		this.history = history;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	public LocalDate getInauguration() {
		return inauguration;
	}

	public void setInauguration(LocalDate inauguration) {
		this.inauguration = inauguration;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", leagueName=" + leagueName + ", teamName=" + teamName + ", headquarters="
				+ headquarters + ", inauguration=" + inauguration + ", history=" + history + "]";
	}
	
	public String dateFormat() {
		return inauguration.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
	}
	
	/**
	 * historyからリストに変更するメソッドです．
	 * @return 歴史のリスト。
	 */
	public List<String> historyToList(){
		List<String> listOfHistory = new ArrayList<>();
		String [] historyList = history.split("↓");
		for(int i = 0;i<historyList.length-1;i++) {
			listOfHistory.add(historyList[i]);
			listOfHistory.add("↓");
		}
		listOfHistory.add(historyList[historyList.length-1]);
		return listOfHistory;
	}
}
