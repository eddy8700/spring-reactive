package com.markit.spring.reactive.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by aditya.gupta2 on 9/21/2017.
 */


@ToString
public class User {

    private Long id;
    private String user;

    public User(){}

    public User(Long id, String user) {
        this.id = id;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
