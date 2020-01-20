package com.jungs.blog.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue
    int id;
    String subject;

    @Column(columnDefinition = "text")
    String content;

    @Column(updatable = false)
    Date regDate;
}
