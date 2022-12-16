package com.hadidhardiansyah.gocek.controllers;

import com.hadidhardiansyah.gocek.constants.UrlMapping;
import com.hadidhardiansyah.gocek.entities.Category;
import com.hadidhardiansyah.gocek.entities.request.CategoryRequest;
import com.hadidhardiansyah.gocek.entities.response.SuccessResponse;
import com.hadidhardiansyah.gocek.services.interfaces.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMapping.CATEGORY_URL)
public class CategoryController {

    private ModelMapper modelMapper;

    private ICategoryService categoryService;

    public CategoryController(ModelMapper modelMapper, ICategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity createCategory(@RequestBody CategoryRequest categoryRequest) throws Exception {
        Category newCategory = modelMapper.map(categoryRequest, Category.class);
        Category result = categoryService.addCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success create category", result));
    }

    @GetMapping
    public ResponseEntity getAllCategory() throws Exception {
        List<Category> categoryList = categoryService.getAllCategory();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get all category", categoryList));
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategoryById(@PathVariable("id") Integer id) throws Exception {
        Category category = categoryService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get category by ID", category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable("id") Integer id) throws Exception {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new SuccessResponse<>("Success delete category", null));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCategory(@RequestBody CategoryRequest categoryRequest, @PathVariable("id") Integer id) throws Exception {
        Category newCategory = modelMapper.map(categoryRequest, Category.class);
        Category result = categoryService.updateCategory(newCategory, id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Update Category", result));
    }

}
