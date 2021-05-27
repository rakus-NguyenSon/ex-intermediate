package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.Clothe;
import com.example.demo.service.ClotheService;

/**
 * 衣類情報の処理用Controllerクラスです．
 * 
 * @author nhson
 *
 */
@Controller
@RequestMapping("/clothe")
public class ClotheController {
	
	@Autowired
	private ClotheService clotheService;
	
	/**
	 * 衣類検索画面を表示するための処理．
	 * 
	 * @param model
	 * @return　衣類検索画面のHTMLファイル名
	 */
	@RequestMapping("")
	public String index(Model model) {
		
		List<String> colors = new ArrayList<>();
		colors.add("赤");
		colors.add("青");
		colors.add("白");
		colors.add("黄");
		
		model.addAttribute("colors", colors);
		return "clothesList";
	}
	
	/**
	 * 性別と色の値により検索処理.
	 * 
	 * @param gender　性別
	 * @param color　色
	 * @param redirectAttributes　Flashスコップ
	 * @return　表示画面にRedirectする
	 */
	@RequestMapping("/search")
	public String search(String gender, String color, RedirectAttributes redirectAttributes) {
		
		System.out.println(gender);
		System.out.println(color);
		List<Clothe> clothes = clotheService.loadByGenderAndColor(gender, color);
		redirectAttributes.addFlashAttribute("clothes", clothes);
		return "redirect:/clothe";
	}
}
