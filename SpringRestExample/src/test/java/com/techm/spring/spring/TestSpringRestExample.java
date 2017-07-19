package com.techm.spring.spring;

import org.springframework.web.client.RestTemplate;

import com.techm.spring.bean.LoginBean;
import com.techm.spring.util.RestURIConstants;

public class TestSpringRestExample {

	public static final String SERVER_URI = "http://localhost:8080/SpringRestExample";
	
	public static void main(String args[]){
		testCreateEmployee();
	}


	private static void testCreateEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		LoginBean emp = new LoginBean();
		emp.setUserId("123456");
		emp.setPwd("Rajuu");
		LoginBean response = restTemplate.postForObject(SERVER_URI+RestURIConstants.USER_LOGIN, emp, LoginBean.class);
		printEmpData(response);
	}

	
	public static void printEmpData(LoginBean emp){
		System.out.println("ID="+emp.getUserId()+",Name="+emp.getPwd()+", is valid user = "+emp.getValidUser());
	}
}
