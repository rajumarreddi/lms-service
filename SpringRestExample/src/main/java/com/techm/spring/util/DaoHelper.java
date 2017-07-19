package com.techm.spring.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.techm.spring.dao.DaoImpl;

public class DaoHelper {
	
	private static DaoHelper daoHelper;
	private MongoClient mongoClient;
	private DB db;
	private static final Logger logger = LoggerFactory.getLogger(DaoHelper.class);
	
	private DaoHelper() {
		super();
	}
	
	public static DaoHelper getInstance(){
		return daoHelper = new DaoHelper();
	}

	public MongoClient getMongoClient() {
		logger.info("Connect to database successfully");
		return mongoClient = new MongoClient( "localhost" , 27017 );
	}

	public DBCollection getCollection(String collectionName) {
		return db.getCollection(collectionName);
	}

	public DB getDb(String dbName) {
		return mongoClient.getDB(dbName);
	}
	
}
