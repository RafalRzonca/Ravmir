package pl.example.spring.punkty;

public class Student {
    public final long id;
    public final String name;
    public final String number;
    public final String group;

    public Student(long id, String name, String number, String group) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.group = group;
    }
}
