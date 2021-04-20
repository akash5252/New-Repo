package com.te.springmvc.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="employe_info")
public class EmployeeBean implements Serializable {

	@Id
	@Column(name="Id")
	private Integer id;
	@Column
	private String name;
	@Column(name="dob")
	private Date birthdate;
	@Column
	private String password;
	
}
