package com.example.kursach2tkp.controllers;

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
        model.addAttribute("workers", workerDAO.index());
        return "workers/workersList.html";
    }

    @GetMapping("/{id}")
    public String GetWorkerByID(@PathVariable("id") int id, Model model){
        model.addAttribute("worker", workerDAO.getWorkerByID(id));
        return "workers/worker.html";
    }

    /*
    @GetMapping("/get")
    public String GetWorker(@RequestParam(value = "first_name", required = false) String first_name,
                           @RequestParam(value = "second_name", required = false) String second_name,
                           @RequestParam(value = "patronym", required = false) String patronym,
                           @RequestParam(value = "birthday", required = false) String birthday,
                           @RequestParam(value = "post", required = false) String post,
                           @RequestParam(value = "started_working", required = false) String started_working,
                           Model model){

        model.addAttribute("first_name", first_name);
        model.addAttribute("second_name", second_name);
        model.addAttribute("patronym", patronym);
        model.addAttribute("birthday", birthday);
        model.addAttribute("post", post);
        model.addAttribute("started_working", started_working);

        return "workers/workersList";
    }
    */

    @PostMapping("/add")
    public String AddWorker(){

        return "home/addWorker";
    }
}
