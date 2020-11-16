package io.tomo.lms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class List {
    private Integer serialNo;
    private String id;
    private Integer no;
    private Date date;
    private Integer type;
    private String operator;

}
