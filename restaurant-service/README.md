## Restaurant Service

This service is used for creating restaurant object, uploading menus.

## Server Design

- **Restaurant Service**
  1. model
     1. MenuItem.class - restaurantId, name, description, price, Id
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
