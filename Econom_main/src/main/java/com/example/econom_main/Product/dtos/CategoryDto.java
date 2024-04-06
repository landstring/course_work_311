package com.example.econom_main.Product.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private String image_url;
    private Boolean isFinal;
    private Long parent_id;
}
