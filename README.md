# Spring Cloud Food Express

This is a food delivery application using Micro-services architecture and Spring Cloud.

## Operating Requirements
- **Docker** Provides docker images for application build up.
- **MongoDB** Provides application database.
- **Eureka** Micro-services registration and discovery.
- **RabbitMQ** Decouple micro-services.
- **WebSocket** Sends message to UI.
- **Hal Browser** Quick repository exploration.
- **Lombok** Fast build getter/setter and constructors implementation.
- **Hystrix** Enables automated batching of requests into a single HystrixCommand instance execution.


## Functions

- User can search a restaurant based on restaurant name.
- User can order food by choosing different menu item, quantity and add a note about his/her diet restrictions and etc.
- User can also fills in the delivery address.
- After user places an order, the order should contain food items user ordered, quantity, price and order time.
- User then needs to pay for his/her order by providing credit card number, expiration date, and security code.
- After payment is made successfully, it should return payment ID, timestamp and then the order is considered as completed so the user can see the estimated delivery time.

## Server Design
This spring cloud application is built on mic-services. In this application consists of six modules.

- **Restaurant Service**
  1. demo
     1. Menu.class - restaurantId, name, description, price, Id
     2. Restaurant.class - Id, name, address, phone number
  2. repository
     1. MenuRepository.interface
        - Get all menus by restaurant Id.
        - Get menu item by item name.
     2. RestaurantRepository.interface
        - Find restaurant by name.
  3. rest
     1. RestaurantRestApi.class
        - Create restaurant by POST method.
        - Create menu item by POST method.
        - Find restaurant by restaurant name with GET method.
        - Find menu item by item name with Get method.
        - Upload initial menu items with POST method.
  4. service
     1. MenuService.interface
        - Find all menu items by restaurant Id.
        - Create menu items.
        - Upload menu items.
     2. RestaurantService.interface
        - Create restaurant.
        - Find restaurant by name.
     3. Implements
        1. MenuServiceImpl.class
           - Find menu items by restaurant name.
           - Upload menu items.
           - Create menu item.
        2. RestaurantSerivceImpl.class
           - Create restaurant.
           - Find restaurant by name.
  5. RestaurantServiceApplication - Spring Boot Application implement Eureka.

- **Order Service**
  1. demo
     1. Order.class - Id, List of items, totalPrice, orderTime, deliveryTime, paymentId, userInfo.
     2. ItemOrdered.class - name, price, quantity.
     3. Address.class - address, city, state, zip.
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
  5. OrderServiceApplication - Spring Boot Application implement Eureka.

- **Payment Service**
  1. demo
     1. CreditCardInfo.class - firstName, lastName, expiredMonth, expiredYear, securityCode.
     2. ItemDetail.class - name, price, quantity.
     3. Order.class - Id, List of items, totalPrice, orderTime, deliveryTime, paymentId, userInfo.
     4. Payment.class - Id, timestamp, amount, orderId, creditCardInfo.
     5. UserInfo.class - Id, firstName, lastName, phone, address.
  2. repository
     1. OrderRepository.interface
        - Get order items by payment Id.
        - Create order by payment Id.
     2. PaymentRepository.interface
        - Find payment by payment Id. 
  3. rest
     1. RestaurantRestApi.class
        - Create restaurant by POST method.
        - Create menu item by POST method.
        - Find restaurant by restaurant name with GET method.
        - Find menu item by item name with Get method.
        - Upload initial menu items with POST method.
  4. service
     1. MenuService.interface
         - Find all menu items by restaurant Id.
         - Create menu items.
         - Upload menu items.
     2. RestaurantService.interface
         - Create restaurant.
         - Find restaurant by name.
     3. Implements
        1. MenuServiceImpl.class
           - Find menu items by restaurant name.
           - Upload menu items.
           - Create menu item.
        2. RestaurantSerivceImpl.class
           - Create restaurant.
           - Find restaurant by name.
  5. PaymentServiceApplication - Spring Boot Application implement Eureka.


