package com.hadidhardiansyah.gocek.repositories;

import com.hadidhardiansyah.gocek.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IBookingRepository extends JpaRepository<Booking, Integer> {

    @Query(value = "select * from booking b order by b.booking_id", nativeQuery = true)
    List<Booking> findAll();

    @Query(value = "select * from booking b where b.booking_id = ?1", nativeQuery = true)
    Optional<Booking> findByBookingId(Integer bookingId);

    @Transactional
    @Modifying
    @Query(value = "delete from booking b where b.booking_id = ?1", nativeQuery = true)
    void deleteByBookingId(Integer bookingId);

}