package cn.gsdx.day01.dao;

import cn.gsdx.day01.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JackWen
 * ��̬sql
 */
public interface UserMapperDynamic {

    /**
     * �����������������_Parameter��_databaseId
     * @param id
     * @return
     */
    public User queryUserTest(Integer id);
    /**
     * ���� mapper�� if �� where ��ʹ��
     * @param user ����Ĳ���
     * @return ���� user �û�
     */
    public User queryUserByAllInfo(User user);

    /**
     * ���� mapper �� trim ��ǩ��ʹ��
     * @param user �û���Ϣ
     * @return �û�
     */
    public User queryUserByTrim(User user);

    /**
     * ���� mapper �� choose ��ǩ��ʹ��
     * @param user �û���Ϣ
     * @return �û�
     */
    public User queryUserByChoose(User user);

    /**
     * ���� mapper �� set ��ǩ��ʹ��
     * @param user �û���Ϣ
     * @return �Ƿ�ɹ�
     */
    public boolean updateUser(User user);

    /**
     * ���� mapper �� forEach ��ǩ��ʹ��
     * @param ids �û���ż���
     * @return �û�
     */
    public List<User> queryUserByForEach(@Param("ids") List<Integer> ids);

    /**
     * ������������
     * @param users Ҫ������û��б�
     * @return  �Ƿ񱣴�ɹ�
     */
    public boolean addUsers(@Param("users") List<User> users);

    /**
     * ���� bind �󶨱�ǩ
     * @param name
     * @return
     */
    public User queryUserByLikeName(@Param("name") String name);



}
