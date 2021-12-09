package com.example.kursach2tkp.controllers;

import com.example.kursach2tkp.models.Worker;
import com.example.kursach2tkp.dao.WorkerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/workers")
public class WorkersController {

    private WorkerDAO workerDAO;

    @Autowired
    public WorkersController(WorkerDAO workerDAO){
        this.workerDAO = workerDAO;
    }

    @GetMapping()
    public String GetAllWorkers(Model model){
        model.addAttribute("workers", workerDAO.getAllWorkersList());
        return "workers/workersList";
    }

    @GetMapping("/{id}")
    public String GetWorkerByID(@PathVariable("id") int id, Model model){
        //model.addAttribute("worker", workerDAO.getWorkerByID(id));
        model.addAttribute("worker", workerDAO.getWorkerByID(id));
        return "workers/worker";
    }

    @GetMapping("/new")
    public String NewWorker(Model model){
        model.addAttribute("worker", new Worker());
        return "workers/newWorker";
    }

    @PostMapping()
    public String AddWorker(@RequestParam("first_name") String first_name,
                            @RequestParam("last_name") String last_name,
                            @RequestParam("patronym") String patronym,
                            @RequestParam("post") String post,
                            @RequestParam("birthday") String birthday,
                            @RequestParam("started_working") String started_working,
                            Model model){

        Worker worker = new Worker();

        worker.setFirst_name(first_name);
        worker.setLast_name(last_name);
        worker.setPatronym(patronym);
        worker.setPost(post);
        worker.setBirthday(birthday);
        worker.setStarted_working(started_working);

        workerDAO.addNewWorker(worker);

        model.addAttribute("workers", workerDAO.getAllWorkersList());

        return "workers/workersList";
    }

}
