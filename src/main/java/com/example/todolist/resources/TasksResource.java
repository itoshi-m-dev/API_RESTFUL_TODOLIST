package com.example.todolist.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Tasks> insert(@RequestBody Tasks obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
		
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Tasks> update(@PathVariable Long id, @RequestBody Tasks obj){
		obj = service.update(id, obj);
		return  ResponseEntity.ok().body(obj);
	
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id){
		service.remove(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	
	
	
	

}
