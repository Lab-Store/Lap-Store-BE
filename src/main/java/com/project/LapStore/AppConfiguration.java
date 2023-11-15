package com.project.LapStore;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(
  basePackages = {"com.project.LapStore"}
)
@PropertySource(value = "application.yaml")
@EnableConfigurationProperties
public class AppConfiguration {
}
