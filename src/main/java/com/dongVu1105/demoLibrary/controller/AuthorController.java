package com.dongVu1105.demoLibrary.controller;

import com.dongVu1105.demoLibrary.ApiResponse;
import com.dongVu1105.demoLibrary.entity.Author;
import com.dongVu1105.demoLibrary.entity.Book;
import com.dongVu1105.demoLibrary.service.AuthorService;
import com.dongVu1105.demoLibrary.service.BookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AuthorController {
    AuthorService authorService;

    @PostMapping("/create")
    public ApiResponse<Author> create (@RequestBody Author author) {
        return ApiResponse.<Author>builder()
                .data(authorService.create(author)).hateoasEntity(authorService.setHATEOAS()).build();
    }

    @PutMapping("/update")
    public ApiResponse<Author> update (@RequestBody Author author) throws Exception {
        return ApiResponse.<Author>builder()
                .data(authorService.update(author)).hateoasEntity(authorService.setHATEOAS()).build();
    }

    @GetMapping("/getAll")
    public ApiResponse<List<Author>> getAll () {
        return ApiResponse.<List<Author>>builder()
                .data(authorService.getList()).hateoasEntity(authorService.setHATEOAS()).build();
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<Void> delete (@PathVariable("id") String id) {
        authorService.deleteAuthor(id);
        return ApiResponse.<Void>builder()
                .hateoasEntity(authorService.setHATEOAS()).build();
    }
}
