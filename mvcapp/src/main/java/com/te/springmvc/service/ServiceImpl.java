package com.te.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springmvc.bean.EmployeeBean;
import com.te.springmvc.dao.EmployeeDaoImpl;
@Service
public class ServiceImpl implements ServiceIntr {

	@Autowired
	EmployeeDaoImpl dao;
	@Override
	public EmployeeBean authenticate(int id, String password) {
		
		return dao.authenticate(id, password);
	}

	@Override
	public EmployeeBean getEmployee(int id) {
		
		return dao.getEmployee(id);
	}

	@Override
	public boolean deleteEmploye(int id) {
		
		return dao.deleteEmploye(id);
	}

	@Override
	public List<EmployeeBean> getAllData() {
		// TODO Auto-generated method stub
		return dao.getAllData();
	}

}
