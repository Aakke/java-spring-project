package com.github.aakke.javaspringproject.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Spring MVC controller.
public class HomePageController {

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
}
