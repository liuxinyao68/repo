package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ConfigurationProperties(prefix="spring.datasource")
@Getter
@Setter
@ToString
@Component
public class DuridConfig {
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private int initSize;
	private int maxActive;
	private int minIdle;
	private long maxWait;
	private boolean testOnReturn;
}
