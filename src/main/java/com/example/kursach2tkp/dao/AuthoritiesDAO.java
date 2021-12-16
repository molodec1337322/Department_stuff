package com.example.kursach2tkp.dao;

import com.example.kursach2tkp.models.Authority;
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
public class AuthoritiesDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createAuthority(Authority authority){
        sessionFactory.getCurrentSession().persist(authority);
    }

    public Authority getAuthorityByName(String name){
        return (Authority) sessionFactory.getCurrentSession().createQuery("from Authority where role='" + (String) name.toUpperCase(Locale.ROOT) + "'").uniqueResult();
    }

    public Authority getAuthorityById(int id){
        return sessionFactory.getCurrentSession().get(Authority.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Authority> getAllAuthorities(){
        return sessionFactory.getCurrentSession().createQuery("from Authority").list();
    }
}
