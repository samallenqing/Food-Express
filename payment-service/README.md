
## Payment Service

Payment-service is responsible for processing payment.

- **Payment Service**
  1. demo
     1. CreditCardInfo.class - firstName, lastName, expiredMonth, expiredYear, securityCode.
     2. ItemDetail.class - name, price, quantity.
     3. Order.class - Id, List of items, totalPrice, orderTime, deliveryTime, paymentId, userInfo.
     4. Payment.class - Id, timestamp, amount, orderId, creditCardInfo.
     5. UserInfo.class - Id, firstName, lastName, phone, address.
  2. repository
     1. OrderRepository.interface
        - Find order items by payment Id.
        - Save order.
     2. PaymentRepository.interface
        - Find payment by payment Id. 
  3. rest
     1. PaymentRestApi.class
        - Create payment by POST method.
  4. service
     1. PaymentService.interface
         - Process payment.
     2. Implements
        1. PaymentServiceImpl.class
           - Process payment.
  5. PaymentServiceApplication - Spring Boot Application implement Eureka.
