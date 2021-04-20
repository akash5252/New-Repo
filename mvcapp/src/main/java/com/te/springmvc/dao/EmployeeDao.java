package com.te.springmvc.dao;

import com.te.springmvc.bean.EmployeeBean;

public interface EmployeeDao {

	public EmployeeBean authenticate(int id, String password);

	public EmployeeBean getEmployee(int id);

	public boolean deleteEmploye(int id);

	public java.util.List<EmployeeBean> getAllData();

}
