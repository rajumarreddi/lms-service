package com.techm.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techm.spring.bean.LoginBean;
import com.techm.spring.bean.RegistrationBean;
import com.techm.spring.dao.Dao;

@Component
public class ControllerImpl implements IController {
	
	@Autowired
	private Dao dao;
	
	@Override
	public LoginBean verifyUser(LoginBean loginBean) {
		return dao.verifyUser(loginBean);
	}

	@Override
	public RegistrationBean addUser(RegistrationBean rBean) {
		return dao.addUser(rBean);
	}

}
