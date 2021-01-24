package main.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @author lirui
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private double num;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
