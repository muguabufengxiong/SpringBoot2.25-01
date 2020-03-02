package com.example.SpringBoot25.entity;

import java.util.Date;

public class Emp {
	Integer eid;
	String ename;
	Date date;
	Dep dep;
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(Integer eid, String ename, Date date, Dep dep) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.date = date;
		this.dep = dep;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Dep getDep() {
		return dep;
	}
	public void setDep(Dep dep) {
		this.dep = dep;
	}
	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", date=" + date + ", dep=" + dep + "]";
	}
	
}
