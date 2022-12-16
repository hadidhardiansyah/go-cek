package com.hadidhardiansyah.gocek.services.implementations;

import com.hadidhardiansyah.gocek.entities.Category;
import com.hadidhardiansyah.gocek.entities.Field;
import com.hadidhardiansyah.gocek.exceptions.NotFoundException;
import com.hadidhardiansyah.gocek.repositories.ICategoryRepository;
import com.hadidhardiansyah.gocek.repositories.IFieldRepository;
import com.hadidhardiansyah.gocek.services.interfaces.IBookingService;
import com.hadidhardiansyah.gocek.services.interfaces.IFieldService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FieldService implements IFieldService {

    private IFieldRepository fieldRepository;

    private ICategoryRepository categoryRepository;

    private IBookingService bookingService;

    public FieldService(IFieldRepository fieldRepository, ICategoryRepository categoryRepository, IBookingService bookingService) {
        this.fieldRepository = fieldRepository;
        this.categoryRepository = categoryRepository;
        this.bookingService = bookingService;
    }

    @Override
    public Field addField(Field field) {
        Integer categoryId = field.getCategory().getCategoryId();

        Optional<Category> existingCategory = categoryRepository.findByCategoryId(categoryId);

        field.setCategory(existingCategory.get());

        Field newField = fieldRepository.save(field);

        if (existingCategory.isEmpty()) {
            throw new NotFoundException("Category is not found");
        }
        return newField;
    }

    @Override
    public List<Field> getAllField() {
        return fieldRepository.findAll();
    }

    @Override
    public Field getById(Integer id) {
        Optional<Field> existingField = fieldRepository.findByFieldId(id);
        if (existingField.isEmpty()) {
            throw new NotFoundException();
        }
        return existingField.get();
    }

    @Override
    public void deleteField(Integer id) {
        bookingService.getAllBooking()
                .stream()
                .filter(b -> b.getField().getFieldId().equals(id))
                .forEach(b -> bookingService.deleteBooking(b.getBookingId()));

        Optional<Field> existingField = fieldRepository.findByFieldId(id);
        if (existingField.isEmpty()) {
            throw new NotFoundException();
        }
        fieldRepository.deleteByFieldId(id);
    }

    @Override
    public Field updateField(Field field, Integer id) {
        Optional<Field> existingField = fieldRepository.findByFieldId(id);
        if (existingField.isEmpty()) {
            throw new NotFoundException();
        }
        field.setFieldId(id);
        Field result = fieldRepository.save(field);
        return result;
    }

}
