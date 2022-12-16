package com.hadidhardiansyah.gocek.repositories;

import com.hadidhardiansyah.gocek.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer c order by c.customer_id", nativeQuery = true)
    List<Customer> findAll();

    @Query(value = "select * from customer c where c.customer_id = ?1", nativeQuery = true)
    Optional<Customer> findByCustomerId(Integer customerId);

    @Transactional
    @Modifying
    @Query(value = "delete from customer c where c.customer_id = ?1", nativeQuery = true)
    void deleteByCustomerId(Integer customerId);









}