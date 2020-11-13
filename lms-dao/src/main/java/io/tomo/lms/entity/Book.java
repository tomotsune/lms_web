package io.tomo.lms.entity;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private Integer no;
    private String name;
    private String author;
    private String press;
    private Integer count;

    public Book() {
    }

    public Book(Integer no) {
        this.no = no;
    }

    public Book(Integer no, String name) {
        this(no);
        this.name = name;
    }

    public Book(Integer no, String name, String author) {
        this(no,name);
        this.author = author;
    }

    public Book(Integer no, String name, String author, String press) {
        this(no,name,author);
        this.press = press;
    }

    public Book(Integer no, String name, String author, String press, Integer count) {
        this(no,name,author,press);
        this.count = count;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
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
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(no, book.no) &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(press, book.press) &&
                Objects.equals(count, book.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name, author, press, count);
    }

    @Override
    public String toString() {
        return "Book{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", count=" + count +
                '}'+
                "\n";
    }
}
