# ExpenseTrackerApi
A simple Expense tracker REST API

https://github.com/kanchan78/ExpenseTracker/assets/65346420/8f85959c-068e-470e-a0bc-87dca8b0784f

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
### Further Improvements:

1. Adding security using spring security
2. User specific expenses
   
* Made with ❤ 
* Don't forget to star it 🌟
