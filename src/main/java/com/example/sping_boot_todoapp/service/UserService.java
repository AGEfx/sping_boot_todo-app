package com.example.sping_boot_todoapp.service;

import com.example.sping_boot_todoapp.entity.User;
import com.example.sping_boot_todoapp.exception.UserAlreadyExistsException;
import com.example.sping_boot_todoapp.exception.UserNotFoundException;
import com.example.sping_boot_todoapp.model.UserModel;
import com.example.sping_boot_todoapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public User addUser(User user) throws UserAlreadyExistsException {
        if (userRepo.findByName(user.getName()) != null){
            throw new UserAlreadyExistsException("Пользовтель с таким именем уже существует");
        }
       return userRepo.save(user);
    }

    public UserModel getUserById(Long id) throws UserNotFoundException {
        User user = userRepo.findById(id).orElse(null);
        if (user == null){
            throw new UserNotFoundException("Пользователь с id = "+ id + " не найден");
        }
        return UserModel.toModel(user);
    }

    public void deleteUser(Long id) throws UserNotFoundException {
        User user = userRepo.findById(id).orElse(null);
        if (user == null){
            throw new UserNotFoundException("Пользователь с id = "+ id + " не найден");
        }
        userRepo.delete(user);
    }
}
