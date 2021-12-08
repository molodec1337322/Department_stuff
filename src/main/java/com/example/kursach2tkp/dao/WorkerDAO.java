package com.example.kursach2tkp.dao;

import com.example.kursach2tkp.models.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Repository
@Transactional
public class WorkerDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Worker> getAllWorkersList(){
        Session session = sessionFactory.getCurrentSession();
        return  session.createQuery("from Worker").list();
    }

    public void addNewWorker(Worker worker){
        Session session = sessionFactory.getCurrentSession();
        session.persist(worker);
    }

    public Worker getWorkerByID(int id){
        Session session = sessionFactory.getCurrentSession();
        return  session.get(Worker.class, id);
    }
}
