package com.dongVu1105.demoLibrary.service;

import com.dongVu1105.demoLibrary.entity.Book;
import com.dongVu1105.demoLibrary.entity.HATEOAS_entity;
import com.dongVu1105.demoLibrary.repository.BookRepository;
import com.dongVu1105.demoLibrary.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class BookService {
    BookRepository bookRepository;

    public Book create (Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getList (){
        return bookRepository.findAll();
    }

    public Book update (Book book) throws Exception {
        Book oldBook = bookRepository.findById(book.getId()).orElseThrow(() -> new Exception("khong thay sach"));
        oldBook.setName(book.getName());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setCategory(book.getCategory());
        return bookRepository.save(oldBook);
    }

    public void deleteBook (String id){
        bookRepository.deleteById(id);
    }

    public HATEOAS_entity setHATEOAS (){
        return HATEOAS_entity.builder()
                .create("http://localhost:8080/book/create")
                .update("http://localhost:8080/book/update")
                .getAll("http://localhost:8080/book/getAll")
                .delete("http://localhost:8080/book/delete/id")
                .build();
    }

}
