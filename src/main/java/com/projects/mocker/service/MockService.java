package com.projects.mocker.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import com.projects.mocker.utils.RandomValuesGenerator;

@Service
public class MockService {

    @Autowired
    MongoTemplate mongoTemplate;

    public  List<Document> findAll(String collectionName) {
        return mongoTemplate.findAll(Document.class, collectionName);
    }

    public  String getMockById(String mockId, String collectionName) {
        MongoCollection<Document> collection = mongoTemplate.getCollection(collectionName);
        Document document = collection.find(Filters.eq("_id",mockId)).first();
        if (document == null)
            return "";

        return document.toJson();
    }


    public String save(String json, String collectionName) {
        MongoCollection<Document> collection = mongoTemplate.getCollection(collectionName);
        Document doc = Document.parse(json);
        collection.insertOne(doc);
        Object id = doc.get("_id");
        Document insertedDoc = collection.find(Filters.eq("_id", id)).first();

        return insertedDoc != null ? insertedDoc.toJson() : "";
    }

    public String edit(String mockId, String collectionName, String updateJson) {
        MongoCollection<Document> collection = mongoTemplate.getCollection(collectionName);
        Document updateFields = Document.parse(updateJson);
        Document updateOperation = new Document("$set",updateFields);
        Document documentToBeEdited = collection.find(Filters.eq("_id",mockId)).first();

        if (documentToBeEdited == null)
            return "";

        collection.updateOne(Filters.eq("_id",mockId),updateOperation);
        return collection.find(Filters.eq("_id",mockId)).first().toJson();
    }

    public String delete(String mockId, String collectionName) {
        MongoCollection<Document> collection = mongoTemplate.getCollection(collectionName);
        Document documentToBeDeleted = collection.find(Filters.eq("_id",mockId)).first();
        if (documentToBeDeleted == null)
            return "";

        collection.deleteOne(Filters.eq("_id",mockId));
        return documentToBeDeleted.toJson();
    }

    public String deleteCollection(String collectionName) {
        mongoTemplate.dropCollection(collectionName);
        return "Collection '" + collectionName + "' dropped successfully.";
    }

    public String addFakeData(int quantity,String collectionName, String dataInfoString){
        Gson gson = new Gson();
        for(int i=0;i< quantity;i++){
            JsonObject dataInfoJson = gson.fromJson(dataInfoString, JsonObject.class);
            Set<String> keys = dataInfoJson.keySet();
            for(String key:keys){
                if(dataInfoJson.get(key).getAsString().equals("string")){
                    String randomString = RandomValuesGenerator.generateRandomString(4);
                    dataInfoJson.addProperty(key,randomString);
                } else if (dataInfoJson.get(key).getAsString().equals("int")) {
                    int randomInt = RandomValuesGenerator.generateRandomInt(2);
                    dataInfoJson.addProperty(key,randomInt);
                }
            }
            this.save(dataInfoJson.toString(),collectionName);
        }
        return "OK";
    }

}
