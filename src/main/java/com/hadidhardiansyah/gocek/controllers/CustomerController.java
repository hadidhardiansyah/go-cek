package com.hadidhardiansyah.gocek.controllers;

import com.hadidhardiansyah.gocek.constants.UrlMapping;
import com.hadidhardiansyah.gocek.entities.Category;
import com.hadidhardiansyah.gocek.entities.Customer;
import com.hadidhardiansyah.gocek.entities.request.CategoryRequest;
import com.hadidhardiansyah.gocek.entities.request.CustomerRequest;
import com.hadidhardiansyah.gocek.entities.response.SuccessResponse;
import com.hadidhardiansyah.gocek.services.interfaces.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMapping.CUSTOMER_URL)
public class CustomerController {

    private ModelMapper modelMapper;

    private ICustomerService customerService;

    public CustomerController(ModelMapper modelMapper, ICustomerService customerService) {
        this.modelMapper = modelMapper;
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerRequest customerRequest) throws Exception {
        Customer newCustomer = modelMapper.map(customerRequest, Customer.class);
        Customer result = customerService.addCustomer(newCustomer);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success create customer", result));
    }

    @GetMapping
    public ResponseEntity getAllCustomer() throws Exception {
        List<Customer> customerList = customerService.getAllCustomer();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get all customer", customerList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<Customer>> getCustomerById(@PathVariable("id") Integer id) throws Exception {
        Customer customer = customerService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get customer by ID", customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") Integer id) throws Exception {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new SuccessResponse<>("Success delete field", null));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCustomer(@RequestBody CustomerRequest customerRequest, @PathVariable("id") Integer id) throws Exception {
        Customer newCustomer = modelMapper.map(customerRequest, Customer.class);
        Customer result = customerService.updateCustomer(newCustomer, id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Update Category", result));
    }

}
