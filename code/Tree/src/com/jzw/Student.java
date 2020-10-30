package com.jzw;

import java.io.*;

public class Student implements Serializable {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Student student1 = new Student("j", 10);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("tt.text");
            ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
            os.writeObject(student1);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
