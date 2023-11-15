package com.project.LapStore;

import com.project.LapStore.controller.MemberController;
import com.project.LapStore.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@SpringBootApplication
@ComponentScan(
		basePackages = {"com.project.LapStore"}
)
public class LapStoreApplication {

	private static final Logger logger = LoggerFactory.getLogger(LapStoreApplication.class);

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(LapStoreApplication.class, args);

		MemberController memberController = applicationContext.getBean(MemberController.class);
		logger.info("memberController -> {}", memberController.getClass().getName());

		while(true){
			memberController.outputMenu();
		}
	}

}
