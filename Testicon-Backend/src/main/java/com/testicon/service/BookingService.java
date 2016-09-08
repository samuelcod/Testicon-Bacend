package com.testicon.service;

import java.util.List;

import com.testicon.model.Booking;

public interface BookingService {
	List<Booking> findAll();
	//Booking save(Booking booking);
}
