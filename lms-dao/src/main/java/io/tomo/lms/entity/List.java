package io.tomo.lms.entity;

import java.util.Date;
import java.util.Objects;

public class List {
    private Integer serialNo;
    private String id;
    private Integer no;
    private Date date;
    private Integer type;
    private String operator;

    public List(Integer serialNo, String id, Integer no, Date date, Integer type, String operator) {
        this.serialNo = serialNo;
        this.id = id;
        this.no = no;
        this.date = date;
        this.type = type;
        this.operator = operator;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof List)) return false;
        List list = (List) o;
        return Objects.equals(serialNo, list.serialNo) &&
                Objects.equals(id, list.id) &&
                Objects.equals(no, list.no) &&
                Objects.equals(date, list.date) &&
                Objects.equals(type, list.type) &&
                Objects.equals(operator, list.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNo, id, no, date, type, operator);
    }

    @Override
    public String toString() {
        return "List{" +
                "serialNo=" + serialNo +
                ", id='" + id + '\'' +
                ", no=" + no +
                ", date=" + date +
                ", type=" + type +
                ", operator='" + operator + '\'' +
                '}'+
                "\n";
    }
}
