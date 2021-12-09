package com.example.kursach2tkp.models;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "workers")
public class Worker {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "patronym")
    private String patronym;

    @Column(name = "birthday", nullable = false)
    private String birthday;

    @Column(name = "post")
    private String post;

    @Column(name = "started_working", nullable = false)
    private String started_working;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "worker")
    private Set<WorkerSubjectID> workerSubjectID;

    public Worker(){

    }

    /*
    Setters
     */

    public void setWorkerSubjectID(Set<WorkerSubjectID> workerSubjectID) {
        this.workerSubjectID = workerSubjectID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPatronym(String patronym) {
        this.patronym = patronym;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setStarted_working(String started_working) {
        this.started_working = started_working;
    }

    /*
    Getters
     */

    public Set<WorkerSubjectID> getWorkerSubjectID() {
        return workerSubjectID;
    }

    public int getId(){
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPatronym() {
        return patronym;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPost() {
        return post;
    }

    public String getStarted_working() {
        return started_working;
    }

}
