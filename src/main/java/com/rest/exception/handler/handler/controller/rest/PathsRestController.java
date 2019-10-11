package com.rest.exception.handler.handler.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rest.exception.handler.handler.domain.Paths;

@RestController
public class PathsRestController {

	@JsonSerialize
	@RequestMapping("/rest")
	public ResponseEntity<Paths> getAllPaths(){
		Paths paths = new Paths();
		List<String> path = new ArrayList<>();
		path.add("/rest");
		path.add("/rest/v1");
		path.add("/rest/v1/credits");
		path.add("/rest/v1/credits/{id}");
		paths.setPaths(path);
		return new ResponseEntity<>(paths, HttpStatus.OK);
	}
}
