package com.example.sping_boot_todoapp.controller;

import com.example.sping_boot_todoapp.entity.Task;
import com.example.sping_boot_todoapp.exception.TaskNotFoundException;
import com.example.sping_boot_todoapp.exception.UserNotFoundException;
import com.example.sping_boot_todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity addTask(@RequestBody Task task,
                                  @RequestParam("userId") Long userId){
        try {
            return ResponseEntity.ok(taskService.addTask(task, userId));
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body("Ошибка:\n" + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка:\n" + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity addTask(@RequestParam("id") Long id){
        try {
            return ResponseEntity.ok(taskService.completeTask(id));
        }catch (TaskNotFoundException e){
            return ResponseEntity.badRequest().body("Ошибка:\n" + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка:\n" + e.getMessage());
        }
    }
}
