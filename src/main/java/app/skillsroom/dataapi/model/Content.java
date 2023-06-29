package app.skillsroom.dataapi.model;

import java.time.LocalDateTime;

//Creating a record class in Java 17
//https://www.baeldung.com/java-record-keyword
public record Content (
    Integer id,
    String title,
    String description,
    String url,
    String content,
    String mainPicture,
    LocalDateTime creationDate,
    LocalDateTime lastUpdateDate,
    Status status,
    Type contentType
){
}
