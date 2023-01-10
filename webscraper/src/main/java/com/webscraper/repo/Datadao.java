package com.webscraper.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webscraper.model.Data;

public interface Datadao extends MongoRepository<Data, String>{

}
