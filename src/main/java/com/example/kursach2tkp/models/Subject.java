package com.example.kursach2tkp.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private Set<Worker> workers;

    public Subject(){

    }

    /*
    GETTERS
     */

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Worker> getWorker() {
        return workers;
    }

    /*
    SETTERS
     */

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorker(Set<Worker> worker) {
        this.workers = worker;
    }
}
