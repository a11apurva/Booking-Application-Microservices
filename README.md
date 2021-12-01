# Booking-Application-Microservices
A microservice architecture based hotel room booking application

## High Level Architecture

The application consists of the following three microservices:
- Booking Service
- Payment Service
- Notification Service

#### Architecture Diagram - 

![Architecture Diagram](/meta/diagram-1.png)

#### Database Schema Diagram -

![DB Schema Diagram](/meta/db_schema-1.png)

## Booking Service

### API-1: Make New Booking

Endpoint -

```
POST localhost:8080/booking 
Content-Type application/json
```

Request Body Ex –

```
	{
   	 "fromDate": "2021-02-02",
   	 "toDate": "2021-02-10",
    	 "aadharNumber": "Akash Sinha-Aadhar Number",
    	 "numOfRooms": 5
	}
```

Response Body Ex -

```
	{
    	 "id": 1,
    	 "fromDate": "2010-02-02",
    	 "toDate": "2010-02-10",
    	 "bookedOn": "2021-10-20 17:21:47",
    	 "aadharNumber": "Akash Sinha-Aadhar Number",
    	 "roomNumbers": "40,61,62,59,3",
    	 "numOfRooms": 5,
    	 "roomPrice": 40000,
    	 "transactionId": 0
	}
```

### API-2: Complete transaction

Endpoint -

```
POST localhost:8080/booking/{booking-id}/transaction
Content-Type application/json
```

Request Body Ex –

```
	{
   	 "paymentMode": "CARD",
	 "bookingId": 1,
	 "upiId":"",
	 "cardNumber":"Test Card Number"
	}
```

Response Body Ex -

```
	{
    	 "id": 1,
    	 "fromDate": "2010-02-02",
    	 "toDate": "2010-02-10",
    	 "bookedOn": "2021-10-20 17:21:47",
    	 "aadharNumber": "Akash Sinha-Aadhar Number",
    	 "roomNumbers": "40,61,62,59,3",
    	 "numOfRooms": 5,
    	 "roomPrice": 40000,
    	 "transactionId": 2
	}
```

