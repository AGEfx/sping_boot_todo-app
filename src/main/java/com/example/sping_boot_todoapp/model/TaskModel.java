package com.example.sping_boot_todoapp.model;

import com.example.sping_boot_todoapp.entity.Task;

public class TaskModel {
    private Long id;
    private String title;
    private boolean isCompleted;

    public static TaskModel toModel(Task task){
        TaskModel taskModel = new TaskModel();
        taskModel.setId(task.getId());
        taskModel.setTitle(task.getTitle());
        taskModel.setCompleted(task.isCompleted());
        return taskModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public TaskModel() {
    }
}
