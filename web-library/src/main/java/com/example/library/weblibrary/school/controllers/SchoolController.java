package com.example.library.weblibrary.school.controllers;

import com.example.library.weblibrary.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService service;

}
