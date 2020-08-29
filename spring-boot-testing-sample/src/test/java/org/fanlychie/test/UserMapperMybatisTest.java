package org.fanlychie.test;

import org.fanlychie.dao.UserMapper;
import org.fanlychie.entity.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by creasypita on 8/29/2020.
 *
 * @ProjectName: spring-test
 */
@RunWith(SpringRunner.class)
@MybatisTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("test")

@MapperScan("org.fanlychie.dao")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserMapperMybatisTest {

    @SpringBootApplication(scanBasePackages = "org.fanlychie")
    static class InnerConfig { }


    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback(false)
    public void testSave() {
        User user = new User();
        user.setName("fanlychie");
        userMapper.insertUser(user);
        System.out.println("====================================");
        System.out.println(userMapper.findAllUsers());
        System.out.println("====================================");
    }
}
