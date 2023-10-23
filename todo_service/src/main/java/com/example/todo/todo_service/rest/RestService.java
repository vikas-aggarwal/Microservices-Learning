package com.example.todo.todo_service.rest;

import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.todo_service.repo.TodoRepo;

@RestController
@RequestMapping("/todos")
public class RestService {


    TodoRepo todoRepo;

    public RestService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }
    
    @RequestMapping("/")
    public String getAllTodos() throws InterruptedException, ExecutionException {
        return todoRepo.getTodos();
    }
}
