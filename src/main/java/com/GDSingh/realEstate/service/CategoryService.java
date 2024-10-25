package com.GDSingh.realEstate.service;


import com.GDSingh.realEstate.entity.Category;

public interface CategoryService {
    Category saveCategory(Category category);
    Category updateCategory(Category category);
    Category getCategory(Long id);
}
