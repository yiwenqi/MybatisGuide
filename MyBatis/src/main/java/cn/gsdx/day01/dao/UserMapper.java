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
     * ���� Map ���� <Integer,User> ,IntegerΪ����
     * @param name ģ�����
     * @return ����һ��map����
     */
    @MapKey("name")
    public Map<String,User> queryUserByNameReturnMap(String name);

    /**
     * ���� Map ���� ����Ϊkey ��ֵΪvalue
     * @param name ģ�����
     * @return ����һ��map����
     */
    public Map<String,Object> queryUserReturnMap(String name);

    /**
     * ģ����ѯ
     * @param nameLike ģ�����
     * @return ����һ��List����
     */
    public List<User> queryUserByNameLike(String nameLike);

    /**
     * ��ѯ�û� by id
     * @param id id
     * @return User
     */
    public User queryUser(int id);

    /**
     * ����û�
     * @param user �û�
     * @return ����ֵ
     */
    public boolean addUser(User user);

    /**
     * �����û�
     * @param user �û�
     * @return ����ֵ
     */
    public boolean updateUser(User user);

    /**
     * ����idɾ���û�
     * @param id ��ʶ
     * @return ����ֵ
     */
    public boolean deleteUser(Integer id);
}
