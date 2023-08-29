package com.xadmin.SpringBootCrud.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Subject {

    @Id

    @Column(name = "studentId")
    private Integer studentId;  // Student ID as an integer

    @Column(name = "firstName")
    private String firstName;   // First Name as a string

    @Column(name = "lastName")
    private String lastName;    // Last Name as a string

    @Column(name = "age")
    private Integer age;        // Age as an integer

    @Column(name = "grade")
    private String grade;   
    public Subject() {
    }

    public Subject(Integer studentId, String firstName, String lastName, Integer age, String grade) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.grade = grade;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
