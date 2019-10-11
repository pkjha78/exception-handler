package com.rest.exception.handler.handler.domain;

import java.util.List;

import javax.persistence.Embedded;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
public class Paths {
	@Embedded
	@JsonSerialize
	private List<String> paths;
}
