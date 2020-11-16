package io.tomo.lms.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Lombok提供了许多注解, 标注在类上或属性上
 * 常用注解
 */
/*@Getter
@Setter
@ToString
@EqualsAndHashCode*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    private Integer no;
    private String name;
    private String author;
    private String press;
    private Integer count;
}
