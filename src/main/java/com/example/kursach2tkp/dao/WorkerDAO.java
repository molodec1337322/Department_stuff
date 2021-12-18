package com.example.kursach2tkp.dao;

import com.example.kursach2tkp.models.Subject;
import com.example.kursach2tkp.models.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

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
        return  sessionFactory.getCurrentSession().createQuery("from Worker").list();
    }

    public void addNewWorker(Worker worker){
        sessionFactory.getCurrentSession().persist(worker);
    }

    public void updateWorker(Worker worker){
        sessionFactory.getCurrentSession().update(worker);
    }

    public Worker getWorkerByID(int id){
        return  sessionFactory.getCurrentSession().get(Worker.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Worker> getWorkersBySubjectID(int id){
        return sessionFactory.getCurrentSession().createQuery("from Worker where subject_id=" + id).list();
    }

    public void deleteWorkerById(int id){
        sessionFactory.getCurrentSession().delete(getWorkerByID(id));
    }
}
