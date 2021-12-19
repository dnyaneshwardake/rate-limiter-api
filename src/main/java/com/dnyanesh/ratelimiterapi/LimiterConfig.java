package com.dnyanesh.ratelimiterapi;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;

@Configuration
public class LimiterConfig {

	@Bean
	public RateLimiter rateLimiter() {
		RateLimiterConfig config = RateLimiterConfig.custom()
				.limitRefreshPeriod(Duration.ofSeconds(5))
				.limitForPeriod(2)
				.timeoutDuration(Duration.ofSeconds(5))
				.build();

		RateLimiterRegistry limiterRegistry = RateLimiterRegistry.of(config);

		RateLimiter rateLimiter = limiterRegistry.rateLimiter("hello-rate-limiter");

		return rateLimiter;
	}

}
