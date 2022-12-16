package com.hadidhardiansyah.gocek.services.interfaces;

import com.hadidhardiansyah.gocek.entities.DetailBooking;

import java.util.List;

public interface IDetailBookingService {

    DetailBooking addDetailBooking(DetailBooking detailBooking);

    List<DetailBooking> getAllDetailBooking();

    DetailBooking getById(Integer id);

    void deleteDetailBooking(Integer id);

    DetailBooking updateDetailBooking(DetailBooking detailBooking, Integer id);

}
