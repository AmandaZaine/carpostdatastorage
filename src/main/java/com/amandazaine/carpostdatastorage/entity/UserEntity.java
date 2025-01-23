package com.amandazaine.carpostdatastorage.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_owner")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String phone;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String type, String phone) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
