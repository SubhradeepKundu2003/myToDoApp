package com.subhra.ToDo.repository;

//package com.example.todo.repository;

import com.subhra.ToDo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}

