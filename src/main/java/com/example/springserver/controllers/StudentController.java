package com.example.springserver.controllers;

import com.example.springserver.model.Student;
import com.example.springserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public Student save(@RequestBody Student student) {
        // just in case they pass an id in JSON ... set id to 0
        // in order to force insert of a new record

        student.setId(0);
        return studentService.saveStudent(student);
    }

    @PutMapping("/students")
    public Student update(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/students")
    public void deleteStudentsById(@RequestBody List<Integer> studentIds) {
        studentService.deleteAllById(studentIds);
    }

}
