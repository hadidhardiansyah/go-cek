package com.hadidhardiansyah.gocek.services.interfaces;

import com.hadidhardiansyah.gocek.entities.Category;

import java.util.List;

public interface ICategoryService {

    Category addCategory (Category category) throws Exception;

    List<Category> getAllCategory() throws Exception;

    Category getById(Integer id) throws Exception;

    void deleteCategory(Integer id)throws Exception;

    Category updateCategory(Category category, Integer id) throws Exception;

}
