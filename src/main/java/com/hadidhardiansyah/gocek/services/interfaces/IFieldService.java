package com.hadidhardiansyah.gocek.services.interfaces;

import com.hadidhardiansyah.gocek.entities.Field;

import java.util.List;

public interface IFieldService {

    Field addField (Field field) throws Exception;

    List<Field> getAllField() throws Exception;

    Field getById(Integer id) throws Exception;

    void deleteField(Integer id) throws Exception;

    Field updateField(Field field, Integer id) throws Exception;

}
