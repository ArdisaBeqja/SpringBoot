package com.project.springTest.Controllers;

import com.project.springTest.Models.Student;
import com.project.springTest.Service.StdServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
//KONTROLLERI BASHKON API ME SERVICE METHODS
public class StdCont {

    @Autowired
    private StdServ stdServ;
    @PostMapping("/create")
    public ResponseEntity<Student>createOneStudent(@RequestBody Student student){
        Student createdStudent = stdServ.createStudent(student.getName(), student.getAmxa(),student.getSurname(), student.getAge());
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
//
//    NOTES!!
//the firstParameter should not be void since it should send smth
// to the client and since the deleteStudent method is void, we should not use this consturctor
    @DeleteMapping("/{amxa}")
    public ResponseEntity<Void>deleteStudentByAmxa(@PathVariable String amxa){
        stdServ.delteStudent(amxa);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/allStd")
    public ResponseEntity<List<Student>>getall(){
        return new ResponseEntity<>(stdServ.getAllStudents(),HttpStatus.OK);
    }

//    NOTESS!!
//      the consturctor of ResponseEntity is this one=>
//        public ResponseEntity(T body, HttpStatus status)
//        T body represents the body of the HTTP response.It is the actual content that you want to SEND to the client.

//   NOTES!! NQS DO MARRI DICKA NGA URL => @PathVariable
    @PutMapping("/{amxa}")
    public ResponseEntity<Student>updateStudent(@PathVariable String amxa, @RequestBody Student student){
     Student existingStd=stdServ.findStudent(amxa);
     if(existingStd==null){
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
     existingStd.setName(student.getName());
     existingStd.setAge(student.getAge());
     existingStd.setSurname(student.getSurname());


     return  new ResponseEntity<>(stdServ.updateStudnet(existingStd),HttpStatus.OK);
    }


}
