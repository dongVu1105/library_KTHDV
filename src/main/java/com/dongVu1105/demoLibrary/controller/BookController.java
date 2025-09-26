package com.dongVu1105.demoLibrary.controller;

import com.dongVu1105.demoLibrary.ApiResponse;
import com.dongVu1105.demoLibrary.entity.Book;
import com.dongVu1105.demoLibrary.service.BookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class BookController {
    BookService bookService;

    @PostMapping("/create")
    public ApiResponse<Book> create (@RequestBody Book book) {
        return ApiResponse.<Book>builder()
                .data(bookService.create(book)).hateoasEntity(bookService.setHATEOAS()).build();
    }

    @PutMapping("/update")
    public ApiResponse<Book> update (@RequestBody Book book) throws Exception {
        return ApiResponse.<Book>builder()
                .data(bookService.update(book)).hateoasEntity(bookService.setHATEOAS()).build();
    }

    @GetMapping("/getAll")
    public ApiResponse<List<Book>> getAll () {
        return ApiResponse.<List<Book>>builder()
                .data(bookService.getList()).hateoasEntity(bookService.setHATEOAS()).build();
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<Void> delete (@PathVariable("id") String id) {
        bookService.deleteBook(id);
        return ApiResponse.<Void>builder()
                .hateoasEntity(bookService.setHATEOAS()).build();
    }

}
