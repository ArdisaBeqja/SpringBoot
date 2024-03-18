package com.project.springTest.Service;

import com.project.springTest.Models.Student;
import com.project.springTest.Repository.StdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StdServ {

    @Autowired
    private StdRepo stdRepo;

    public Student createStudent(String name,String amxa, String surname, Integer age) {
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setAge(age);
        student.setAmxa(amxa);
        // Save the student using the repository
        return stdRepo.save(student);
    }

    public void delteStudent(String amxa){
        stdRepo.deleteByAmxa(amxa);
    }

    public List<Student> getAllStudents(){
      return stdRepo.findAll();
    }

    public Student updateStudnet(Student student){
        return stdRepo.save(student);
    }

    public Student findStudent(String amxa){
        return stdRepo.findByAmxa(amxa);
    }
}
