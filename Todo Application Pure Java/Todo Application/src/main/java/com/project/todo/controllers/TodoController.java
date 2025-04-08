package com.project.todo.controllers;

import com.project.todo.model.Todo;
import com.project.todo.repository.TodoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@SessionAttributes("name")
public class TodoController {

    private final TodoRepository repository;

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        List<Todo> todos = repository.findAll();
        model.addAttribute("todos", todos);

        return "listTodos";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        String username = getLoggedInUsername();
        model.addAttribute("todo", new Todo(0, username, "", LocalDate.now().plusYears(1), false));
        return "todo";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addNewTodo(@Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        todo.setUsername(getLoggedInUsername());
        repository.save(todo);

        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam long id){
        repository.deleteById(id);

        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam long id, ModelMap model) {
        Optional<Todo> optionalTodo = repository.findById(id);

        if (optionalTodo.isEmpty()) {
            throw new RuntimeException();
        }

        Todo todo = optionalTodo.get();
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo( @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        todo.setUsername(getLoggedInUsername());
        repository.save(todo);
        return "redirect:list-todos";
    }

    private static String getLoggedInUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
