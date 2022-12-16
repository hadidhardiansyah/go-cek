package com.hadidhardiansyah.gocek.services.interfaces;

import com.hadidhardiansyah.gocek.entities.Booking;
import com.hadidhardiansyah.gocek.entities.Category;

import java.util.List;

public interface IBookingService {

    Booking addBooking (Booking booking);

    List<Booking> getAllBooking();

    Booking getById(Integer id);

    void deleteBooking(Integer id);

    Booking updateBooking(Booking booking, Integer id);


}
