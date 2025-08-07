package com.projects.mocker.model;


import lombok.*;
import org.bson.json.JsonObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MockEntity {
    @Id String id;
    @Transient int quantity;
    String dataInfo;
}