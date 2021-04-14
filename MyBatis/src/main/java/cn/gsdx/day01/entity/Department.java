package cn.gsdx.day01.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author JackWen
 * ²¿ÃÅ±í
 */
public class Department implements Serializable {
    private Integer id;
    private String departmentName;
    private List<User> users ;


    public Department() {
    }

    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", users=" + users +
                '}';
    }
}
