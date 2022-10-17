package com.adminbillar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.adminbillar.config.RsaKeyProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class AdminBillarApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminBillarApplication.class, args);
	}

}
