package com.example.SpringBoot25.contoller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import com.example.SpringBoot25.entity.Dep;
import com.example.SpringBoot25.entity.Emp;

@Controller
public class MyController {
	
	@RequestMapping("/login")
	public String login(String uname,String password,
			HttpSession session,Model model) {
		if(StringUtils.isEmpty(uname)) {
			model.addAttribute("msg", "用户名不能为空");
			return "login";
		}
		if(StringUtils.isEmpty(password)) {
			model.addAttribute("msg", "密码不能为空");
			return "login";
		}
		if(!"aaa".equals(password)) {
			model.addAttribute("msg", "密码错误");
			return "login";
		}
		session.setAttribute("uname", uname);
		//重定向解决post提交刷新网页问题，自定义
		return "redirect:/my";
	}
	
	@RequestMapping("/doFirst.do")
	public String doFirst() {
		return "forward:/test.html";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("uname");
		return "login";
	}
	
	@GetMapping("/emps")
	public String selectAllEmps(Model model) {
		List<Emp> emps=new ArrayList<Emp>();
		emps.add(new Emp(1, "zs", new Date(), new Dep(1, "01")));
		emps.add(new Emp(2, "ls", new Date(), new Dep(2, "02")));
		model.addAttribute("emps", emps);
		return "selectemps";
	}
	
	@GetMapping("/emp")
	public String toAddEmp(Model model) {
		List<Dep> deps=new ArrayList<Dep>();
		deps.add(new Dep(1, "01"));
		deps.add(new Dep(2, "02"));
		model.addAttribute("deps", deps);
		return "addemp";
	}
	
	@PostMapping("/emp")
	public String addEmp(String ename,String date) {
		System.out.println("添加用户"+ename+date);
		return "redirect:/emps";
	}
	
	@GetMapping("/emp/{eid}")
	public String updateEmp(@PathVariable("eid") Integer eid,Model model) {
		Emp emp=null;
		if(eid==1) {
			emp=new Emp(1, "zs", new Date(), new Dep(1, "01"));
		}else if(eid==2){
			emp=new Emp(2, "ls", new Date(), new Dep(2, "02"));
		}
		model.addAttribute("emp", emp);
		List<Dep> deps=new ArrayList<Dep>();
		deps.add(new Dep(1, "01"));
		deps.add(new Dep(2, "02"));
		model.addAttribute("deps", deps);
		return "updateemp";
	}
	
	@PutMapping("/emp")
	public String updateEmp(String ename,String date) {
		System.out.println("修改用户"+ename+date);
		return "redirect:/emps";
	}
	
	@DeleteMapping("/emp/{eid}")
	public String deleteEmp(@PathVariable("eid") Integer eid) {
		System.out.println("删除用户"+eid);
		return "redirect:/emps";
	}
}
