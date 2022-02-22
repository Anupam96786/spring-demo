package com.thinkxfactor.springdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

import com.thinkxfactor.springdemo.entity.Student;

@RestController
@RequestMapping("/students")
public class StudentController {
    private static ArrayList<HashMap> students = generateStudents();

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    private static ArrayList<HashMap> generateStudents() {
        ArrayList<HashMap> students = new ArrayList<HashMap>();
        students.add(new Student("Student A", "Address A", 20, "Male", 50, "CSE").getData());
        students.add(new Student("Student B", "Address B", 21, "Female", 51, "IT").getData());
        students.add(new Student("Student C", "Address C", 22, "Male", 52, "ECE").getData());
        students.add(new Student("Student D", "Address D", 23, "female", 53, "EE").getData());
        students.add(new Student("Student E", "Address E", 24, "Male", 54, "CSE").getData());
        students.add(new Student("Student F", "Address F", 25, "Female", 55, "IT").getData());
        students.add(new Student("Student G", "Address G", 26, "Male", 56, "ECE").getData());
        students.add(new Student("Student H", "Address H", 27, "female", 57, "EE").getData());
        return students;
    }

    @GetMapping("/get-all-students")
    public ArrayList<HashMap> getAllStudent() {
        return students;
    }

    @PostMapping("/add-student")
    public HashMap addStudent(@RequestBody Student student) {
        students.add(student.getData());
        return student.getData();
    }

    @GetMapping("/get-by-roll-no/{rollNo}")
    public HashMap getStudentByRollNo(@PathVariable int rollNo) {
        for (HashMap student : students) {
            if (student.get("rollNo").equals(rollNo)) {
                return student;
            }
        }
        return null;
    }

    @GetMapping("/delete-by-roll-no/{rollNo}")
    public HashMap deleteStudentByRollNo(@PathVariable int rollNo) {
        for (HashMap student : students) {
            if (student.get("rollNo").equals(rollNo)) {
                students.remove(student);
                return student;
            }
        }
        return null;
    }
}
