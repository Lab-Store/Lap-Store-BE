package com.project.LapStore;

import com.project.LapStore.controller.MemberController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class MemberTester {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MemberController memberController = applicationContext.getBean(MemberController.class);

        memberController.outputMenu();

        applicationContext.close();
    }
}
