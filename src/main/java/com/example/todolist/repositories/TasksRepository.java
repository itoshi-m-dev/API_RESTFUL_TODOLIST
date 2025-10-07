package com.example.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.entities.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Long>{

}
