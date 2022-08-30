package com.example.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="mybatis")
public class MyBatisSetting {
	private Resource configLocation;
	private String mapperLocations;
}
