package cn.gsdx.day01.entity;

import java.io.Serializable;

/**
 * @author JackWen
 */
public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private String departmentId;
    private Department department;

    public User() {
    }

    public User(Integer id, String name, String password,String departmentId, Department department) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.departmentId = departmentId;
        this.department = department;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ",departmentId="+ departmentId+
                '}';
    }
}
