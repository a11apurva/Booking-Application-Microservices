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

Notification service is also made as a simple spring boot application. The main method sets the Kafka properties and subscribes to the topic "message". It starts consuming messages in a forever loop for notification service using Kafka and prints it on the console. Kafka server and zookeeper runs on an AWS EC2 instance. This is a small sample to show that the notification is being pushed succesfully by the Booking Service to Kafka.

Please set the EC2 connection endpoint under property "bootstrap.servers" for the notifications to be fetched.

Ex. from console - 

![notification](/meta/notification.png)

## Eureka Server

Eureka Server is an application that holds the information about all client-service applications. It knows all the client applications running on each port and IP address. Eureka Server is also known as Discovery Server.

The Booking and Payment services registers themselves into the Eureka server.

The Eureka Server is started on port 8761. On the browser if we go to http://localhost:8761/ we can see the Booking and Payment services are up –

![Eureka](/meta/eureka-log.png)


# Logic Flow

### Making a new booking -


<a href=""><img src="/meta/flowchart-1.png" alt="flow-1" width="400" border="10" /></a>


### Completing a transaction to confirm booking -

<a href=""><img src="/meta/flowchart-2.png" alt="flow-2" width="400" border="10" /></a>

# Future Enhancements

1.  Add error and exception handling at all the possible points
2.  Package all the services together
3.  Provide single start-up script to bring up all the services
4.  Implement API gateway and load balancer



