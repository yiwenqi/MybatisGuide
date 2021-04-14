package cn.gsdx.day01.dao;

import cn.gsdx.day01.entity.Department;
import cn.gsdx.day01.entity.User;

import java.util.List;

/**
 * @author JackWen
 * ��ǿ��ӿ�
 */
public interface UserMapperPlus {
    /**
     * ͨ�� id ��ѯ
     * @param id id
     * @return �û�
     */
    public User queryUser(Integer id);

    /**
     * ������һ��
     * ��������Ϊ�� Department
     * @param id
     * @return
     */
    public User queryUserPlus(Integer id);

    /**
     * ͨ�� name �����û� ����������Ϊ list ��
     * @param name �û�����
     * @return
     */
    public Department queryDepartmentByName(String name);

    /**
     * ͨ�� name �����û� ����������Ϊ list ��,�ֲ���ѯ
     * @param name �û�����
     * @return
     */
    public List<Department> queryDepartmentByNameStep(String name);

    /**
     * ͨ�����ű�Ų�ѯ�û�
     * @param departmentId ���ű��
     * @return
     */
    public List<User> queryUserByDepartmentId(Integer departmentId);
}
