package com.example.springserver.service;

import com.example.springserver.model.Student;
import com.example.springserver.repository.StudentRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return Streamable.of(repo.findAll()).toList();
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }

    public void deleteAllById(List<Integer> ids) {
        repo.deleteAllById(ids);
    }

}
