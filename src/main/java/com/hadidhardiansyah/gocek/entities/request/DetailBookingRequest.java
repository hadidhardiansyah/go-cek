package com.hadidhardiansyah.gocek.entities.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailBookingRequest {

    private String bookingStart;

    private String bookingEnd;

    private BookingIdRequest bookingId;


}
