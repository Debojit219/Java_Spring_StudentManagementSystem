package com.Debojit219.StudentManagementSystem.repositories;

import com.Debojit219.StudentManagementSystem.entities.Admin;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AdminSearchRepositoryImpl implements  AdminSearchRepository {
    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter converter;
    @Override
    public List<Admin> searchAdmins(String text) {
        List<Admin> admins = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("StudentManagementSystemDB");
        MongoCollection<Document> collection = database.getCollection("Admins");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "AdminSearchIndex")
                        .append("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("name", "phoneNumber", "email"))))));

        result.forEach(doc -> admins.add(converter.read(Admin.class,doc)));

        return admins;
    }
}
