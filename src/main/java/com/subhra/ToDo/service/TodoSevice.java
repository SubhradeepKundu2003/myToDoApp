package com.subhra.ToDo.service;

import com.subhra.ToDo.dto.TodoDto;
import com.subhra.ToDo.model.Todo;
import com.subhra.ToDo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoSevice {
    @Autowired
    private TodoRepository todoRepository;
     public List<Todo> getTodos(){
         return todoRepository.findAll();
     }
    public Todo addTodo(TodoDto todoDto) {
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setDueDate(todoDto.getDueDate());
        todo.setCompleted(false); // default to not completed
        todo.setCreatedAt(java.time.LocalDate.now());

        return todoRepository.save(todo);
    }
    public void deleteTodo(Long id){
//         Todo todo = new Todo();
         ;
         todoRepository.deleteById(id);
        todoRepository.findById(id);
    }

    public void completed( Long id) {
         Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
         todo.setCompleted(true);


    }
}
