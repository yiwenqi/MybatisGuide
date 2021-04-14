package cn.gsdx.day01.dao;

import cn.gsdx.day01.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author JackWen
 * 注解开发
 */
public interface UserMapperAnnotation {
    /**
     * 查询用户 by id
     * @param id id
     * @return User
     */
    @Select("select * from user where id = #{id}")
    public User queryUser(int id);

    /**
     * 添加用户
     * @param user 用户
     * @return 布尔值
     */
    public boolean addUser(User user);

    /**
     * 更新用户
     * @param user 用户
     * @return 布尔值
     */
    public boolean updateUser(User user);

    /**
     * 根据id删除用户
     * @param id 标识
     * @return 布尔值
     */
    public boolean deleteUser(Integer id);
}
