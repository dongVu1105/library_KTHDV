package com.dongVu1105.demoLibrary.service;

import com.dongVu1105.demoLibrary.entity.Category;
import com.dongVu1105.demoLibrary.entity.HATEOAS_entity;
import com.dongVu1105.demoLibrary.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CategoryService {
    CategoryRepository categoryRepository;

    public Category create (Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getList (){
        return categoryRepository.findAll();
    }

    public Category update (Category category) throws Exception {
        Category oldCategory = categoryRepository.findById(category.getName()).orElseThrow(() -> new Exception("khong thay category"));
        oldCategory.setName(category.getName());
        oldCategory.setDescription(category.getDescription());
        return categoryRepository.save(oldCategory);
    }

    public void deleteCategory (String id){
        categoryRepository.deleteById(id);
    }

    public HATEOAS_entity setHATEOAS (){
        return HATEOAS_entity.builder()
                .create("http://localhost:8080/category/create")
                .update("http://localhost:8080/category/update")
                .getAll("http://localhost:8080/category/getAll")
                .delete("http://localhost:8080/category/delete/id")
                .build();
    }
}
