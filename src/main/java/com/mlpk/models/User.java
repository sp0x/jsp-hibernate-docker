package com.mlpk.models;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User{

    @Id @GeneratedValue
    private Long id;
    @Column
    private String userId;
    @Column
    private String password;

    public User() {
    }

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String u) {
        this.userId = u;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String p) {
        this.password = p;
    }
}
