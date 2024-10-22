package org.example.todolist.controller;


import org.example.todolist.model.ToDo;
import org.example.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDo> getAllToDos(){
        return toDoService.getAllToDos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id){
        Optional<ToDo> todo = toDoService.getToDoById(id);
        return todo.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo todo){
        ToDo createdToDo = toDoService.createToDo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdToDo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable Long id, @RequestBody ToDo updatedToDo){
        ToDo todo = toDoService.updateToDO(id, updatedToDo);
        return todo!=null? ResponseEntity.ok(todo):ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDoById(@PathVariable Long id){
        toDoService.deleteToDo(id);
        return ResponseEntity.noContent().build();
    }
}
