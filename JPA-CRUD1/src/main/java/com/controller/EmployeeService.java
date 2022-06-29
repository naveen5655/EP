package com.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.Employee;
import com.model.EmployeeRemote;

@ManagedBean(name = "emp", eager = true)
public class EmployeeService 
{
	int empid;
	String name;
	int salary;
	String res;
	
	List<Employee> list;
	
	@EJB(lookup = "java:global/jpa-crud01/EmployeeModel!com.model.EmployeeRemote")
	EmployeeRemote ER;
	
	public void find()
	{
		try
		{
			Employee E = ER.findData(empid);
			empid = E.getEmpid();
			name = E.getName();
			salary = E.getSalary();
			
		}catch(Exception e)
		{
			res = e.getMessage();
		}
	}
	
	public void delete()
	{
		try
		{
			res = ER.deleteData(empid);
		}catch(Exception e)
		{
			res  = e.getMessage();
		}
	}
	
	public void update()
	{
		try
		{
			Employee E=new Employee();
			E.setEmpid(empid);
			E.setName(name);
			E.setSalary(salary);
			res = ER.updateData(empid, E);
		}catch(Exception e)
		{
			res = e.getMessage();
		}
	}
	
	public void insert()
	{
		try
		{
			Employee E=new Employee();
			E.setEmpid(empid);
			E.setName(name);
			E.setSalary(salary);
			res = ER.insertData(E);
		}catch(Exception e)
		{
			res = e.getMessage();
		}
	}
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}

	public List<Employee> getList() 
	{
		try
		{
			list = ER.readData();
		}catch(Exception e)
		{
			res = e.getMessage();
		}
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}
}
