package com.webscraper;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.webscraper.scrapping.WebScraper;

@SpringBootApplication
public class WebscraperApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(WebscraperApplication.class, args);
	}
	
	@Bean
	 public  void run() {
	        // Replace the uri string with your MongoDB deployment's connection string
	        String uri = "mongodb://rootuser:rootpass@localhost:27017/webscraper";
	        try (MongoClient mongoClient = MongoClients.create(uri)) {
	            MongoDatabase database = mongoClient.getDatabase("admin");
	            try {
	                Bson command = new BsonDocument("ping", new BsonInt64(1));
	                Document commandResult = database.runCommand(command);
	                System.out.println("Connected successfully to server.");
	            } catch (MongoException me) {
	                System.err.println("An error occurred while attempting to run a command: " + me);
	            }
	        }
	    }

}