- **Order Updater**
  1. demo
     1. ItemDetail.class - name, price, quantity.
     2. Order.class - Id, List of items, totalPrice, orderTime, deliveryTime, paymentId, userInfo.
     3. UserInfo.class - Id, firstName, lastName, phone, address.
     4. CreditCardInfo.class - firstName, lastName, expiredMonth, expiredYear, securityCode.
  2. rest
     1. OrderUpdaterRestApi.class
        - Send order by POST method.
        - Send error message if order is wrong by POST method.
     2. WebSocketRestApi.class
        - Send message.
  3. OrderUpdaterApplication - Spring Boot Application implement Eureka.
  4. WebSocketConfig.class - Stander Configuration
  5. OrderUpdaterSink.class - Enable to send message to front end.
  
- **Order Distribution**
  1. demo
     1. Payment.class - Id, timestamp, amount, orderId, creditCardInfo.
     2. Order.class - Id, List of items, totalPrice, orderTime, deliveryTime, paymentId, userInfo.
     3. UserInfo.class - Id, firstName, lastName, phone, address.
  2. rest
     1. OrderDistributionRestApi.class
        - Send payload by POST method.
  3. OrderDistributionApplication - Spring Boot Application implement Eureka.
  
- **Platform**
  1. eureka
     - EurekaApplication.class - Enable Euraka server.
  2. hystrix
     - HystrixApplicatoin.class - Enable Hystrix test.

## Maven Dependencies

**Dependency 1** - Spring Boot Web Starter
  - Building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container.

```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```

**Dependency 2** - Spring Boot Data JPA Starter
     - Using Spring Data JPA with Hibernate.
   ```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
   ```
**Dependency 3** - Lombok
  - Automatic generate getters, setters and constructors.
```
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
```
**Dependency 4** - Spring Boot Data REST Starter
  - Starter for exposing Spring Data repositories over REST using Spring Data REST.
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter--data-rest</artifactId>
        </dependency>
```

**Dependency 5** - Spring Data REST HAL Browser
  - Spring Data REST HAL Browser.
```
        <dependency>
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-rest-hal-browser</artifactId>
        </dependency>
```
**Dependency 6** - Spring boot starter data mongodb
  - Starter for using MongoDB document-oriented database and Spring Data MongoDB.
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>
```
**Dependency 7** - Json simple
     - A simple Java toolkit for JSON.
   ```
           <dependency>
               <groupId>com.goolecode.json-simple</groupId>
               <artifactId>json-simple</artifactId>
           </dependency>
   ```
**Dependency 8** - Spring cloud stream binder rabbit
  - RabbitMQ binder implementation.
```
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-stream-binder-rabbit</artifactId>
        </dependency>
```
**Dependency 9** - Spring boot starter websocket
  - Starter for building WebSocket applications using Spring Framework's WebSocket support.
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-websocket</artifactId>
        </dependency>
```

**Dependency 10** - Spring boot starter test
  - Starter for testing Spring Boot applications with libraries including JUnit, Hamcrest and Mockito.
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>
```
**Dependency 11** - Spring boot starter thymeleaf
  - Starter for building MVC web applications using Thymeleaf views.
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
```
**Dependency 12** - Spring cloud starter eureka
  - Spring Cloud Starter.
```
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka</artifactId>
        </dependency>
```
**Dependency 13** - Webjar
  - WebJar for Bootstrap.
```
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>bootstrap</artifactId>
        </dependency>
```

**Dependency 14** - Spring Cloud Starter Hystrix
  - Spring Cloud Starter Hystrix.
```
        <dependency>
           <groupId>org.springframework.cloud</groupId>
           <artifactId>spring-cloud-starter-hystrix</artifactId>
        </dependency>
```

## Authors

* **Qin Qing** - *Initial work* - [Sam Qing](https://github.com/PurpleBooth)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
