package cn.gsdx.day01.dao;

import cn.gsdx.day01.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author JackWen
 * ע�⿪��
 */
public interface UserMapperAnnotation {
    /**
     * ��ѯ�û� by id
     * @param id id
     * @return User
     */
    @Select("select * from user where id = #{id}")
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
