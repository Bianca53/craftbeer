#MySQL Database script:

```
CREATE DATABASE beermanagement;
```

```
use beermanagement;
```

```
CREATE TABLE beer (
id INT  AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) NOT NULL,
ingredients VARCHAR(100) NOT NULL,
alcohol_content VARCHAR(30) NOT NULL,
price double NOT NULL,
category VARCHAR(30) NOT NULL
);
```

```
INSERT INTO beer (name, ingredients, alcohol_content, price, category)
VALUES ("Verace", "barley,yeast,hops,water", "5% alcohol", 5.50, "Pale Ale");
```

```
Note: Don't forget to update the application.yml with database informations as user and password 
```
-------------------------------------------------------------------------------------
#POSTMAN collection 

POST request:

```
http://localhost:8080/beers
```

```
Body example 
{
    "name": "Verace",
    "ingredients": "barley,yeast,hops,water",
    "alcoholContent": "5% alcohol",
    "price": 5.50,
    "category": "Pale Ale"
}
```

GET requests:

```
http://localhost:8080/beers

http://localhost:8080/beers/{id}
```

PUT request

```
http://localhost:8080/beers/{id]
```

```
Body example 
{
    "name": "San Martin",
    "ingredients": "barley,yeast,hops,water",
    "alcoholContent": "5% alcohol",
    "price": 10.90,
    "category": "Pale Ale"
}
```

PATCH request

```
http://localhost:8080/beers/{id]
```
```
Body example 
{
    "name": "Backer",
    "ingredients": "barley,yeast,hops,water",
    "alcoholContent": "5% alcohol",
    "price": 8.50,
    "category": "Pale Ale"
}
```

DELETE request

```
http://localhost:8080/beers/{id]
```
--------------------------------------------------------------------------
#Swagger link
```
http://localhost:8080/swagger-ui.html

```

