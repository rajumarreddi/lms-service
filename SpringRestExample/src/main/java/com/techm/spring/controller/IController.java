package com.techm.spring.controller;

import com.techm.spring.bean.LoginBean;
import com.techm.spring.bean.RegistrationBean;

public interface IController {
	LoginBean verifyUser(LoginBean loginBean);
	RegistrationBean addUser(RegistrationBean rBean);
}
