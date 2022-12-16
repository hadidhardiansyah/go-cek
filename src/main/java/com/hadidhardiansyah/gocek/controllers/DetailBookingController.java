package com.hadidhardiansyah.gocek.controllers;

import com.hadidhardiansyah.gocek.constants.UrlMapping;
import com.hadidhardiansyah.gocek.entities.DetailBooking;
import com.hadidhardiansyah.gocek.services.interfaces.IDetailBookingService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlMapping.DETAIL_BOOKING_URL)
public class DetailBookingController {

    private ModelMapper modelMapper;

    private IDetailBookingService detailBookingService;

    public DetailBookingController(ModelMapper modelMapper, IDetailBookingService detailBookingService) {
        this.modelMapper = modelMapper;
        this.detailBookingService = detailBookingService;
    }

    @PostMapping
    public ResponseEntity createDetailBooking(@RequestBody DetailBooking detailBooking) throws Exception {

        return null;
    }
}
