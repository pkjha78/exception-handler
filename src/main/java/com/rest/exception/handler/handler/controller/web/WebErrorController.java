package com.rest.exception.handler.handler.controller.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebErrorController implements ErrorController {
	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public String error() {
		return "redirect:/error.html";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}
