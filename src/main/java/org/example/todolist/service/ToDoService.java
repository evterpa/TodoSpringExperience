package org.example.todolist.service;


import org.example.todolist.model.ToDo;
import org.example.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoService (ToDoRepository toDoRepository){
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getAllToDos(){
        return toDoRepository.findAll();
    }

    public Optional<ToDo> getToDoById(Long id){
        return toDoRepository.findById(id);
    }

    public ToDo createToDo(ToDo todo){
        return toDoRepository.save(todo);
    }

    public ToDo updateToDO(Long id, ToDo updatedToDo){
        if(toDoRepository.existsById(id)){
            updatedToDo.setId(id);
            return toDoRepository.save(updatedToDo);
        }else {
            return null;
        }
    }

    public void deleteToDo(Long id){
        toDoRepository.deleteById(id);
    }

}
