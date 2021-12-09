package com.example.kursach2tkp.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "WorkerSubjectID")
public class WorkerSubjectID {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public WorkerSubjectID(){

    }

    /*
    GETTERS
     */

    public int getId() {
        return id;
    }

    public Worker getWorker() {
        return worker;
    }

    public Subject getSubject() {
        return subject;
    }

    /*
    SETTERS
     */

    public void setId(int id) {
        this.id = id;
    }

    public void setWorker(Worker workers) {
        this.worker = workers;
    }

    public void setSubject(Subject subjects) {
        this.subject = subjects;
    }
}
