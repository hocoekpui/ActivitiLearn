package com.example.activitilearn.mapper;


import com.example.activitilearn.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface UserInfoBeanMapper {

    @Select("select * from user where username = #{username}")
    UserInfo selectByUsername(@Param("username") String username);
}
