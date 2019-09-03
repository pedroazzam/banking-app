# Java Developer Coding Task

Backend and REST API for a simple Banking Application

## Getting Started

To get access to client methods, first you need to SignUp/LogIn.
To SignUp/LogIn, you can do it with:
* Postman or similar
* Swagger -> It's implanted in this system (http://localhost:8080/swagger-ui.html)
* Or our internal UI at API CONNECT(http://localhost:8080/api)


### Methods - How to [POST] and [GET]

- Register a new client [POST] »» /api/signup
<br>Post model:

```
{
  "fullName": "string",
  "email": "string",
  "password": "string"
}
```
<br/><br/>

- Client initiate session [POST] »» /api/login
<br>Post model:

```
{
  "email": "string",
  "password": "string"
}
```
<br/>

- Client ends session [POST] »» /api/logout
<br/><br/>
<br/><br/>
- Return client's profile [GET] »» /api/myprofile
<br/><br/>
<br/><br/>
- Return all clients in system [ONLY ALLOWED PASSING THE SECRET KEY AS PARAMETER]-> [GET] »» /api/client/all/{secretKey}
<br/><span style="color:red">secretKey by example on system = 3861</span>
<br/><br/>
<br/><br/>
- Return all accounts in system [ONLY ALLOWED PASSING THE SECRET KEY AS PARAMETER]-> [GET] »» /api/account/all/{secretKey}
<br/><span style="color:red">secretKey by example on system = 3861</span>
<br/><br/>
<br/><br/>
- Return client's account balance [GET] »» /api/account/myaccount
<br/><br/>
<br/><br/>
- Register deposit transaction on client's account [POST] »» /api/account/myaccount/deposit
<br>Post model:

```
{
  "value": "0",
}
```
<br/><br/>

- Register withdrawal transaction on client's account [POST] »» /api/account/myaccount/withdrawal
<br>Post model:

```
{
  "value": "0",
}
```
<br/><br/>

- Return client account statment [GET] »» /api/account/myaccount/statement
<br/><br/>





## Technology stack
* Java 8
* Spring Boot
* PostgreSQL
* Maven
* Swagger


## Author

* **Pedro Azzam** - *Web* - [pedroazzam.me](https://pedroazzam.me)


