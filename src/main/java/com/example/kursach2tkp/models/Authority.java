package com.example.kursach2tkp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Authority")
public class Authority {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "role", nullable = false)
    private String role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authority")
    private Set<User> users = new HashSet<>();

    /*
    GETTERS
     */

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public Set<User> getUsers() {
        return users;
    }

    /*
    SETTERS
     */

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
