package main.entity;

/***
 * @author lirui
 **/
public class Student {
    private Integer id;
    private String name;
    private double num;


    public Student() {
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Student(Integer id, String name, int num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
