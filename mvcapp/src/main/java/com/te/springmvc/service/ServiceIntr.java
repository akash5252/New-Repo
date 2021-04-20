package com.te.springmvc.service;

import com.te.springmvc.bean.EmployeeBean;

public interface ServiceIntr {
	public EmployeeBean authenticate(int id, String password);

	public EmployeeBean getEmployee(int id);

	public boolean deleteEmploye(int id);

	public java.util.List<EmployeeBean> getAllData();

}
