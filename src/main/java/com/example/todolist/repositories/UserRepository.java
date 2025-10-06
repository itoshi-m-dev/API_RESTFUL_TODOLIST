package com.example.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{

}