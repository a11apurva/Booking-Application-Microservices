package com.upgrad.Booking.services;

import com.upgrad.Booking.entity.BookingInfoEntity;

import java.util.List;

public interface BookingService {
    public BookingInfoEntity saveBooking(BookingInfoEntity booking);

    public BookingInfoEntity getBooking(int id);

    public List<BookingInfoEntity> getAllBookings();
}
