# 简述

Spring Boot Test + Junit 的示例项目
source ：[spring-boot-testing-sample](https://github.com/fanlychie/spring-boot-samples/tree/master/spring-boot-testing-sample)

## 注解说明

### @SpringBootApplication

@SpringBootApplication is a convenience annotation that adds all of the following:
@Configuration: Tags the class as a source of bean definitions for the application context.

@EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.

@EnableWebMvc: Flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet. Spring Boot adds it automatically when it sees spring-webmvc on the classpath.

@ComponentScan: Tells Spring to look for other components, configurations, and services in the the com.example.testingweb package, letting it find the HelloController class.

### @SpringBootTest

The @SpringBootTest annotation tells Spring Boot to look for a main configuration class (one with @SpringBootApplication, for instance) and use that to start a Spring application context.

该注解是普通的 Spring 项目（非 Spring Boot 项目）中编写集成测试代码所使用的@ContextConfiguration注解的替代品
@ContextConfiguration 普通的 Spring 项目（非spring boot项目中使用）

<!-- SpringBootConfiguration
ContextConfiguration -->
