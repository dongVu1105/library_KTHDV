package com.dongVu1105.demoLibrary.service;

import com.dongVu1105.demoLibrary.entity.Author;
import com.dongVu1105.demoLibrary.entity.Category;
import com.dongVu1105.demoLibrary.entity.HATEOAS_entity;
import com.dongVu1105.demoLibrary.repository.AuthorRepository;
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
public class AuthorService {
    AuthorRepository authorRepository;

    public Author create (Author author) {
        return authorRepository.save(author);
    }

    public List<Author> getList (){
        return authorRepository.findAll();
    }

    public Author update (Author author) throws Exception {
        Author oldAuthor = authorRepository.findById(author.getId()).orElseThrow(() -> new Exception("khong thay author"));
        oldAuthor.setId(author.getId());
        oldAuthor.setFirstName(author.getFirstName());
        oldAuthor.setLastName(author.getLastName());
        return authorRepository.save(oldAuthor);
    }

    public void deleteAuthor (String id){
        authorRepository.deleteById(id);
    }

    public HATEOAS_entity setHATEOAS (){
        return HATEOAS_entity.builder()
                .create("http://localhost:8080/author/create")
                .update("http://localhost:8080/author/update")
                .getAll("http://localhost:8080/author/getAll")
                .delete("http://localhost:8080/author/delete/id")
                .build();
    }
}
