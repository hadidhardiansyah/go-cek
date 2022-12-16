package com.hadidhardiansyah.gocek.services.implementations;

import com.hadidhardiansyah.gocek.entities.Customer;
import com.hadidhardiansyah.gocek.exceptions.NotFoundException;
import com.hadidhardiansyah.gocek.repositories.ICustomerRepository;
import com.hadidhardiansyah.gocek.services.interfaces.IBookingService;
import com.hadidhardiansyah.gocek.services.interfaces.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    private ICustomerRepository customerRepository;

    private IBookingService bookingService;

    public CustomerService(ICustomerRepository categoryRepository, IBookingService bookingService) {
        this.customerRepository = categoryRepository;
        this.bookingService = bookingService;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(Integer id) {
        Optional<Customer> existingCustomer = customerRepository.findByCustomerId(id);
        if (existingCustomer.isEmpty()) {
            throw new NotFoundException();
        }
        return existingCustomer.get();
    }

    @Override
    public void deleteCustomer(Integer id) {
        bookingService.getAllBooking()
                .stream()
                .filter(b -> b.getCustomer().getCustomerId().equals(id))
                .forEach(b -> bookingService.deleteBooking(b.getBookingId()));

        Optional<Customer> existingCustomer = customerRepository.findByCustomerId(id);
        if (existingCustomer.isEmpty()) {
            throw new NotFoundException();
        }
        customerRepository.deleteByCustomerId(id);
    }

    @Override
    public Customer updateCustomer(Customer customer, Integer id) {
        Optional<Customer> existingCustomer = customerRepository.findByCustomerId(id);
        if (existingCustomer.isEmpty()) {
            throw new NotFoundException();
        }
        customer.setCustomerId(id);
        Customer result = customerRepository.save(customer);
        return result;
    }

}
