package com.hadidhardiansyah.gocek.entities.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookingRequest {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private CustomerIdRequest customer;

    private FieldIdRequest field;

}
