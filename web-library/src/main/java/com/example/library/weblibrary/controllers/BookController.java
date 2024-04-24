package com.example.library.weblibrary.book;

import com.example.library.weblibrary.uris.Endpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final Endpoints endpoints;
    private final Book book;
}
