package com.dongVu1105.demoLibrary.entity;

import jakarta.persistence.*;
import lombok.*;

import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;
    String author;
    String category;
}
