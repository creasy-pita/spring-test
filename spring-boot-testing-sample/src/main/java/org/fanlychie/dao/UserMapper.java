package org.fanlychie.dao;

import org.apache.ibatis.annotations.Mapper;
import org.fanlychie.entity.User;

import java.util.List;

/**
 * Created by creasypita on 8/29/2020.
 *
 * @ProjectName: spring-test
 */
@Mapper
public interface UserMapper {
//    User selectCityById(int id);

    List<User> findAllUsers();

    int insertUser(User user);
}
