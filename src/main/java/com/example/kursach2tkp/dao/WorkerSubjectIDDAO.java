package com.example.kursach2tkp.dao;


import com.example.kursach2tkp.models.Subject;
import com.example.kursach2tkp.models.Worker;
import com.example.kursach2tkp.models.WorkerSubjectID;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Component
@Repository
@Transactional
public class WorkerSubjectIDDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createLintWorkerSubject(WorkerSubjectID workerSubjectID){
        sessionFactory.getCurrentSession().persist(workerSubjectID);
    }

    /*
    public Worker getWorkerById(WorkerSubjectID workerSubjectID){
        return (Worker) sessionFactory.getCurrentSession().createQuery("from User where login='" + (String) login.toLowerCase(Locale.ROOT) + "'");
    }

    public Subject getSubjectById(WorkerSubjectID workerSubjectID){

    }

     */
}
