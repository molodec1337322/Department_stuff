package com.example.kursach2tkp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "post_name")
    private String post_name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private Set<Post> post = new HashSet<>();

    /*
    GETTERS
     */

    public int getId() {
        return id;
    }

    public String getPost_name() {
        return post_name;
    }

    public Set<Post> getPost() {
        return post;
    }

    /*
    SETTERS
     */

    public void setId(int id) {
        this.id = id;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public void setPost(Set<Post> post) {
        this.post = post;
    }
}
