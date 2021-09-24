package ua.gudz.hw16.task4;

import lombok.Data;

@Data
class Student {
    private String name;
    private String group;
    private int curs;
    private int mark;

    public Student(String name, String group, int curs, int mark) {
        this.name = name;
        this.group = group;
        this.curs = curs;
        this.mark = mark;
    }
}
