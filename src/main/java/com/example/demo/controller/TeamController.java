package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Team;
import com.example.demo.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	/**
	 * 全てのチームの一覧ページの処理
	 * @param model
	 * @return チーム一覧ページHTMLファイル名
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<Team> teams = teamService.loadAllTeam();
		
		model.addAttribute("teams", teams);
		return "showTeamsList";
	}
	
	@RequestMapping("/detail")
	public String detail(String id, Model model) {
		
		Team team = teamService.showDetail(Integer.parseInt(id));
		model.addAttribute("team", team);
		return "teamDetail";
	}
}
