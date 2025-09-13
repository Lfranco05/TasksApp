package com.lfranco.todolist.Repository;

import com.lfranco.todolist.Model.TaskModel;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TaskRepository {

    private final List<TaskModel> tasks = new ArrayList<>();

    public List<TaskModel> getTasks() {
        return tasks;
    }

    public void add(TaskModel task) {
        tasks.add(task);
    }

    public void remove(TaskModel task) {
        tasks.remove(task);
    }
}
