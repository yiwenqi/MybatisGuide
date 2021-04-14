package cn.gsdx.day01.dao;

import cn.gsdx.day01.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JackWen
 * 动态sql
 */
public interface UserMapperDynamic {

    /**
     * 测试两大参数———_Parameter和_databaseId
     * @param id
     * @return
     */
    public User queryUserTest(Integer id);
    /**
     * 测试 mapper中 if 和 where 的使用
     * @param user 传入的参数
     * @return 返回 user 用户
     */
    public User queryUserByAllInfo(User user);

    /**
     * 测试 mapper 中 trim 标签的使用
     * @param user 用户信息
     * @return 用户
     */
    public User queryUserByTrim(User user);

    /**
     * 测试 mapper 中 choose 标签的使用
     * @param user 用户信息
     * @return 用户
     */
    public User queryUserByChoose(User user);

    /**
     * 测试 mapper 中 set 标签的使用
     * @param user 用户信息
     * @return 是否成功
     */
    public boolean updateUser(User user);

    /**
     * 测试 mapper 中 forEach 标签的使用
     * @param ids 用户编号集合
     * @return 用户
     */
    public List<User> queryUserByForEach(@Param("ids") List<Integer> ids);

    /**
     * 测试批量保存
     * @param users 要保存的用户列表
     * @return  是否保存成功
     */
    public boolean addUsers(@Param("users") List<User> users);

    /**
     * 测试 bind 绑定标签
     * @param name
     * @return
     */
    public User queryUserByLikeName(@Param("name") String name);



}
