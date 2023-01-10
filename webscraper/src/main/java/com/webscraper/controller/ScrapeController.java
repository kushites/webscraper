package com.webscraper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webscraper.model.Data;
import com.webscraper.scrapping.WebScraper;

@RestController
public class ScrapeController {

	@Autowired
	private WebScraper web;
	@GetMapping("/getdata")
	public List<Data> getData()  {
		try {
		return web.saveData();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
}
