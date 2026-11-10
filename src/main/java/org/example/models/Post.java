package org.example.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Post extends Base {

    private String content;
    private String url;
    private String dataType;
    private Long userId;
    public Post(){}
}
