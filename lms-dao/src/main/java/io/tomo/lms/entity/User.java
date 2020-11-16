package io.tomo.lms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public User(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
        this.type = 1;
    }

}
