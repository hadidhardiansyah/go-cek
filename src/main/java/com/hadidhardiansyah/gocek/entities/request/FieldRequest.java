package com.hadidhardiansyah.gocek.entities.request;

import com.hadidhardiansyah.gocek.entities.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldRequest {

    private String fieldName;

    private CategoryIdRequest category;

}

