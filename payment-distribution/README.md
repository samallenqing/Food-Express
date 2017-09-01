## Payment Distribution

- **Payment Distribution**
  1. demo
     1. Payment.class - Id, timestamp, amount, orderId, creditCardInfo.
     2. CreditCardInfo.class - firstName, lastName, expiredMonth, expiredYear, securityCode.
  2. rest
     1. PaymentDistributionApi.class
        - Send payload by POST method.
  3. PaymentDistributionServiceApp - Spring Boot Application implement Eureka and Hystrix.
  