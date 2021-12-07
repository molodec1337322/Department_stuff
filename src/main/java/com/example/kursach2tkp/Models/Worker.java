package com.example.kursach2tkp.Models;

public class Worker {

    private int id;
    private String first_name;
    private String last_name;
    private String patronym;
    private String birthday;
    private String post;
    private String started_working;

    public Worker(){

    }

    public Worker(int id,
                  String first_name,
                  String last_name,
                  String patronym,
                  String birthday,
                  String post,
                  String started_working){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.patronym = patronym;
        this.birthday = birthday;
        this.post = post;
        this.started_working = started_working;
    }

    /*
    Getters
     */

    public void setId(int id) {
        this.id = id;
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
    Setters
     */

    public int getId(){
        return id;
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
