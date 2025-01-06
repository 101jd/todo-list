package org.jd.todo_list.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException() {
        super("Task not found");
    }
}
