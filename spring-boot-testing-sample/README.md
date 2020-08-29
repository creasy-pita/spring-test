# 简述

Spring Boot Test + Junit 的示例项目
source ：[spring-boot-testing-sample](https://github.com/fanlychie/spring-boot-samples/tree/master/spring-boot-testing-sample)

reference:

- :star::star::star::star:[spring-boot-testing.html](http://fanlychie.github.io/post/spring-boot-testing.html)
- :star::star::star::star::star:[boot-features-testing.html](https://docs.spring.io/spring-boot/docs/2.0.4.RELEASE/reference/html/boot-features-testing.html)
- :star::star::star::star:[基于spring-boot的单元和集成测试方案](https://zhuanlan.zhihu.com/p/67801427)

## 注解说明

### @SpringBootApplication

@SpringBootApplication is a convenience annotation that adds all of the following:
@Configuration: Tags the class as a source of bean definitions for the application context.

@EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.

@EnableWebMvc: Flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet. Spring Boot adds it automatically when it sees spring-webmvc on the classpath.

@ComponentScan: Tells Spring to look for other components, configurations, and services in the the com.example.testingweb package, letting it find the HelloController class.

@SpringBootApplication扩展自@Configuration，其scanBasePackages属性指定了扫描的根路径。确保测试目标类在这个路径下，而且需要明白这个路径下的所有bean都会被实例化。虽然我们已经尽可能的缩小了实例化的范围，但是我们没有避免其他无关类的实例化开销。

即使如此，这种方案依然被我看作是最佳的实践方案，因为它比较简单。如果我们追求“只实例化目标类”，那么可以使用下面的方式声明内嵌类：

```java
@Configuration
@ComponentScan(value = "org.fanlychie",
        useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(
                type = FilterType.REGEX,
                pattern = {"org.fanlychie.HelloService"})
)
static class InnerConfig { }
```

### @SpringBootTest

The @SpringBootTest annotation tells Spring Boot to look for a main configuration class (one with @SpringBootApplication, for instance) and use that to start a Spring application context.
@SpringBootTest注解负责扫描配置来构建测试用的Spring上下文环境。它默认搜索@SpringBootConfiguration类，除非我们通过classes属性指定配置类，或者通过自定义内嵌的@Configuration类来指定配置
该注解是普通的 Spring 项目（非 Spring Boot 项目）中编写集成测试代码所使用的@ContextConfiguration注解的替代品
@ContextConfiguration 普通的 Spring 项目（非spring boot项目中使用）

### @RunWith

声明测试是在spring环境下运行的，这样就可以启用Spring的相关支持。

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

## 测试框架如何集成到正式项目

- 每个测试类可以定义内部的static class @SpringBootApplication
这样可以做到单个测试类直接测试

比如

```java
@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @SpringBootApplication(scanBasePackages = "org.fanlychie")
    static class InnerConfig { }
}
```

- 测试类根据自定义可以是 mvctest,jpatest,servicetest,beaninjecttest等
- spring boot的applicat.yml配置可以根据@ActiveProfiles来指定
