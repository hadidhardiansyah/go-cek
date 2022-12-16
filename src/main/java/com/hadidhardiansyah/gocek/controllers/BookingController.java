package com.hadidhardiansyah.gocek.controllers;

import com.hadidhardiansyah.gocek.constants.UrlMapping;
import com.hadidhardiansyah.gocek.entities.Booking;
import com.hadidhardiansyah.gocek.entities.request.BookingRequest;
import com.hadidhardiansyah.gocek.entities.response.SuccessResponse;
import com.hadidhardiansyah.gocek.services.interfaces.IBookingService;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMapping.BOOKING_URL)
public class BookingController {

    private ModelMapper modelMapper;

    private IBookingService bookingService;

    public BookingController(ModelMapper modelMapper, IBookingService bookingService) {
        this.modelMapper = modelMapper;
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity createBooking(@RequestBody BookingRequest bookingRequest) throws Exception {
        Booking newBooking = modelMapper.map(bookingRequest, Booking.class);
        Booking result = bookingService.addBooking(newBooking);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success create booking", result));
    }

    @GetMapping
    public ResponseEntity getAllBooking() throws Exception {
        List<Booking> bookingList = bookingService.getAllBooking();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get all booking", bookingList));
    }

    @GetMapping("/{id}")
    public ResponseEntity getBookingById(@PathVariable("id") Integer id) throws Exception {
        Booking booking = bookingService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get booking by ID", booking));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBooking(@PathVariable("id") Integer id) throws Exception {
        bookingService.deleteBooking(id);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new SuccessResponse<>("Success delete booking", null));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBooking(@RequestBody BookingRequest bookingRequest, @PathVariable("id") Integer id) throws Exception {
        Booking newBooking = modelMapper.map(bookingRequest, Booking.class);
        Booking result = bookingService.updateBooking(newBooking, id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Update Category", result));
    }

}
