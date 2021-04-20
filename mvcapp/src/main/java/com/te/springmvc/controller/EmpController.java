package com.te.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvc.bean.EmployeeBean;
import com.te.springmvc.dao.EmployeeDaoImpl;
import com.te.springmvc.service.ServiceImpl;



@Controller
public class EmpController {

	@Autowired
	private ServiceImpl service;

	@GetMapping("/emplogin")
	public String getLoginForm() {
		return "empLogin";
	}

	@PostMapping("/emplogin")
	public String authenticate(int id, String password, HttpServletRequest request, ModelMap map) {
		EmployeeBean employeeBean = service.authenticate(id, password);
		System.out.println(employeeBean);
		if (employeeBean != null) {
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("emp", employeeBean);
			return "homePage";
		} else {
			map.addAttribute("errmsg", "invalid credential");
			return "empLogin";
		}
	}

	@GetMapping("/search")
	public String getSearchForm(ModelMap map, HttpSession session) {
		if (session.getAttribute("emp") != null) {
			return "search";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "empLogin";
		}

	}

	@GetMapping("/search1")
	public String searchEmp(int id, ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			EmployeeBean employeeBean2 = service.getEmployee(id);
			if (employeeBean2 != null) {
				map.addAttribute("data", employeeBean2);
			} else {
				map.addAttribute("data", "data not found for id :" + id);
			}
			return "search";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "empLogin";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "logout successfull");
		return "empLogin";
	}
	@GetMapping("/getdelete")
	public String getDeleteForm(ModelMap map, @SessionAttribute(name = "emp", required = false) EmployeeBean bean) {
		if (bean != null) {
			return "delete";
		} else {
			map.addAttribute("msg", "please login first");
			return "empLogin";
		}

	}
	@GetMapping("/delete")
	public String deleteEmployee(int id, @SessionAttribute(name = "emp", required = false) EmployeeBean bean,
			ModelMap map) {
		if (bean != null) {
			boolean deleted = service.deleteEmploye(id);
			if (deleted == true) {
				map.addAttribute("msg", "deleted successfully");
				return "delete";
			} else {
				map.addAttribute("errmsg", "user not found");
				return "delete";
			}

		}

		return null;

	}
	@GetMapping("/viewall")
	public String viewAllEmployee(ModelMap map, @SessionAttribute(name = "emp", required = false) EmployeeBean bean) {
		if (bean != null) {
			List<EmployeeBean> employeeBeans = service.getAllData();
			map.addAttribute("empdata", employeeBeans);
			return "alldata";
		} else {
			map.addAttribute("msg", "no employees found");
			return "alldata";
		}

	}

	 
}
