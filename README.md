# ExpenseTrackerApi
A simple Expense tracker REST API

![ScreenRecording2024-03-10at12 24 01PM-ezgif com-video-to-gif-converter](https://github.com/kanchan78/ExpenseTracker/assets/65346420/d1ccd485-3510-468f-a54c-27ef70057dad)


## About the API

An API for expense management. This project is built with Java, Spring Boot. 
The API main URL `/expenses`.

## Features

This API provides HTTP endpoint's and tools for the following:

* Create an expense: `POST/expenses`
* Update an expense: `PUT/expenses/{id}`
* Delete an expense (by id): `DELETE/expenses/{id}`
* Find a unique expense by id: `GET/expenses/{id}`
* Get all expenses: `GET/expenses`
* Filter expense
   * By Name : `GET/expenses/name?name={name}`
   * By Category : `GET/expenses/category?category={category}`
   * By Date : `GET/expenses/date?startDate={startDate}&endDate={endDate}`
* Pagination and Sorting


<a href="https://documenter.getpostman.com/view/4110434/2sA2xh3DME">Expense Tracker API Documentation</a>

### Technologies used

This project was developed with:

* Java 17
* Spring Boot 3.2.2
* Maven
* Mysql

### Compile and Package

The API also was developed to run with an `jar`. In order to generate this `jar`, you should run:

```bash
mvn package
```

This command will clean, compile and generate a `jar` at target directory, e.g. `expensetrackerapi-0.0.1-SNAPSHOT.jar`

### Execution

This project uses **Mysql database**.
* Create databse`Create database expensetracker`.
* Run Spring boot app it will automatically create table

### Run

In order to run the API, run the jar as following:

```bash
java -jar expensetrackerapi-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
```
    
or

````
To test the application import `src/main/resources/templates/Expense Manager - REST API CRUD.postman_collection.json`  file on Postman App
````
<!--- insomnia_collection.json
### Details

`POST/products`

This end-point is called to add a new Product.

**Body:**

```json
{
  "name": "Product name",
  "description": "Product description",
  "price": 99.5
}
```

**Where:**

`name` - product name (required)

`description` - product description (required)

`price` – product price(parsable as a BigDecimal (required)


**Return:** Returns all info about the added product including the generated id:

```json
{
  "id": "2018795b-3537-4ddc-a22f-69e90116c6c4",
  "name": "Product name",
  "description": "Product description",
  "price": 99.5
}
```

* 201 - Created: Everything worked as expected.
* 400 - Bad Request: the request was unacceptable. Reason: missing a required parameter.
* 500- Server Error: something went wrong on API.

`PUT/products/{id}`

This end-point is called to update a existing Product.

**Path param:**

`id` - product id to update (required)


**Body:**

```json
{
  "name": "Product name",
  "description": "Product description",
  "price": 99.5
}
```

**Where:**

`name` - product name (required)

`description` - product description (required)

`price` – product price(parsable as a BigDecimal (required)


**Return:** Returns all info about the updated product including the generated id:

```json
{
  "id": "2018795b-3537-4ddc-a22f-69e90116c6c4",
  "name": "Product name",
  "description": "Product description",
  "price": 99.5
}
```

* 200 - OK: Everything worked as expected.
* 400 - Bad Request: the request was unacceptable. Reason: missing a required parameter.
* 404 - Not Found: The product with path param id not exists.
* 500- Server Error: something went wrong on API.

`DELETE/products/{id}`

This end-point is called to delete a existing Product.

**Path param:**

`id` - product id to delete (required)


**Return:** Returns the http status code to operation:

* 200 - OK: Everything worked as expected.
* 404 - Not Found: The product with path param id not exists.
* 500- Server Error: something went wrong on API.

`GET/products/{id}`

This end-point is called to find a unique product Product.

**Path param:**

`id` - product id to find (required)


**Return:** Returns all about the product:

```json
{
  "id": "2018795b-3537-4ddc-a22f-69e90116c6c4",
  "name": "Product name",
  "description": "Product description",
  "price": 99.5
}
```

* 200 - OK: Everything worked as expected.
* 400 - Bad Request: the request was unacceptable. Reason: missing a required parameter.
* 404 - Not Found: The product with path param id not exists.
* 500- Server Error: something went wrong on API.


`GET/products`

This end-point is called to find all Products.

**Return:** Returns the list of products:

```json
[
	{
	  "id": "2018795b-3537-4ddc-a22f-69e90116c6c4",
	  "name": "Product name",
	  "description": "Product description",
	  "price": 99.5
	},
	{
	  "id": "2018795b-3537-4ddc-a22f-69e901163364",
	  "name": "Product name 2",
	  "description": "Product description 2",
	  "price": 10.5
	},
]
```

* 200 - OK: Everything worked as expected.
* 500- Server Error: something went wrong on API.

`GET/products/search?q={expression}&min_price={min_price}&max_price={max_price}`

This end-point is called to find products by some cryteria.

**Query params:**

`q` - product name or description

`min_price` - Minimum product price

`max_price` - Maximum product price


**Return:** Returns the list of products:

```json
[
	{
	  "id": "2018795b-3537-4ddc-a22f-69e90116c6c4",
	  "name": "Product name",
	  "description": "Product description",
	  "price": 99.5
	},
	{
	  "id": "2018795b-3537-4ddc-a22f-69e901163364",
	  "name": "Product name 2",
	  "description": "Product description 2",
	  "price": 10.5
	},
]
```

* 200 - OK: Everything worked as expected.
* 500- Server Error: something went wrong on API.


### Technologies used

This project was developed with:

* Java 8
* Spring Boot 2.5.2
* Maven
* Log4j2
* JUnit 5
* H2
* Swagger 3.0.0
* Model Mapper 2.3.9

### Compile and Package

The API also was developed to run with an `jar`. In order to generate this `jar`, you should run:

```bash
mvn package
```

This command will clean, compile and generate a `jar` at target directory, e.g. `products-java-api-1.0.0-SNAPSHOT.jar`

### Execution

This project uses **H2 database**. This database run in memory!. 
On run the project automatically will create a database, table and populate with 5 products!.

### Test

* For unit test phase, you can run:

```bash
mvn test
```

### Run

In order to run the API, run the jar as following:

```bash
java -jar products-java-api-1.0.0-SNAPSHOT.jar --spring.profiles.active=dev
```
    
or

```bash
mvn spring-boot:run -Dspring.profiles.active=dev
```

By default, the API will be available at [http://localhost:9999](http://localhost:9999)

### Documentation

* Swagger (development environment): [http://localhost:9999/swagger-ui/index.html](http://localhost:9999/swagger-ui/index.html)
 --->
