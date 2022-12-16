package com.hadidhardiansyah.gocek.services.implementations;

import com.hadidhardiansyah.gocek.entities.Booking;
import com.hadidhardiansyah.gocek.entities.DetailBooking;
import com.hadidhardiansyah.gocek.exceptions.NotFoundException;
import com.hadidhardiansyah.gocek.repositories.IBookingRepository;
import com.hadidhardiansyah.gocek.repositories.IDetailBookingRepository;
import com.hadidhardiansyah.gocek.services.interfaces.IDetailBookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailBookingService implements IDetailBookingService {

    private IDetailBookingRepository detailBookingRepository;

    private IBookingRepository bookingRepository;

    public DetailBookingService(IDetailBookingRepository detailBookingRepository, IBookingRepository bookingRepository) {
        this.detailBookingRepository = detailBookingRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public DetailBooking addDetailBooking(DetailBooking detailBooking) {
        Integer bookingId = detailBooking.getBooking().getBookingId();
        Optional<Booking> existingBooking = bookingRepository.findByBookingId(bookingId);
        detailBooking.setBooking(existingBooking.get());

        DetailBooking newDetailBooking = detailBookingRepository.save(detailBooking);

        if (existingBooking.isEmpty()) {
            throw new NotFoundException("Booking is not Found");
        }
        return newDetailBooking;
    }

    @Override
    public List<DetailBooking> getAllDetailBooking() {
        return detailBookingRepository.findAll();
    }

    @Override
    public DetailBooking getById(Integer id) {
        Optional<DetailBooking> existingDetailBooking = detailBookingRepository.findByDetailBookingId(id);
        if (existingDetailBooking.isEmpty()) {
            throw new NotFoundException();
        }
        return existingDetailBooking.get();
    }

    @Override
    public void deleteDetailBooking(Integer id) {
        Optional<DetailBooking> existingDetailBooking = detailBookingRepository.findByDetailBookingId(id);
        if (existingDetailBooking.isEmpty()) {
            throw new NotFoundException();
        }
        detailBookingRepository.deleteByDetailBookingId(id);
    }

    @Override
    public DetailBooking updateDetailBooking(DetailBooking detailBooking, Integer id) {
        Optional<DetailBooking> existingDetailBooking = detailBookingRepository.findByDetailBookingId(id);
        if (existingDetailBooking.isEmpty()) {
            throw new NotFoundException();
        }
        detailBooking.setDetailBookingId(id);
        DetailBooking result = detailBookingRepository.save(detailBooking);
        return result;
    }
}
