package com.project.twoendpoints.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.twoendpoints.entity.HelloWorld;

@RestController
public class HelloWorldController {

	@GetMapping(path = { "/hello-world", "/hello-world/{name}" })
	public HelloWorld helloWorldPathVariable(@PathVariable Optional<String> name) {
		StringBuilder helloWorld = new StringBuilder("Hello, World");
		if (name.isPresent()) {
			Integer indexOfComma = helloWorld.indexOf(",");
			helloWorld.deleteCharAt(indexOfComma);
			helloWorld.append(", ").append(name.get());
		}
		return new HelloWorld(String.format(helloWorld.toString()));
	}
}
