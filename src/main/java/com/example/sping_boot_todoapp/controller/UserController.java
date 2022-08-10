package com.example.sping_boot_todoapp.controller;

import com.example.sping_boot_todoapp.entity.User;
import com.example.sping_boot_todoapp.exception.UserAlreadyExistsException;
import com.example.sping_boot_todoapp.exception.UserNotFoundException;
import com.example.sping_boot_todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            return ResponseEntity.ok("User added successfully");
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body("Ошибка:\n" + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка:\n" + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getUserById(@RequestParam("id") Long id) {
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body("Ошибка:\n" + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка:\n" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id){
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("Пользователь успешно удален");
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body("Ошибка:\n" + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка:\n" + e.getMessage());
        }
    }

}
