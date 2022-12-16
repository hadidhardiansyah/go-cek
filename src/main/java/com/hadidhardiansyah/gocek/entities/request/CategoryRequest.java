package com.hadidhardiansyah.gocek.entities.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {

    private String categoryField;

    private String description;

    private Integer price;

}
