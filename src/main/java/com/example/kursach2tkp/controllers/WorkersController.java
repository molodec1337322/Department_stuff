package com.example.kursach2tkp.controllers;

import com.example.kursach2tkp.Models.Worker;
import com.example.kursach2tkp.dao.WorkerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

        Worker worker = new Worker(-1,
                first_name,
                last_name,
                patronym,
                birthday,
                post,
                started_working
        );

        workerDAO.addNewWorker(worker);

        model.addAttribute("workers", workerDAO.getAllWorkersList());

        return "workers/workersList";
    }

}
