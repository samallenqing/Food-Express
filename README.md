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

# Ready to Begin?

## Step 1 - Create a directory folder and download files from github

Use the following cmd in terminal to create the requests files. Here use examples "test".
```
mkdir test
cd test
git clone https://github.com/samallenqing/Food-Express.git

```

## Step 2 - Create fat jar

Use the terminal before to enter the following cmd.

```
cd Spring-Cloud-Food-Express
mvn clean install
```

## Step 3 - Use Docker to build images

Use the terminal before to enter the following cmd.

```
 docker-compose up
```
## Step 4 - Running Infrastructure Servers

Run the following codes. Each line in a new terminal.
```
sh ./start-eureka.sh
sh ./hystrix.sh
```
Wait couple seconds, then we have already started Eureka and Hystrix.

## Step 5 - Start Mic-services

Run the following codes. Each line in a new terminal.
```
sh ./restaurant-service.sh
sh ./order-service.sh
sh ./payment-distribution.sh
sh ./payment-service.sh
sh ./order-complete-updater.sh
```
Wait couple seconds, then we have already started all the mic-services we need.

### Step 6 - Open Browser
Open any browser and paste the following codes. Each line in a new tab.
```
http://localhost:7979
http://localhost:15672
http://localhost:8761
http://localhost:8001/browser/index.html
```
- First URL is for Hystrix.
- Second URL is for MongoDB.
- Third URL is for Eureka.
- Fourth URL is HAL Browser. 8001 could be changed to any service port at any time.

In the Hystrix tab, copy and paste the following URL into the search bar. We start to monitor payment service.
```
http://localhost:8004/hystrix.stream
```

### Step 7 - Upload data & Perform test

Open Postman, copy and paste to send those following test cases.

| URL |  Http Method     | File Name     |
| :------------- | :------------- | :------------- | 
| localhost:8001/api/restaurants/bulk/menuItems       | POST       | Menus.json    | 
| localhost:8002/api/restaurants/1/orders      | POST       | OrderTestCase.json  |
| localhost:8003/api/payments       | POST       | PaymentTestCase.json      |

The first POST, we just upload some restaurants and menus information.

The second POST, we simulate an order has been made. You will see the bottom part of Postman has feedback, which include total price etc.

The third POST, we simulate an payment has been submitted. You can see the data steaming in MonggoDB in 'Queues" tab under payments section. The incoming transaction is sent from payment-service and has been consumed by order-complete-updater.
  
Meanwhile, you can check Hystrix window, the data flowing.

All those POSTs methods are repeatable, you can send as many times as you want. 

### Step 8 - Finally but not Least

In the order-complete-update terminal, we shut down this service by pressing Ctrl + C. Send some payments again, meanwhile, take a look at Hystrix window, you will notice the error rate goes to 100%. And the circuit status is open.


## Authors

* **Qin Qing** - *Initial work* - [Sam Qing](https://github.com/samallenqing)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
