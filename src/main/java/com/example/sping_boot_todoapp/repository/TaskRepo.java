package com.example.sping_boot_todoapp.repository;

import com.example.sping_boot_todoapp.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepo extends CrudRepository<Task,Long> {
}
