package com.techm.spring.dao;

import com.techm.spring.bean.LoginBean;
import com.techm.spring.bean.RegistrationBean;

public interface Dao {
	LoginBean verifyUser(LoginBean loginBean);
	RegistrationBean addUser(RegistrationBean rBean);
}
