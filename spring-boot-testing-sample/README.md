# 简述

Spring Boot Test + Junit 的示例项目
source ：[spring-boot-testing-sample](https://github.com/fanlychie/spring-boot-samples/tree/master/spring-boot-testing-sample)

reference:

- [spring-boot-testing.html](http://fanlychie.github.io/post/spring-boot-testing.html)
- [boot-features-testing.html](https://docs.spring.io/spring-boot/docs/2.0.4.RELEASE/reference/html/boot-features-testing.html)

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

### @ActiveProfiles

> ActiveProfiles is a class-level annotation that is used to declare which active bean definition profiles should be used when loading an ApplicationContext for test classes.

Meaning it is only supposed to be used to declare active Spring profiles for test classes. So If put it on a Configuration class it should have no effect.

simmilar to below in test scenario 

- Set spring.profiles.active=test in test/resources/application-default.properties.
- Add test/resources/application-test.properties for tests and override only the properties you need.

> 示例项目开发环境：Java-8、Maven-3、IntelliJ IDEA-2017、Spring Boot-1.5.2.RELEASE
> :bulb: Spring Boot 2.5.3.RELEASE 可能在配置的写法有所不同，需要测试
