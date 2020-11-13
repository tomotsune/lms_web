package io.tomo.lms.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID = -3173053675544046248L;

    private String id;
    private String pwd;
    private Integer type;
    private String name;
    private String unit;
    private String telephone;
    private Integer count;

    public User(String id, Integer type) {
        this.id = id;
        this.type = type;
    }

    public User(String id, String pwd, Integer type, String name, String unit, String telephone, Integer count) {
        this.id = id;
        this.pwd = pwd;
        this.type = type;
        this.name = name;
        this.unit = unit;
        this.telephone = telephone;
        this.count = count;
    }

    public User(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
        this.type = 1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(pwd, user.pwd) &&
                Objects.equals(type, user.type) &&
                Objects.equals(name, user.name) &&
                Objects.equals(unit, user.unit) &&
                Objects.equals(telephone, user.telephone) &&
                Objects.equals(count, user.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pwd, type, name, unit, telephone, count);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", telephone='" + telephone + '\'' +
                ", count=" + count +
                '}'+
                "\n";
    }
}
