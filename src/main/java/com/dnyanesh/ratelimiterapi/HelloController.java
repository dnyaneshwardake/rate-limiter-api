package com.dnyanesh.ratelimiterapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	@RateLimiter(name = "hello-rate-limiter")
	public String hello() {
		
		return "Welcome!";
	}

}
