package com.example.todolist.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.entities.Tasks;
import com.example.todolist.services.TasksService;

@RestController
@RequestMapping(value = "/tasks")
public class TasksResource {
	
	@Autowired
	TasksService service;
	
	@GetMapping
	public ResponseEntity<List<Tasks>> findAll(){
		List<Tasks> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
		
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tasks> findById(@PathVariable Long id){
		Tasks obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	
	}
	
	
	
	
	
	
	

}
