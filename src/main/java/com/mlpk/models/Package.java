package com.mlpk.models;

import javax.persistence.*;

@Entity
@Table(name="packages")
public class Package {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long author;
    @Column
    private String name;
    @Column
    private String language;

    public Package(){

    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOwn(Long userId) {
        return getAuthor().equals(userId);
    }
}
