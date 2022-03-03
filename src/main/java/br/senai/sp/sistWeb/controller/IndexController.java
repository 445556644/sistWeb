package br.senai.sp.sistWeb.controller;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {

	@RequestMapping("Index")
	public String Index() {
	
		return "index";
	}
}
