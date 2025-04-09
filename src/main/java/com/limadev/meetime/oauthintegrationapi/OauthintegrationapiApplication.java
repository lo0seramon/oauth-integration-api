package com.limadev.meetime.oauthintegrationapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OauthintegrationapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthintegrationapiApplication.class, args);
	}

}
