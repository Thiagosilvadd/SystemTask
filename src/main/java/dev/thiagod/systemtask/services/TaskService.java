package dev.thiagod.systemtask.services;

import dev.thiagod.systemtask.entities.Task;
import dev.thiagod.systemtask.repositories.TaskRepository;
import dev.thiagod.systemtask.services.exceptions.DatabaseException;
import dev.thiagod.systemtask.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> findAll(){
        return repository.findAll();
    }

    public Task findById(Long id){
        Optional<Task> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Task insert(Task obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        try{
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Task update(Long id, Task obj){
        try{
            Task entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (RuntimeException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Task entity, Task obj) {
        entity.setTitle(obj.getTitle());
        entity.setTaskStatus(obj.getTaskStatus());
        entity.setImageUrl(obj.getImageUrl());
        entity.setModifiedOnMoment(Instant.now());
    }


}
