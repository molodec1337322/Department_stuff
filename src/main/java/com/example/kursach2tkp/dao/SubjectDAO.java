package com.example.kursach2tkp.dao;


import com.example.kursach2tkp.models.Subject;
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
public class SubjectDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createSubject(Subject subject){
        sessionFactory.getCurrentSession().persist(subject);
    }

    public Subject getSubjectById(int id){
        return sessionFactory.getCurrentSession().get(Subject.class, id);
    }

    public Subject getSubjectByName(String name){
        return (Subject) sessionFactory.getCurrentSession().createQuery("from Subject where name='" + (String) name.toLowerCase(Locale.ROOT) + "'").uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Subject> getAllSubjectsList(){
        return sessionFactory.getCurrentSession().createQuery("from Subject").list();
    }
}
