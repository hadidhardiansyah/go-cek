package com.hadidhardiansyah.gocek.controllers;

import com.hadidhardiansyah.gocek.constants.UrlMapping;
import com.hadidhardiansyah.gocek.entities.Field;
import com.hadidhardiansyah.gocek.entities.request.FieldRequest;
import com.hadidhardiansyah.gocek.entities.response.SuccessResponse;
import com.hadidhardiansyah.gocek.services.interfaces.IFieldService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMapping.FIELD_URL)
public class FieldController {

    private ModelMapper modelMapper;

    private IFieldService fieldService;

    public FieldController(ModelMapper modelMapper, IFieldService fieldService) {
        this.modelMapper = modelMapper;
        this.fieldService = fieldService;
    }

    @PostMapping
    public ResponseEntity createField(@RequestBody FieldRequest fieldRequest) throws Exception {
        Field newField = modelMapper.map(fieldRequest, Field.class);
        Field result = fieldService.addField(newField);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success create field", result));
    }

    @GetMapping
    public ResponseEntity getAllField() throws Exception {
        List<Field> fieldList = fieldService.getAllField();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get all field", fieldList));
    }

    @GetMapping("/{id}")
    public ResponseEntity getFieldById(@PathVariable("id") Integer id) throws Exception {
        Field field = fieldService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get field by ID", field));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteField(@PathVariable("id") Integer id) throws Exception {
        fieldService.deleteField(id);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new SuccessResponse<>("Success delete field", null));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateField(@RequestBody FieldRequest fieldRequest, @PathVariable("id") Integer id) throws Exception {
        Field newField = modelMapper.map(fieldRequest, Field.class);
        Field result = fieldService.updateField(newField, id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success update field", result));
    }

}
