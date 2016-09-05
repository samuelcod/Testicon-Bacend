package com.testicon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testicon.model.Booking;
import com.testicon.service.BookingService;

@RestController
public class BookingRestController {

	@Autowired
	private BookingService bookingService; 


	@RequestMapping(value="/bookings", method = RequestMethod.GET)
	public ResponseEntity<List<Booking>> listBookings() {
	    List<Booking> bookings = bookingService.findAll();
	    
	    if(bookings.isEmpty()){
	    	System.out.println("Booking list is empty");
			return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
	}
	
	@RequestMapping(value="/bookings", method = RequestMethod.POST)
	public ResponseEntity<Void>  addNewBooking(@RequestBody Booking booking ) {
		
		System.out.println("addNewBooking(): " );

		bookingService.save(booking);
  
        return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
