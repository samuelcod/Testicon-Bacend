package com.testicon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testicon.model.Booking;

@Repository("bookingRepository")
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
