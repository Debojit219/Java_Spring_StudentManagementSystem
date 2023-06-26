package com.Debojit219.StudentManagementSystem.repositories;

import com.Debojit219.StudentManagementSystem.entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import com.mongodb.client.MongoClient;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.AggregateIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

@Component
public class StudentSearchRepositoryImpl implements StudentSearchRepository {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter converter;
    @Override
    public List<Student> searchStudents(String text) {
        List<Student> students = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("StudentManagementSystemDB");
        MongoCollection<Document> collection = database.getCollection("Students");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "StudentSearchIndex")
                        .append("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("name", "emailId", "phoneNumber", "uniqueId"))))));

        result.forEach(doc -> students.add(converter.read(Student.class,doc)));

        return students;
    }
}
