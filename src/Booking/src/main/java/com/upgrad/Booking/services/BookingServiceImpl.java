package com.upgrad.Booking.services;

import com.upgrad.Booking.dao.BookingDAO;
import com.upgrad.Booking.entity.BookingInfoEntity;
import com.upgrad.Booking.exceptions.PaymentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    public BookingDAO _bookingDAO;

    @Override
    public BookingInfoEntity saveBooking(BookingInfoEntity booking) {
        return _bookingDAO.save(booking);
    }

    @Override
    public BookingInfoEntity getBooking(int id) {

        Optional<BookingInfoEntity> obj = _bookingDAO.findById(id);

        if(!obj.isPresent())
        {
            throw new PaymentException(" Invalid Booking Id ", 400);
        }

        return obj.get();
    }

    @Override
    public List<BookingInfoEntity> getAllBookings() {
        return _bookingDAO.findAll();
    }
}
