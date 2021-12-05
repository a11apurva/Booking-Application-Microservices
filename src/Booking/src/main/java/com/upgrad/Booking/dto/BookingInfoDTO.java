package com.upgrad.Booking.dto;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class BookingInfoDTO {

    private int id;
    private String fromDate;
    private String toDate;
    private String bookedOn;
    private String aadharNumber;
    private String roomNumbers;
    private int numOfRooms;
    private int roomPrice;
    private int transactionId;

    public BookingInfoDTO(int id, String fromDate, String toDate, String aadharNumber, int numOfRooms) {

        this.id = id;

        this.fromDate = fromDate;
        this.toDate = toDate;
        this.aadharNumber = aadharNumber;
        this.numOfRooms = numOfRooms;

        this.bookedOn = "2021-07-01";
        this.transactionId = 0;
        this.roomPrice = getTotalRoomPrice(numOfRooms, fromDate, toDate);
        this.roomNumbers = getRandomRoomNumbers(numOfRooms);
    }

    public BookingInfoDTO(){}

    public static int  getTotalRoomPrice(int numOfRooms, String fromDate, String toDate){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate from = LocalDate.parse(fromDate,formatter);
        LocalDate to = LocalDate.parse(toDate,formatter);

        Period period = Period.between(from, to);
        int numDays = period.getDays();

        return 1000 * numDays * numOfRooms;
    }

    public static String getRandomRoomNumbers(int count){
        Random rand = new Random();
        int upperBound = 100;
        ArrayList<String> numberList = new ArrayList<String>();

        for (int i=0; i<count; i++){
            numberList.add(String.valueOf(rand.nextInt(upperBound)));
        }

        return String.join(",", numberList);
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "id=" + id +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", bookedOn='" + bookedOn + '\'' +
                ", aadharNumber='" + aadharNumber + '\'' +
                ", roomNumbers='" + roomNumbers + '\'' +
                ", numOfRooms=" + numOfRooms +
                ", roomPrice=" + roomPrice +
                ", transactionId=" + transactionId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingInfoDTO that = (BookingInfoDTO) o;
        return id == that.id && numOfRooms == that.numOfRooms && roomPrice == that.roomPrice && transactionId == that.transactionId && Objects.equals(fromDate, that.fromDate) && Objects.equals(toDate, that.toDate) && Objects.equals(bookedOn, that.bookedOn) && Objects.equals(aadharNumber, that.aadharNumber) && Objects.equals(roomNumbers, that.roomNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromDate, toDate, bookedOn, aadharNumber, roomNumbers, numOfRooms, roomPrice, transactionId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getBookedOn() {
        return bookedOn;
    }

    public void setBookedOn(String bookedOn) {
        this.bookedOn = bookedOn;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(String roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }


}
