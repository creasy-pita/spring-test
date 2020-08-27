package com.creasypita.example.spring;

/**
 * Created by creasypita on 8/27/2020.
 *
 * @ProjectName: spring-test
 */
public class HelloWorld {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Spring 3 : Hello ! " + name);
    }
}
