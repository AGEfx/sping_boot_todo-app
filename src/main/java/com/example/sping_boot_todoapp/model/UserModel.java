package com.example.sping_boot_todoapp.model;
/*
Сlass that provides only the information about the user
that is necessary for exchange between the server and the client.

The class contains only those fields that will be used on the client.

In this case we exclude the field with the password;
 */

import com.example.sping_boot_todoapp.entity.Task;
import com.example.sping_boot_todoapp.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserModel {
    private Long id;
    private String name;

    public List<TaskModel> getTasks() {
        return tasks;
    }

    public static UserModel toModel(User user) {
        UserModel model = new UserModel();
        model.setId(user.getId());
        model.setName(user.getName());
        model.setTasks(user.getTasks().stream().map(x->TaskModel.toModel(x))
                .collect(Collectors.toList()));
        return model;
    }

    public void setTasks(List<TaskModel> tasks) {
        this.tasks = tasks;
    }

    private List<TaskModel> tasks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserModel() {
    }
}
