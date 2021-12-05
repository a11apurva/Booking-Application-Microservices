package com.upgrad.Booking.controller;

import com.upgrad.Booking.dto.BookingInfoDTO;
import com.upgrad.Booking.dto.PaymentDTO;
import com.upgrad.Booking.entity.BookingInfoEntity;
import com.upgrad.Booking.exceptions.PaymentException;
import com.upgrad.Booking.services.BookingService;
import com.upgrad.Booking.services.MessageService;
import com.upgrad.Booking.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/")
public class BookingController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private TransactionService transactionService ;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     *  Create a new Booking
     *
     *  POST - localhost:8080/booking
     */
    @PostMapping(value = "booking", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newBooking(@RequestBody BookingInfoDTO inputDTO){


        BookingInfoEntity bookingInfo = new BookingInfoEntity(inputDTO.getFromDate(),
                inputDTO.getToDate(),
                inputDTO.getAadharNumber(),
                inputDTO.getNumOfRooms());

        BookingInfoEntity savedBooking = bookingService.saveBooking(bookingInfo);

        BookingInfoDTO savedBookingDTO = modelMapper.map(savedBooking, BookingInfoDTO.class);

        return new ResponseEntity(savedBookingDTO, HttpStatus.OK);
    }

    /**
     *  Complete transaction
     *
     *  POST - localhost:8080/booking/{bookingId}/transaction
     */
    @PostMapping(value = "booking/{bookingId}/transaction", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity completeTransaction(@RequestBody PaymentDTO paymentDTO,
                                      @PathVariable(name="bookingId") int bookingId) throws IOException {


        if (!paymentDTO.getPaymentMode().equalsIgnoreCase("card") &&
                !paymentDTO.getPaymentMode().equalsIgnoreCase("upi"))
        {
            throw new PaymentException("Invalid mode of payment", 400);
        }

        BookingInfoEntity bookingInfo = bookingService.getBooking(bookingId);

        if(bookingInfo == null)
        {
            throw new PaymentException(" Invalid Booking Id ", 400);
        }

        int transactionNumber = transactionService.getTransactionNumber(paymentDTO);

        bookingInfo.setTransactionId(transactionNumber);
        BookingInfoEntity updatedBookingInfo = bookingService.saveBooking(bookingInfo);

        String message = "Booking confirmed for user with aadhaar number: "
                + bookingInfo.getAadharNumber()
                + "    |    "
                + "Here are the booking details:    "
                + bookingInfo.toString();

        messageService.produceMessage("message", "123AAA", message);

        BookingInfoDTO bookingInfoDTO = modelMapper.map(updatedBookingInfo, BookingInfoDTO.class);
        return new ResponseEntity(bookingInfoDTO, HttpStatus.OK);
    }

    /**
     *  Returns all the bookings
     *
     *  GET - localhost:8080/bookings
     */
    @GetMapping(value = "bookings" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fetchAllBookings(){

        List<BookingInfoEntity> bookingInfoList = bookingService.getAllBookings();
        return new ResponseEntity(bookingInfoList, HttpStatus.OK);
    }

    /**
     *  Return Booking details on ID
     *
     *  GET - localhost:8080/booking/id
     */

    @GetMapping(value= "booking/{id}")
    public ResponseEntity fetchBookingOnId(@PathVariable(name="id") int id){

        BookingInfoEntity bookingInfo = bookingService.getBooking(id);

        BookingInfoDTO bookingDTO = modelMapper.map(bookingInfo, BookingInfoDTO.class);

        return new ResponseEntity(bookingDTO, HttpStatus.OK);
    }
}
