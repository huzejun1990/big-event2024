package com.dream.mapper;

import com.dream.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: huzejun
 * @Date: 2024/9/30 14:30
 */
@Mapper
public interface UserMapper {
    //根据用户名查询用户
    @Select("select * from user where username = #{username}")
    User findByUserName(String username);

    //添加
    @Insert("insert into user(username,password,create_time,update_time)" +
            " values (#{username},#{password},now(),now())")
    void add(String username, String password);
//    void add(String username, String md5String);

/*    @Insert("insert into user(username,password,create_time,update_time)" +
            " values(#{username},#{password},now(),now())")
    void add(String username, String password);*/
}
