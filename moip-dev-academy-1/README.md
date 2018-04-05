# Moip Dev Academy 07.04.2018 - Spring Boot Example
## Project: Library System :book: ##

Entity | Description
------------ | -------------
User | Librarian / SysAdmin
Book | Title / Author / ISBN
Patron | The person who borrows a book
Loan | Registers which book a patron borrowed, the librarian who lend it, when the book was borrowed, how long the patron can keep the book, and the fine amount if the book isn't returned before the due date

### User API ###
1. Create a new User using **POST** `localhost:8080/users/`
```json
{
    "name": "Breno",
    "role": "ADMIN"
}
```
2. Retrieve all Users using **GET** `localhost:8080/users/`
3. Retrieve a single User using **GET** `localhost:8080/users/{userId}`
4. Update a User using **PUT** `localhost:8080/users/{userId}`
```json
{
    "name": "Breno Oliveira",
    "role": "LIB"
}
```
5. Delete a User using **DELETE** `localhost:8080/users/{userId}`

### Book API ###
1. Create a new Book using **POST** `localhost:8080/books/`
```json
{
    "title": "Around the World in Eighty Days",
    "author": "Jules Verne",
    "isbn": "9789174999273"
}
```
2. Retrieve all Books using **GET** `localhost:8080/books/`
3. Retrieve a single Book using **GET** `localhost:8080/books/{bookId}`
4. Update a Book using **PUT** `localhost:8080/books/{bookId}`
```json
{
    "title": "Moip Dev Academy",
    "author": "Moipers",
    "isbn": "1234356786234"
}
```
5. Delete a Book using **DELETE** `localhost:8080/books/{bookId}`

### Patron API ###
1. Create a new Patron using **POST** `localhost:8080/patrons/`
```json
{
    "name": "Leticia",
    "phone": " (11) 99999-9999"
}
```
2. Retrieve all Patrons using **GET** `localhost:8080/patrons/`
3. Retrieve a single Patron using **GET** `localhost:8080/patrons/{patronId}`
4. Update a Patron using **PUT** `localhost:8080/patrons/{patronId}`
```json
{
    "name": "Leticia Alves",
    "phone": " (11) 88888-8888"
}
```
5. Delete a Patron using **DELETE** `localhost:8080/patrons/{patronId}`

### Loan API ###
1. Create a new Loan using **POST** `localhost:8080/loans/`
```json
{
    "dateBorrowed": "2018-04-07T09:00:00",
    "timeLimit": " 2",
    "fineAmount": 2.50,
    "book": {
    	"id": 1
    },
    "patron": {
    	"id": 1
    },
    "user": { 
    	"id": 1
    }
}
```
2. Retrieve all Loans using **GET** `localhost:8080/loans/`
3. Retrieve a single Loan using **GET** `localhost:8080/loans/{loanId}`
4. Update a Loan using **PUT** `localhost:8080/loans/{loanId}`
```json
{
    "dateBorrowed": "2018-04-07T09:00:00",
    "timeLimit": " 3",
    "fineAmount": 3.50,
    "book": {
    	"id": 1
    },
    "patron": {
    	"id": 1
    },
    "user": { 
    	"id": 1
    }
}
```
5. Delete a Loan using **DELETE** `localhost:8080/loans/{loanId}`
