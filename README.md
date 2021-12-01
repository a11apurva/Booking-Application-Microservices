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


## Payment Service

### API-3: Save Transaction and return transactionId

Endpoint -

```
POST localhost:8083/transaction
Content-Type application/json
```

Request Body Ex –

```
	{
   	 "paymentMode": "CARD",
	 "bookingId": 1,
	 "upiId":"",
	 "cardNumber":"Test Card 2"
	}
```

Response Body Ex -

```
	{
   	 "transactionId": 2,
	}
```

### API-4: Fetch details of a transaction

Endpoint -

```
GET localhost:8083/transaction/2
```

Response Body Ex -

```
	{
   	 "transactionId": 2,
    	 "bookingId": 1,
    	 "paymentMode": "CARD",
    	 "upiId": null,
    	 "cardNumber": "Test Card Number"
	}
```

## Notification Service

Notification service is also made as a simple spring boot application. The main method sets the Kafka properties and subscribes to the topic "message". It starts consuming messages in a forever loop for notification service using Kafka and prints it on the console.
Kafka server and zookeeper runs on an AWS EC2 instance.

Please set the EC2 connection endpoint under property "bootstrap.servers" for the notifications to be fetched.

Ex. from console - 

![DB Schema Diagram](/meta/notification.png)
