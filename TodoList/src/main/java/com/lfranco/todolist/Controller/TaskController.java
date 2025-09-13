package com.lfranco.todolist.Controller;

import com.lfranco.todolist.Model.TaskModel;
import com.lfranco.todolist.Service.TaskService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("taskController")
@SessionScoped
public class TaskController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TaskService taskService;

    private String newTaskDescription;

    public String getNewTaskDescription() {
        return newTaskDescription;
    }

    public void setNewTaskDescription(String newTaskDescription) {
        this.newTaskDescription = newTaskDescription;
    }

    /** Método void */
    public void addTask() {
        if (newTaskDescription == null || newTaskDescription.trim().isEmpty()) {
            addMessage(FacesMessage.SEVERITY_WARN, "Error", "No puedes agregar una tarea vacía");
            return;
        }
        taskService.addTask(newTaskDescription);
        addMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Tarea agregada con éxito");
        newTaskDescription = "";
    }

    /** Método JSF action */
    public String addTaskAction() {
        addTask();
        return null;
    }

    public void removeTask(TaskModel task) {
        taskService.removeTask(task);
        addMessage(FacesMessage.SEVERITY_WARN, "Eliminada", "La tarea fue eliminada correctamente");
    }

    public void toggleCompleted(TaskModel task) {
        taskService.toggleCompleted(task);
        if (task.isCompleted()) {
            addMessage(FacesMessage.SEVERITY_INFO, "Completada", "La tarea fue realizada con éxito");
        } else {
            addMessage(FacesMessage.SEVERITY_INFO, "Pendiente", "La tarea ha sido marcada como pendiente");
        }
    }

    public List<TaskModel> getTasks() {
        return taskService.getAllTasks();
    }

    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(severity, summary, detail));
    }
}