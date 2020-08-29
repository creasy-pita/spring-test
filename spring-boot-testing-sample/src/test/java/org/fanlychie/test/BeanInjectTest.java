package org.fanlychie.test;

import org.fanlychie.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by fanlychie on 2017/7/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BeanInjectTest {

    @SpringBootApplication(scanBasePackages = "org.fanlychie")
    static class InnerConfig { }

    @Autowired
    private HelloService helloService;

    @Test
    public void testSayHi() {
        System.out.println(helloService.sayHi());
    }

}