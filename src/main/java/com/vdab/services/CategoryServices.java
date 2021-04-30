package com.vdab.services;


import com.vdab.Repositories.CategoryRepository;
import com.vdab.domain.Category;

public class CategoryServices {
    CategoryRepository categoryRepository = new CategoryRepository();


    public Category findCategory1() {
        return categoryRepository.findCategory1();
    }
}
