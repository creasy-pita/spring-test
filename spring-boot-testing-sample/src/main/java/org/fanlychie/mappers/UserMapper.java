package org.fanlychie.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
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
//    @Select("select * from user")
    public List<User> findAllUsers();


//    @Insert("insert into user(id,name) values(#{id},#{name})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insertUser(User user);
}
