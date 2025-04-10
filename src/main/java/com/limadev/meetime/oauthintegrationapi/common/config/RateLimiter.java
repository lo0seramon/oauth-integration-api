package com.limadev.meetime.oauthintegrationapi.common.config;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Configuration
public class RateLimiter {
    @Bean
    public Bucket configRateLimiter() {
        Bandwidth limit = Bandwidth.builder()
                .capacity(130)
                .refillIntervally(1130, Duration.ofSeconds(10))
                .build();

        return Bucket.builder().addLimit(limit).build();
    }
}
