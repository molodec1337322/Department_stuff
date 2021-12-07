package com.example.kursach2tkp.dao;

import com.example.kursach2tkp.Models.Worker;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class WorkerDAO {
    private List<Worker> workers;

    // TEST DATA
    private static int WORKER_COUNT = 0;
    {
        workers = new ArrayList<Worker>();

        workers.add(new Worker(WORKER_COUNT++,
                "Alex",
                "Ivanov",
                "Ivanovich",
                "01.01.1996",
                "admin",
                "01.01.2020"));

        workers.add(new Worker(WORKER_COUNT++,
                "Ivan",
                "Andrey",
                "Andreevich",
                "02.12.1986",
                "CEO",
                "01.01.2010"));

        workers.add(new Worker(WORKER_COUNT++,
                "Alex",
                "Andrey",
                "Andreevich",
                "02.12.1990",
                "project_manager",
                "01.01.2016"));
    }

    public List<Worker> getAllWorkersList(){
        return workers;
    }

    /*
    public boolean checkCollision(Worker worker){
        for (Worker w: workers) {
            if(worker.getFirst_name() == w.getFirst_name() &&
            worker.getLast_name() == w.getLast_name() &&
            worker.getPatronym() == w.getLast_name() )
        }
    }

     */

    public void addNewWorker(Worker worker){
        worker.setId(WORKER_COUNT++);
        workers.add(worker);
    }

    public Worker getWorkerByID(int id){
        return workers.stream().filter(worker -> worker.getId() == id).findAny().orElse(null);
    }

    public int getId(){
        return WORKER_COUNT;
    }
}
