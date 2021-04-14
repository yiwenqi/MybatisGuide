package cn.gsdx.day01.dao;

import cn.gsdx.day01.entity.User;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @author john
 */
public interface UserMapper {
    /**
     * 返回 Map 集合 <Integer,User> ,Integer为主键
     * @param name 模糊语句
     * @return 返回一个map集合
     */
    @MapKey("name")
    public Map<String,User> queryUserByNameReturnMap(String name);

    /**
     * 返回 Map 集合 列名为key ，值为value
     * @param name 模糊语句
     * @return 返回一个map集合
     */
    public Map<String,Object> queryUserReturnMap(String name);

    /**
     * 模糊查询
     * @param nameLike 模糊语句
     * @return 返回一个List集合
     */
    public List<User> queryUserByNameLike(String nameLike);

    /**
     * 查询用户 by id
     * @param id id
     * @return User
     */
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
