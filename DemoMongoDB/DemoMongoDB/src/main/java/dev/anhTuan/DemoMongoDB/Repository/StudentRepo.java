package dev.anhTuan.DemoMongoDB.Repository;

import dev.anhTuan.DemoMongoDB.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student,Integer> {

}
