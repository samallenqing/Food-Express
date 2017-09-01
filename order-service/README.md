## Order Service

Order service is responsible for creating, updating and searching order.

**Order Service**
  1. demo
     1. Order.class - Id, List of items, totalPrice, orderTime, deliveryTime, paymentId, userInfo.
     2. ItemQuantity.class - name, price, quantity.
     3. AddressInfo.class - address, city, state, zip.
     4. UserInfo.class - Id, firstName, lastName, phone, address.
  2. repository
     1. OrderRepository.interface
        - Get order items by user Id.
        - Delete order by user Id.
        - Create order by user Id.
  3. rest
      1. OrderRestApi.class
         - Create order by POST method.
  4. service
      1. OrderService.interface
         - Create order.
      2. Implements
         1. OrderServiceImpl.class
            - Set order time.
            - Set total price.
  5. OrderServiceApplication - Spring Boot Application.
