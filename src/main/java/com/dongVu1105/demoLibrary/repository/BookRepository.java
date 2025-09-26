package com.dongVu1105.demoLibrary.repository;


import com.dongVu1105.demoLibrary.entity.Book;
import com.dongVu1105.demoLibrary.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
