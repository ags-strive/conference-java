package com.pluralsight;

import com.pluralsight.service.SpeakerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SpeakerService service = appContext.getBean("speakerService", SpeakerService.class);
        // SpeakerService service2 = appContext.getBean("speakerService", SpeakerService.class); // clone to test singleton/prototype

        System.out.println("original service => " + service);
        // System.out.println("clone service => " + service2);

        System.out.println("name: " + service.findAll().get(0).getFirstName());
        System.out.println("seed: " + service.findAll().get(0).getSeedNum());
    }
}
