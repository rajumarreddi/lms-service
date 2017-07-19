package com.techm.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techm.spring.bean.LoginBean;
import com.techm.spring.bean.RegistrationBean;
import com.techm.spring.controller.IController;
import com.techm.spring.util.RestURIConstants;

/**
 * Handles requests for the Employee service.
 */
@RestController
public class Service {
	
	private static final Logger logger = LoggerFactory.getLogger(Service.class);
	
	@Autowired
	private IController iController;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = RestURIConstants.USER_LOGIN, method = RequestMethod.POST)
	public @ResponseBody LoginBean verifyUser(@RequestBody LoginBean loginBean) {
		logger.info("Start verifyUser()");
		return iController.verifyUser(loginBean);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = RestURIConstants.USER_REGISTRATION, method = RequestMethod.POST)
	public @ResponseBody RegistrationBean addUser(@RequestBody RegistrationBean rBean) {
		logger.info("Start addUser()");
		return iController.addUser(rBean);
	}
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hellooooooooooo......";
	}
}
