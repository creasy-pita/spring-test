package com.creasypita.example.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by creasypita on 8/27/2020.
 *
 * @ProjectName: spring-test
 */
public class SpringApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-config.xml");

        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        obj.printHello();
        DataModelService dataModelService = ((MachineLearningService) context.getBean("ml"));
        System.out.println(dataModelService.isValid("it is invalid"));
    }
}
