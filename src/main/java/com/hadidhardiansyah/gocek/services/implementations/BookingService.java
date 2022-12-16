package com.hadidhardiansyah.gocek.services.implementations;

import com.hadidhardiansyah.gocek.entities.Booking;
import com.hadidhardiansyah.gocek.entities.Customer;
import com.hadidhardiansyah.gocek.entities.Field;
import com.hadidhardiansyah.gocek.exceptions.NotFoundException;
import com.hadidhardiansyah.gocek.repositories.IBookingRepository;
import com.hadidhardiansyah.gocek.repositories.ICustomerRepository;
import com.hadidhardiansyah.gocek.repositories.IFieldRepository;
import com.hadidhardiansyah.gocek.services.interfaces.IBookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements IBookingService {

    private IBookingRepository bookingRepository;

    private IFieldRepository fieldRepository;

    private ICustomerRepository customerRepository;

    public BookingService(IBookingRepository bookingRepository, IFieldRepository fieldRepository, ICustomerRepository customerRepository) {
        this.bookingRepository = bookingRepository;
        this.fieldRepository = fieldRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Booking addBooking(Booking booking) {
        Integer fieldId = booking.getField().getFieldId();
        Integer customerId = booking.getCustomer().getCustomerId();

        Optional<Field> existingField = fieldRepository.findByFieldId(fieldId);
        Optional<Customer> existingCustomer = customerRepository.findByCustomerId(customerId);

        if (existingField.isEmpty() && existingCustomer.isEmpty()) {
            throw new NotFoundException("Field and Customer is not found");
        }

        if (existingField.isEmpty()) {
            throw new NotFoundException("Field is not found");
        }
        if (existingCustomer.isEmpty()) {
            throw new NotFoundException("Customer is not found");
        }

        booking.setField(existingField.get());
        booking.setCustomer(existingCustomer.get());

        Booking newBooking = bookingRepository.save(booking);

        return newBooking;
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getById(Integer id) {
        Optional<Booking> existingBooking = bookingRepository.findByBookingId(id);
        if (existingBooking.isEmpty()) {
            throw new NotFoundException();
        }
        return existingBooking.get();
    }

    @Override
    public void deleteBooking(Integer id) {


        Optional<Booking> existingBooking = bookingRepository.findByBookingId(id);
        if (existingBooking.isEmpty()) {
            throw new NotFoundException();
        }
        bookingRepository.deleteByBookingId(id);
    }

    @Override
    public Booking updateBooking(Booking booking, Integer id) {
        Optional<Booking> existingBooking = bookingRepository.findByBookingId(id);
        if (existingBooking.isEmpty()) {
            throw new NotFoundException();
        }
        booking.setBookingId(id);
        Booking result = bookingRepository.save(booking);
        return result;
    }
}
