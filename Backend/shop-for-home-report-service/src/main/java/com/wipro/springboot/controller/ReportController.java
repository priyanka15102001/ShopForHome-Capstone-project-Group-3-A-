package com.wipro.springboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
public class ReportController {

	private RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/report")
	public String report() {
		String uri = "http://localhost:8087/sales-log";
		String responseMsg = restTemplate.getForObject(uri, String.class);
		return responseMsg;

	}

}
