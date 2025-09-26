package com.dongVu1105.demoLibrary.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class HATEOAS_entity {
    String create;
    String update;
    String delete;
    String getAll;
}
