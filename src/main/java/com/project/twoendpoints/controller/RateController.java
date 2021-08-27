package com.project.twoendpoints.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.twoendpoints.constant.Constants;
import com.project.twoendpoints.entity.Rate;

@RestController
public class RateController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(path = "/rates")
	public List<Rate> getRatesInfo(@PathVariable Optional<String> currency) {

		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(Constants.RATES_URL, Object[].class);
		Object[] objects = responseEntity.getBody();

		ObjectMapper mapper = new ObjectMapper();

		return Arrays.stream(objects).map(object -> mapper.convertValue(object, Rate.class))
				.collect(Collectors.toList());
	}

	@GetMapping(path = "/rates/{currency}")
	public Rate getRateCurrency(@PathVariable Optional<String> currency) {

		StringBuilder urlBuilder = new StringBuilder(Constants.RATES_URL);

		if (currency.isPresent()) {
			urlBuilder.append(currency.get());
		}

		ResponseEntity<Rate> responseEntity = restTemplate.getForEntity(urlBuilder.toString(), Rate.class);
		Rate rate = responseEntity.getBody();

		return rate;
	}
}
