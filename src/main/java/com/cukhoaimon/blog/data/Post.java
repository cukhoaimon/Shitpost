package com.cukhoaimon.blog.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "shitpost")
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    private String id;

    private String name;
    private String description;

}
