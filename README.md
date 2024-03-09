# PaymentRest
This REST API is based on the challenge available at https://github.com/PicPay/picpay-desafio-backend and its main objective is to handle payment transactions. The application is designed to support two different types of users: SHOPKEEPER, who only receives payments, and COMMON, who can both make and receive payments. A key feature of the application is the sending of confirmation emails for both payments and receipts.

The API has been developed using web development best practices. This included the use of DTO classes for data transfer between client and server, ensuring a clear and consistent structure for communication between the parties. Careful handling of server responses was also implemented to ensure a consistent, informative and secure user experience.

SOLID principles and some design patterns, such as the Decorator pattern in the TRANSACTION class, were used to keep the code organised and easy to maintain. This pattern allows new payment checks to be added without modifying other classes, following the single responsibility principle. This results in a more modular and extensible code.


## API Configuration and Execution

This guide will provide instructions on how to configure and run the API locally using Docker and Insomnia.

1. **Clone the Repository:**
   Clone your API repository to your local environment.
   https://github.com/GabrielGiacometti/PaymentRest.git

2. **Run the Docker Container:**
   Execute the newly created Docker container.

   
   docker run -p 3308:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=paymentapi -e MYSQL_USER=sa -e MYSQL_PASSWORD=1234 -d mysql:5.7

4. **Import the JSON File:**
   Open a testing tool and import the provided file, InsomniaPaymentAPI, containing all the necessary requests to test the API.
   



