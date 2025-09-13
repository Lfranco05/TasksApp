package com.lfranco.todolist.Service;

import com.lfranco.todolist.Model.TaskModel;
import com.lfranco.todolist.Repository.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TaskService {

    @Inject
    private TaskRepository repository;

    public List<TaskModel> getAllTasks() {
        return repository.getTasks();
    }

    public void addTask(String description) {
        repository.add(new TaskModel(description));
    }

    public void removeTask(TaskModel task) {
        repository.remove(task);
    }

    public void toggleCompleted(TaskModel task) {
        task.setCompleted(!task.isCompleted());
    }
}