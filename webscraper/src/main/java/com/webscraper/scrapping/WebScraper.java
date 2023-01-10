package com.webscraper.scrapping;



import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webscraper.model.Data;
import com.webscraper.repo.Datadao;


@Service
public class WebScraper {
	
	@Autowired
	private Datadao datadao;
	
	public List<Data> saveData()throws Exception {
	
	Document document = Jsoup.connect("https://defillama.com/protocols/lending").get();
	String result="2";
	int c=0;
	List<Data> list = new ArrayList<>();
	for(Element row: document.select("div.sc-d3821a9d-0.bqyBvy tr")) {
		 c++;
		if(c==1) {
			 continue;
		 }
	String name=	row.select("td:nth-of-type(1)").text();
	String change = row.select("td:nth-of-type(2)").text();
	String tvl = row.select("td:nth-of-type(3)").text();
	String chains = row.select("td:nth-of-type(4)").text();
	String monc= row.select("td:nth-of-type(5)").text();
	String dc = row.select("td:nth-of-type(6)").text();
	String mcap = row.select("td:nth-of-type(7)").text();
	String bor = row.select("td:nth-of-type(8)").text();
 
if(!name.equals("")) {
	Data datanew = new Data(name, change, tvl, chains, monc, dc, mcap, bor);
//	datadao.insert(datanew);
	list.add(datanew);
}
 
	}
	return datadao.saveAll(list);
	}
	

}
