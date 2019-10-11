package com.rest.exception.handler.handler.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorReferencePageController {
	
	private static final String PATH = "/error";

	@RequestMapping("/docs/errors/404")
	public String errorCode404() {
		return "404.html";
	}
	
	@RequestMapping("/docs/errors/409")
	public String errorCode409() {
		return "409.html";
	}

}
