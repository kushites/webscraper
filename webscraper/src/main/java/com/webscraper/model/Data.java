package com.webscraper.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data

@NoArgsConstructor
public class Data {
	@Id
	private String id;
	
	private String name;
	
	public Data(String name, String change, String tvl, String chains, String monthchange, String daychange,
			String mcap, String borrowed) {
		super();
		this.name = name;
		this.change = change;
		this.tvl = tvl;
		this.chains = chains;
		this.monthchange = monthchange;
		this.daychange = daychange;
		this.mcap = mcap;
		this.borrowed = borrowed;
	}

	private String change;
	
	private String tvl;
	
	private String chains;
	
	private String monthchange;
	
	private String daychange;
	
	private String mcap;
	
	private String borrowed;

}
