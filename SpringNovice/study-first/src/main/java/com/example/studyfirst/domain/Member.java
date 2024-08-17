package com.example.studyfirst.domain;

import org.springframework.stereotype.Component;

@Component
public class Member {
    private Long age;
    private String name;
    private String blType;
    private String address;

    private String id;

    private String password;

    private Long sequence;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlType() {
        return blType;
    }

    public void setBlType(String blType) {
        this.blType = blType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
