package com.hadidhardiansyah.gocek.services.interfaces;

import com.hadidhardiansyah.gocek.entities.Customer;

import java.util.List;

public interface ICustomerService {

    Customer addCustomer (Customer customer);

    List<Customer> getAllCustomer();

    Customer getById(Integer id);

    void deleteCustomer(Integer id);

    Customer updateCustomer(Customer customer, Integer id);

}
