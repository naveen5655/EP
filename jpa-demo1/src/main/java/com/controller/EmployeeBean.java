package com.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.Employee;
import com.model.EmployeeRemote;

@ManagedBean(name = "emp" , eager = true)
public class EmployeeBean
{
	int empid ;
	String name;
	int salary;
	String ack;
	
	@EJB(lookup = "java:global/jpa-demo1/EmployeeModel!com.model.EmployeeRemote")
	EmployeeRemote ER;
	
	public void callinsert()
	{
		try
		{
			Employee E = new Employee();
			E.setEmpid(empid);
			E.setName(name);
			E.setSalary(salary);
			
			ack = ER.insertData(E);
			
		}
		catch(Exception e)
		{
			ack = e.getMessage();
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
	public String getAck() {
		return ack;
	}
	public void setAck(String ack) {
		this.ack = ack;
	}
	

}
