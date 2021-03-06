package com.example.kursach2tkp.controllers;

import com.example.kursach2tkp.dao.PostDAO;
import com.example.kursach2tkp.dao.SubjectDAO;
import com.example.kursach2tkp.dao.UserDAO;
import com.example.kursach2tkp.dao.WorkerDAO;
import com.example.kursach2tkp.models.Post;
import com.example.kursach2tkp.models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subjects")
public class SubjectsController {

    private UserDAO userDAO;

    private SubjectDAO subjectDAO;

    private PostDAO postDAO;

    @Autowired
    public SubjectsController(UserDAO userDAO, SubjectDAO subjectDAO, PostDAO postDAO){
        this.userDAO = userDAO;
        this.subjectDAO = subjectDAO;
        this.postDAO = postDAO;
    }

    @GetMapping()
    public String getAllSubjects(Model model,
                                 Authentication authentication){

        boolean isAuthenticated = false;
        boolean isAdmin = false;
        String username = null;

        if(authentication != null){
            isAuthenticated = authentication.isAuthenticated();
            username = ((UserDetails) authentication.getPrincipal()).getUsername();
            isAdmin = isUserAdmin(authentication);
        }

        model.addAttribute("is_auth", isAuthenticated);
        model.addAttribute("is_admin", isAdmin);
        model.addAttribute("logged_user", username);
        model.addAttribute("subjects", subjectDAO.getAllSubjectsList());

        return "/subjects/subjectsList/Кафедры";
    }

    @PostMapping("/new")
    public String addNewSubject(@RequestParam(value = "newSubjectName") String newSubject){
        Subject subject = new Subject();
        subject.setName(newSubject);
        subjectDAO.createSubject(subject);

        return "redirect:/subjects";
    }

    @PostMapping("/posts/new")
    public String addNewPost(@RequestParam(value = "newPostName") String newPost){
        Post post = new Post();
        post.setPost_name(newPost);
        postDAO.addPost(post);

        return "redirect:/subjects";
    }

    @GetMapping("/delete/{id}")
    public String deleteSubject(@PathVariable("id") int id,
                                Model model,
                                Authentication authentication){
        subjectDAO.deleteSubjectById(id);
        return "redirect:/subjects";
    }

    boolean isUserAdmin(Authentication authentication){
        return authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
    }
}
