package com.example.sping_boot_todoapp.service;

import com.example.sping_boot_todoapp.entity.Task;
import com.example.sping_boot_todoapp.entity.User;
import com.example.sping_boot_todoapp.exception.TaskNotFoundException;
import com.example.sping_boot_todoapp.exception.UserNotFoundException;
import com.example.sping_boot_todoapp.model.TaskModel;
import com.example.sping_boot_todoapp.model.UserModel;
import com.example.sping_boot_todoapp.repository.TaskRepo;
import com.example.sping_boot_todoapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private UserRepo userRepo;

    public TaskModel addTask(Task task, Long userId) throws UserNotFoundException {
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("Пользователь с id = " + userId + " не найден");
        }
        task.setUser(user);
        return TaskModel.toModel(taskRepo.save(task));
    }

    public TaskModel completeTask(Long id) throws TaskNotFoundException {
        Task task = taskRepo.findById(id).orElse(null);
        if (task == null) {
            throw new TaskNotFoundException("Задача с id = " + id + " не найдена");
        }
        task.setCompleted(true);
        return TaskModel.toModel(taskRepo.save(task));
    }
}
