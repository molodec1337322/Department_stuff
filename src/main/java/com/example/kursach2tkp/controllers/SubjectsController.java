package com.example.kursach2tkp.controllers;

import com.example.kursach2tkp.dao.SubjectDAO;
import com.example.kursach2tkp.dao.UserDAO;
import com.example.kursach2tkp.dao.WorkerDAO;
import com.example.kursach2tkp.models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/subjects")
public class SubjectsController {

    private UserDAO userDAO;

    private SubjectDAO subjectDAO;

    @Autowired
    public SubjectsController(UserDAO userDAO, SubjectDAO subjectDAO){
        this.userDAO = userDAO;
        this.subjectDAO = subjectDAO;
    }

    @GetMapping()
    public String getAllSubjects(Model model,
                                 Authentication authentication){

        boolean isAuthenticated = false;
        String username = null;

        if(authentication != null){
            isAuthenticated = authentication.isAuthenticated();
            username = ((UserDetails) authentication.getPrincipal()).getUsername();
        }

        model.addAttribute("is_auth", isAuthenticated);
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

}
