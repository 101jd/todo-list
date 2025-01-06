package org.jd.todo_list.controller;

import org.jd.todo_list.model.Status;
import org.jd.todo_list.model.Task;
import org.jd.todo_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class TaskController {
    @Autowired
    TaskService service;

    @GetMapping("/tasks")
    public String getAllTasks(/*@PathVariable(required = false, name = "id") Integer id,*/ Model model){
//        if (id == null) {
            model.addAttribute("task", newTask());
            model.addAttribute("list", service.getAllTasks());
//        }
//        else model.addAttribute("task", service.getTaskById(id));
        return "tasks";
    }

    @PostMapping("/tasks")
    public String addTask(@ModelAttribute Task task, Model model){
        Task t = service.saveTask(task);
        System.out.println(t);
        model.addAttribute("task", t);

        return "redirect:tasks";
    }

    @GetMapping(value = "/delete")
    public String deleteTask(@RequestParam("id") int id){
        service.deleteTask(id);
        return "redirect:tasks";
    }

    @PostMapping("/update")
    public String updateTask(@RequestParam("id") int id, @RequestParam int status, Model model){
        Task task = service.getTaskById(id);
        task.setStatus(status);
        service.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/sorpriority")
    public String sortByPriority(Model model){
        model.addAttribute("task", newTask());
        model.addAttribute("list", service.sortByPriority());
        return "tasks";
    }

    @GetMapping("/sortstatus")
    public String sortByStatus(Model model){
        model.addAttribute("task", newTask());
        model.addAttribute("list", service.sortByStatus());
        return "tasks";
    }

    private Task newTask(){
        Task task = new Task();
        task.setPriority(0);
        task.setStatus(0);
        return task;
    }
}
