package com.hadidhardiansyah.gocek.services.implementations;

import com.hadidhardiansyah.gocek.entities.Category;
import com.hadidhardiansyah.gocek.entities.Field;
import com.hadidhardiansyah.gocek.exceptions.NotFoundException;
import com.hadidhardiansyah.gocek.repositories.ICategoryRepository;
import com.hadidhardiansyah.gocek.services.interfaces.ICategoryService;
import com.hadidhardiansyah.gocek.services.interfaces.IFieldService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    private ICategoryRepository categoryRepository;

    private IFieldService fieldService;

    public CategoryService(ICategoryRepository categoryRepository, IFieldService fieldService) {
        this.categoryRepository = categoryRepository;
        this.fieldService = fieldService;
    }

    @Override
    public Category addCategory(Category category) {
        Category newCategory = categoryRepository.save(category);
        return newCategory;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Integer id) {
        Optional<Category> existingCategory = categoryRepository.findByCategoryId(id);
        if (existingCategory.isEmpty()) {
            throw new NotFoundException();
        }
        return existingCategory.get();
    }

    @Override
    public void deleteCategory(Integer id) throws Exception {
        fieldService.getAllField()
                .stream()
                .filter(f -> f.getCategory().getCategoryId().equals(id))
                .forEach(f -> {
                    f.setCategory(null);
                    try {
                        fieldService.updateField(f, f.getFieldId());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        Optional<Category> existingCategory = categoryRepository.findByCategoryId(id);
        if (existingCategory.isEmpty()) {
            throw new NotFoundException();
        }
        categoryRepository.deleteByCategoryId(id);
    }

    @Override
    public Category updateCategory(Category category, Integer id) {
        Optional<Category> existingCategory = categoryRepository.findByCategoryId(id);
        if (existingCategory.isEmpty()) {
            throw new NotFoundException();
        }
        category.setCategoryId(id);
        Category result = categoryRepository.save(category);
        return result;
    }
}
