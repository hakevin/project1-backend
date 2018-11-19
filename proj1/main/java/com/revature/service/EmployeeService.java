package com.revature.service;

import com.revature.DAO.EmployeeDAOImpl;
import com.revature.beans.EmployeeBean;

public class EmployeeService {

	EmployeeDAOImpl uDao = new EmployeeDAOImpl();
	EmployeeBean eBean = new EmployeeBean();

	// return true or false if user exists
	public EmployeeBean usernameAndPasswordValidation(String userName, String password) {

		eBean = uDao.login(userName);
		if (eBean != null) {
			if (password.equals(eBean.getPassword())) {
				return eBean;				 
			}

		}
		return null;
	}

}
