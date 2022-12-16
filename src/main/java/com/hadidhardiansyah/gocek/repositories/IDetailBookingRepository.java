package com.hadidhardiansyah.gocek.repositories;

import com.hadidhardiansyah.gocek.entities.DetailBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IDetailBookingRepository extends JpaRepository<DetailBooking, Integer> {

    @Query(value = "select * from detail_booking db order by db.detail_booking_id", nativeQuery = true)
    List<DetailBooking> findAll();

    @Query(value = "select * from detail_booking db where db.detail_booking_id = ?1", nativeQuery = true)
    Optional<DetailBooking> findByDetailBookingId(Integer detailBookingId);

    @Transactional
    @Modifying
    @Query(value = "delete from detail_booking db where db.detail_booking_id = ?1", nativeQuery = true)
    void deleteByDetailBookingId(Integer detailBookingId);

}