package com.dongVu1105.demoLibrary;

import com.dongVu1105.demoLibrary.entity.HATEOAS_entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse <T> {
    T data;
    HATEOAS_entity hateoasEntity;
}
