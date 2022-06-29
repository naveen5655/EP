package com.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Employee;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class EmployeeModel implements EmployeeRemote
{

	@Override
	public String insertData(Employee E) throws Exception
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return "Record inserted successfully...";
	}

	@Override
	public List<Employee> readData() throws Exception 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query qry = em.createQuery("select e from Employee e");
		@SuppressWarnings("unchecked")
		List<Employee> L = qry.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return L;
	}

	@Override
	public String updateData(int empid, Employee E) throws Exception
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee data = em.find(Employee.class, empid);
		data.setEmpid(E.getEmpid());
		data.setName(E.getName());
		data.setSalary(E.getSalary());
		em.getTransaction().commit();
		em.close();
		emf.close();
		return "Record updated successfully...";
	}

	@Override
	public String deleteData(int empid) throws Exception 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee E = em.find(Employee.class, empid);
		em.remove(E);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return "Record deleted successfully...";
	}

	@Override
	public Employee findData(int empid) throws Exception 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee E = em.find(Employee.class, empid);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return E;
	}

}
