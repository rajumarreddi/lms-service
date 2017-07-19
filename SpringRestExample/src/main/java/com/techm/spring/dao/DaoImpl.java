package com.techm.spring.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.techm.spring.bean.LoginBean;
import com.techm.spring.bean.RegistrationBean;

@Component
public class DaoImpl implements Dao{
	
	private static final Logger logger = LoggerFactory.getLogger(DaoImpl.class);
	
	@Override
	public LoginBean verifyUser(LoginBean loginBean) {
		/*if(null != loginBean && null != loginBean.getUserId() && null != loginBean.getPwd() &&
				"adminadmin".equalsIgnoreCase(loginBean.getUserId()) && "password".equalsIgnoreCase(loginBean.getPwd())){
			loginBean.setValidUser(Boolean.TRUE);
		}else{
			loginBean.setValidUser(Boolean.FALSE);
		}*/
	      try{   
	          // To connect to mongodb server
	          MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	 			
	          // Now connect to your databases
	          DB db = mongoClient.getDB( "Angular2" );
	          System.out.println("Connect to database successfully");
	 			
	          DBCollection coll = db.getCollection("Registration");
	          System.out.println("Collection mycol selected successfully");
	 			
	          DBCursor cursor = coll.find();
	          int i = 1;
	 			
	          while (cursor.hasNext()) { 
	             DBObject obj = cursor.next();
	             if(null != obj.get("_id")){
	            	if(obj.get("_id").toString().equalsIgnoreCase(loginBean.getUserId())){
	            		if(obj.get("password").toString().equalsIgnoreCase(loginBean.getPwd())){
	            			loginBean.setValidUser(Boolean.TRUE);
	            			loginBean.setName(obj.get("name").toString());
	            			break;
	            		}
	            	}
	             }
	          }
	       }catch(Exception e){
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	       }
		return loginBean;
	}

	@Override
	public RegistrationBean addUser(RegistrationBean rBean) {
		/*logger.info("R"+rBean);
		rBean.setRegistered(Boolean.TRUE);*/
	     try{   
	         // To connect to mongodb server
	         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	         
	         // Now connect to your databases
	         DB db = mongoClient.getDB( "Angular2" );
	         logger.info("Connect to database successfully");
	         
	         DBCollection coll = db.getCollection("Registration");
	         System.out.println("Collection mycol selected successfully");
				
	         BasicDBObject doc = new BasicDBObject("_id", rBean.getEmail()).
	        	append("name", rBean.getName()).
	            append("mobileNumber", rBean.getMobileNumber()).
	            append("email", rBean.getEmail()).
	            append("password", rBean.getPassword()). 
	            append("city", rBean.getCity()).
	            append("gender", rBean.getGender()).
	            append("city", rBean.getCity());
	         
	         BasicDBObject intrestsDoc = new BasicDBObject();
	         if(null != rBean.getInterests() && rBean.getInterests().length>0){
	        	 int i=1;
	        	 for(String str:rBean.getInterests()){
	        		 intrestsDoc.append("intrest"+i, str);
	        		 ++i;
		         } 
	         }
	         doc.append("intrests", intrestsDoc);
					
	         WriteResult result = coll.insert(doc);
	         logger.info("Result object"+result.toString());
	         logger.info("Document inserted successfully");
	         rBean.setRegistered(Boolean.TRUE);
	      }catch(DuplicateKeyException e){
		        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		        rBean.setUserExists(Boolean.TRUE);
		  }
	     catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         rBean.setRegistered(Boolean.FALSE);
	      }
		return rBean;
	}
}
