package com.dongVu1105.demoLibrary.controller;

import com.dongVu1105.demoLibrary.ApiResponse;
import com.dongVu1105.demoLibrary.entity.Book;
import com.dongVu1105.demoLibrary.entity.Category;
import com.dongVu1105.demoLibrary.service.BookService;
import com.dongVu1105.demoLibrary.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CategoryController {
    CategoryService categoryService;

    @PostMapping("/create")
    public ApiResponse<Category> create (@RequestBody Category category) {
        return ApiResponse.<Category>builder()
                .data(categoryService.create(category)).hateoasEntity(categoryService.setHATEOAS()).build();
    }

    @PutMapping("/update")
    public ApiResponse<Category> update (@RequestBody Category category) throws Exception {
        return ApiResponse.<Category>builder()
                .data(categoryService.update(category)).hateoasEntity(categoryService.setHATEOAS()).build();
    }

    @GetMapping("/getAll")
    public ApiResponse<List<Category>> getAll () {
        return ApiResponse.<List<Category>>builder()
                .data(categoryService.getList()).hateoasEntity(categoryService.setHATEOAS()).build();
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<Void> delete (@PathVariable("id") String id) {
        categoryService.deleteCategory(id);
        return ApiResponse.<Void>builder()
                .hateoasEntity(categoryService.setHATEOAS()).build();
    }
}
