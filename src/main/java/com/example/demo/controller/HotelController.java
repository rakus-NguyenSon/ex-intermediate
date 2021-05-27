package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.Hotel;
import com.example.demo.form.HotelForm;
import com.example.demo.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	/**
	 * 利用するフォームのセットアップです.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public HotelForm setUpHotelForm() {
		return new HotelForm();
	}

	/**
	 * ホテル検索画面表示する.
	 * 
	 * @return  ホテル検索画面のHTMLファイル名。 
	 */
	@RequestMapping("")
	public String index() {
		return "hotelList";
	}

	/**
	 * 条件からホテルを検索する処理行う.
	 * 
	 * @param form ホテルフォーム。
	 * @param redirectAtrribute。
	 * @return　ホテル検索画面にリダイレクトする。
	 */
	@RequestMapping("/search")
	public String search(HotelForm form, RedirectAttributes redirectAtrribute) {
		System.out.println(form.getPrice());
		if (form.getPrice().isBlank()) {
			List<Hotel> hotels = hotelService.loadAllHotels();
			redirectAtrribute.addFlashAttribute("hotelsList", hotels);
			System.out.println(hotels.size());
			return "redirect:/hotel";
		}
		try {
			Integer price = Integer.parseInt(form.getPrice());
			List<Hotel> hotels = hotelService.loadLessThanPrice(price);
			redirectAtrribute.addFlashAttribute("hotelsList", hotels);
			System.out.println(hotels.size());
		} catch (Exception e) {
			e.printStackTrace();
			redirectAtrribute.addFlashAttribute("error", "数字のみ入力可能です。");
			System.out.println("Error");
		}
		
		return "redirect:/hotel";
	}
}
