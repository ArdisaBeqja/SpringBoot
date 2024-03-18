package com.project.springTest.Repository;

import com.project.springTest.Models.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StdRepo extends MongoRepository<Student, ObjectId> {
//    that in Repository class we write addional method signature that are not the standard CRUD operations
//    and not found in MongoRepository, and then these methods are created in the service class

//    ---EXAMPLEE---
//    List<Student> findByName(String name);
//
//    // Example of a custom query method using @Query annotation
//    @Query("{'surname': ?0}")
//    List<Student> findBySurname(String surname);


     void deleteByAmxa(String amxa);
     Student save(Student student);
     Student findByAmxa(String amxa);
}
