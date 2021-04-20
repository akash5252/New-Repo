package com.te.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.springmvc.bean.EmployeeBean;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public EmployeeBean authenticate(int id, String password) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("spring");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			EmployeeBean bean = entityManager.find(EmployeeBean.class, id);
			System.out.println(bean);
			if (bean != null) {
				if (bean.getPassword().equals(password)) {
					System.out.println("login successfull");
					return bean;

				} else {
					System.out.println("invalid Credentials");
					return null;
				}
			} else {
				System.out.println("user not found");
				return null;

			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	@Override
	public EmployeeBean getEmployee(int id) {

		EntityManagerFactory enFactory = Persistence.createEntityManagerFactory("spring");
		EntityManager manager = enFactory.createEntityManager();
		EmployeeBean bean2 = manager.find(EmployeeBean.class, id);
		return bean2;
	}

	@Override
	public boolean deleteEmploye(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("spring");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

		EmployeeBean bean = manager.find(EmployeeBean.class, id);
		if (bean != null) {
			manager.remove(bean);
			System.out.println("deleted su");
			transaction.commit();
			return true;
		} else {
			System.out.println("not del");
			return false;
		}
	}

	@Override
	public List<EmployeeBean> getAllData() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("spring");

		EntityManager manager = factory.createEntityManager();

		String query = "from EmployeeBean";

		javax.persistence.Query query2 = manager.createQuery(query);

		List<EmployeeBean> list = query2.getResultList();
		if (list != null) {
			return list;
		} else {
			return null;
		}

	}
}
