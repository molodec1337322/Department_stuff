package com.example.kursach2tkp.controllers;

import com.example.kursach2tkp.dao.SubjectDAO;
import com.example.kursach2tkp.dao.UserDAO;
import com.example.kursach2tkp.models.User;
import com.example.kursach2tkp.models.Worker;
import com.example.kursach2tkp.dao.WorkerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/workers")
public class WorkersController {

    private WorkerDAO workerDAO;

    private UserDAO userDAO;

    private SubjectDAO subjectDAO;

    @Autowired
    public WorkersController(WorkerDAO workerDAO, UserDAO userDAO, SubjectDAO subjectDAO){
        this.workerDAO = workerDAO;
        this.userDAO = userDAO;
        this.subjectDAO = subjectDAO;
    }


    @GetMapping("/all")
    public String GetAllWorkers(Model model,
                                Authentication authentication){

        boolean isAuthenticated = false;
        boolean isAdmin = false;
        String username = null;

        if(authentication != null){
            System.out.println((UserDetails)authentication.getPrincipal());
            isAuthenticated = authentication.isAuthenticated();
            username = ((UserDetails) authentication.getPrincipal()).getUsername();
        }

        model.addAttribute("workers", workerDAO.getAllWorkersList());
        model.addAttribute("is_auth", isAuthenticated);
        model.addAttribute("is_admin", isAdmin);
        model.addAttribute("logged_user", username);

        return "workers/workersList/Работники-кафедры";
    }


    @GetMapping("/info/{id}")
    public String GetWorkerByID(@PathVariable("id") int id, Model model){
        //model.addAttribute("worker", workerDAO.getWorkerByID(id));
        model.addAttribute("worker", workerDAO.getWorkerByID(id));
        return "workers/worker";
    }

    @GetMapping("/subject/{id}")
    public String GetAllWorkersBySubject(@PathVariable("id") int subject,
                                            Model model,
                                            Authentication authentication){

        boolean isAuthenticated = false;
        boolean isAdmin = false;
        String username = null;


        if(authentication != null){
            System.out.println((UserDetails)authentication.getPrincipal());
            isAuthenticated = authentication.isAuthenticated();
            username = ((UserDetails) authentication.getPrincipal()).getUsername();

        }

        //int subjectID = subjectDAO.getSubjectByName(subject).getId();

        model.addAttribute("workers", workerDAO.getWorkersBySubjectID(subject));
        model.addAttribute("is_auth", isAuthenticated);
        model.addAttribute("is_admin", isAdmin);
        model.addAttribute("logged_user", username);
        model.addAttribute("subject_name", subject);

        return "workers/workersList/Работники-кафедры";
    }

    @GetMapping("/new")
    public String NewWorker(Model model,
                            Authentication authentication){

        boolean isAuthenticated = false;
        String username = null;

        if(authentication != null){
            System.out.println((UserDetails)authentication.getPrincipal());
            isAuthenticated = authentication.isAuthenticated();
            username = ((UserDetails) authentication.getPrincipal()).getUsername();
        }

        model.addAttribute("is_auth", isAuthenticated);
        model.addAttribute("logged_user", username);

        return "workers/newWorker/Добавление-нового-работника";
    }

    @PostMapping("/new")
    public String AddWorker(@RequestParam("first_name") String first_name,
                            @RequestParam("last_name") String last_name,
                            @RequestParam("patronym") String patronym,
                            @RequestParam("post") String post,
                            @RequestParam("birthday") String birthday,
                            Model model,
                            Authentication authentication){

        Worker worker = new Worker();

        UserDetails principals = (UserDetails) authentication.getPrincipal();
        User user = userDAO.getUserByLogin(principals.getUsername());

        worker.setFirst_name(first_name);
        worker.setLast_name(last_name);
        worker.setPatronym(patronym);
        worker.setPost(post);
        worker.setBirthday(birthday);
        worker.setUser(user);
        worker.setSubject(subjectDAO.getSubjectById(6));

        workerDAO.addNewWorker(worker);

        model.addAttribute("workers", workerDAO.getAllWorkersList());

        return "redirect:/workers/all";
    }

    public String deleteWorker(@PathVariable("id") int id,
                               Model model,
                               Authentication authentication){

        workerDAO.deleteWorkerById(id);

        return "redirect:/workers/all";
    }

}
