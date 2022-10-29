package xyz.xiashuo.mapper;

import xyz.xiashuo.domain.User;

import java.util.List;

// 对应domain 包下的 User
// 对应 Mysql 中的 t_user 表
public interface UserMapper {

    /**
     * * 添加用户信息
     */
    int insertUser();

    int updateUser();

    int deleteUser();

    User getUser();

    List<User> getUsers();


}
