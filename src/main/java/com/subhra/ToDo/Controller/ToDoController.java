package com.subhra.ToDo.Controller;

import com.subhra.ToDo.dto.TodoDto;
import com.subhra.ToDo.model.Todo;
import com.subhra.ToDo.service.TodoSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {

    @Autowired
    private TodoSevice todoSevice;

    @GetMapping("/getAll")
    public ResponseEntity<List<Todo>> todoResponseEntity(){
        return ResponseEntity.ok(todoSevice.getTodos());
    }
    @PostMapping("/addTodo")
    public ResponseEntity<Todo> todoAdd(@RequestBody TodoDto todoDto){
        Todo todo = todoSevice.addTodo(todoDto);
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/deleteTodo/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id){
        todoSevice.deleteTodo(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @PatchMapping("/completed/{id}")
    public ResponseEntity<List<Todo>> completed(@PathVariable Long id){
        todoSevice.completed(id);
        return ResponseEntity.ok(todoSevice.getTodos());
    }
}
