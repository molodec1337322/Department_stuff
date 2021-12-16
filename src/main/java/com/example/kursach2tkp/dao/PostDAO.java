package com.example.kursach2tkp.dao;

import com.example.kursach2tkp.models.Post;
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
public class PostDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Post getPostById(int id){
        return sessionFactory.getCurrentSession().get(Post.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Post> getPostsList(){
        return sessionFactory.getCurrentSession().createQuery("from Post").list();
    }

    public Post getPostByName(String name){
        return (Post) sessionFactory.getCurrentSession().createQuery("from Post where post_name='" + (String) name.toLowerCase(Locale.ROOT) + "'");
    }

    public void addPost(Post post){
        sessionFactory.getCurrentSession().persist(post);
    }
}
