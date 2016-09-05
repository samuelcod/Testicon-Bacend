package com.testicon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testicon.model.Booking;
import com.testicon.repository.BookingRepository;

@Service("bookingservice")
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Override
	public List<Booking> findAll() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}

	@Override
	public Booking save(Booking booking) {
		// TODO Auto-generated method stub
		return bookingRepository.saveAndFlush(booking);
	}
}
