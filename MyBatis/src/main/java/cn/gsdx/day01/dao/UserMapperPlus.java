package cn.gsdx.day01.dao;

import cn.gsdx.day01.entity.Department;
import cn.gsdx.day01.entity.User;

import java.util.List;

/**
 * @author JackWen
 * 增强版接口
 */
public interface UserMapperPlus {
    /**
     * 通过 id 查询
     * @param id id
     * @return 用户
     */
    public User queryUser(Integer id);

    /**
     * 和上面一样
     * 级联属性为： Department
     * @param id
     * @return
     */
    public User queryUserPlus(Integer id);

    /**
     * 通过 name 返回用户 （级联属性为 list ）
     * @param name 用户名字
     * @return
     */
    public Department queryDepartmentByName(String name);

    /**
     * 通过 name 返回用户 （级联属性为 list ）,分步查询
     * @param name 用户名字
     * @return
     */
    public List<Department> queryDepartmentByNameStep(String name);

    /**
     * 通过部门编号查询用户
     * @param departmentId 部门编号
     * @return
     */
    public List<User> queryUserByDepartmentId(Integer departmentId);
}
