package com.example.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todolist.entities.Tasks;
import com.example.todolist.repositories.TasksRepository;
import com.example.todolist.services.exceptions.ResourceNotFound;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TasksService {

	@Autowired
	public TasksRepository repository;

	public List<Tasks> findAll() {
		return repository.findAll();
	}

	public Tasks findById(Long id) {
		Optional<Tasks> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFound(id));

	}

	public Tasks insert(Tasks obj) {
		return repository.save(obj);
	}

	public Tasks update(Long id, Tasks obj) {
		try {
			Tasks entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFound(id);
		}

	}

	private void updateData(Tasks entity, Tasks obj) {
		entity.setTitle(obj.getTitle());
		entity.setDescription(obj.getDescription());
		entity.setStatus(obj.getStatus());
		entity.setDue_date(obj.getDue_date());

	}
	
	public void remove(Long id) {
		 repository.deleteById(id);;
	}

}
