package org.jd.todo_list.service;

import org.jd.todo_list.exception.TaskNotFoundException;
import org.jd.todo_list.model.Priority;
import org.jd.todo_list.model.Status;
import org.jd.todo_list.model.Task;
import org.jd.todo_list.repo.TaskJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskJPARepo repo;

    public Task saveTask(Task task){
        return repo.save(task);
    }

    public List<Task> getAllTasks(){
        return repo.findAll();
    }

    public List<Task> sortByPriority(){
        return  repo.sortByPriority();
    }

    public List<Task> sortByStatus(){
        return repo.sortByStatus();
    }

    public void deleteTask(int id){
        repo.delete(getTaskById(id));
    }

    public Task updateTask(int id, Task task){
        Optional<Task> optionalTask = repo.getTaskById(id);
        if (optionalTask.isPresent()){
            Task t = optionalTask.get();
            t.setId(task.getId());
            t.setDate(task.getDate());
            t.setPriority(task.getPriority());
            t.setDescription(task.getDescription());
            t.setStatus(task.getStatus());
            t.setDeadline(task.getDeadline());
            return repo.save(t);
        }
        else throw new TaskNotFoundException();
    }

    public Task getTaskById(Integer id) {
        return repo.getTaskById(id).get();
    }
}
