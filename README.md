# Spring Boot + GraphQL + Postgres example

It is a Postgres database version of _spring-boot-graphql-mysql_ (https://github.com/GitToMyRepo/spring-boot-graphql-mysql).

## Run Spring Boot application
```
mvn spring-boot:run
```

## Create _user-db_ database (if needed)
```
PS C:\Users\kenwu> docker run --name spring-test-postgres-container -e POSTGRES_PASSWORD=mysecretpassword -e POSTGRES_DB=user-db -p 5432:5432 -d postgres
570b83843cbc57dacece1a50b8e0af086edbc8a2b7ac246f418b1e579d532f70
```

## Connect to the database
```
PS C:\Users\kenwu> docker exec -it spring-test-postgres-container psql -U postgres
psql (16.2 (Debian 16.2-1.pgdg120+2))
Type "help" for help.
```
## Show all databases:
```
user-db=# \l
                                                      List of databases
   Name    |  Owner   | Encoding | Locale Provider |  Collate   |   Ctype    | ICU Locale | ICU Rules |   Access privileges
-----------+----------+----------+-----------------+------------+------------+------------+-----------+-----------------------
 postgres  | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           |
 template0 | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           | =c/postgres          +
           |          |          |                 |            |            |            |           | postgres=CTc/postgres
 template1 | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           | =c/postgres          +
           |          |          |                 |            |            |            |           | postgres=CTc/postgres
 user-db   | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           |
(4 rows)
```

## Use _user-db_ database
```
postgres=# \c user-db
You are now connected to database "user-db" as user "postgres".
user-db=# \dt
                 List of relations
 Schema |         Name          | Type  |  Owner
--------+-----------------------+-------+----------
 public | author                | table | postgres
 public | databasechangelog     | table | postgres
 public | databasechangeloglock | table | postgres
 public | tutorial              | table | postgres
(4 rows)

user-db=# select current_database();
 current_database
------------------
 user-db
(1 row)
```

## Create Test Data
```
mvn clean install
```

## Calling GraphQL endpoint from Postman

1. Endpoint
```
http://localhost:8080/apis/graphql
```
2. GraphQL Query
```
query {
  findAllTutorials {
    id
    title
    description
    author {
      id
      name
      age
    }
  }
}
```

3. Response
```
{
    "data": {
        "findAllTutorials": [
            {
                "id": "1",
                "title": "1984",
                "description": "Dystopian novel",
                "author": {
                    "id": "1",
                    "name": "George Orwell",
                    "age": 51
                }
            },
            {
                "id": "2",
                "title": "Harry Potter",
                "description": "Fantasy novel",
                "author": {
                    "id": "2",
                    "name": "J. K. Rowling",
                    "age": 63
                }
            },
            {
                "id": "3",
                "title": "Ulysses",
                "description": "Modernist novel",
                "author": {
                    "id": "3",
                    "name": "James Joyce",
                    "age": 28
                }
            },
            {
                "id": "4",
                "title": "Mrs Dalloway",
                "description": "Modernist novel",
                "author": {
                    "id": "4",
                    "name": "Virginia Woolf",
                    "age": 36
                }
            },
            {
                "id": "5",
                "title": "Great Expectations",
                "description": "Victorian novel",
                "author": {
                    "id": "5",
                    "name": "Charles Dickens",
                    "age": 31
                }
            },
            {
                "id": "6",
                "title": "The Catcher in the Rye",
                "description": "Novel",
                "author": {
                    "id": "6",
                    "name": "J. D. Salinger",
                    "age": 72
                }
            },
            {
                "id": "7",
                "title": "Hamlet",
                "description": "Tragedy",
                "author": {
                    "id": "7",
                    "name": "William Shakespeare",
                    "age": 91
                }
            },
            {
                "id": "8",
                "title": "Animal Farm",
                "description": "Political satire",
                "author": {
                    "id": "1",
                    "name": "George Orwell",
                    "age": 51
                }
            },
            {
                "id": "9",
                "title": "The Casual Vacancy",
                "description": "Novel",
                "author": {
                    "id": "2",
                    "name": "J. K. Rowling",
                    "age": 63
                }
            },
            {
                "id": "10",
                "title": "A Portrait of the Artist as a Young Man",
                "description": "Novel",
                "author": {
                    "id": "3",
                    "name": "James Joyce",
                    "age": 28
                }
            },
            {
                "id": "11",
                "title": "To the Lighthouse",
                "description": "Novel",
                "author": {
                    "id": "4",
                    "name": "Virginia Woolf",
                    "age": 36
                }
            },
            {
                "id": "12",
                "title": "A Tale of Two Cities",
                "description": "Historical novel",
                "author": {
                    "id": "5",
                    "name": "Charles Dickens",
                    "age": 31
                }
            },
            {
                "id": "13",
                "title": "Franny and Zooey",
                "description": "Novel",
                "author": {
                    "id": "6",
                    "name": "J. D. Salinger",
                    "age": 72
                }
            },
            {
                "id": "14",
                "title": "Macbeth",
                "description": "Tragedy",
                "author": {
                    "id": "7",
                    "name": "William Shakespeare",
                    "age": 91
                }
            },
            {
                "id": "15",
                "title": "Coming Up for Air",
                "description": "Novel",
                "author": {
                    "id": "1",
                    "name": "George Orwell",
                    "age": 51
                }
            },
            {
                "id": "16",
                "title": "The Silkworm",
                "description": "Novel",
                "author": {
                    "id": "2",
                    "name": "J. K. Rowling",
                    "age": 63
                }
            },
            {
                "id": "17",
                "title": "Dubliners",
                "description": "Short stories",
                "author": {
                    "id": "3",
                    "name": "James Joyce",
                    "age": 28
                }
            },
            {
                "id": "18",
                "title": "Orlando",
                "description": "Novel",
                "author": {
                    "id": "4",
                    "name": "Virginia Woolf",
                    "age": 36
                }
            },
            {
                "id": "19",
                "title": "Oliver Twist",
                "description": "Novel",
                "author": {
                    "id": "5",
                    "name": "Charles Dickens",
                    "age": 31
                }
            },
            {
                "id": "20",
                "title": "Nine Stories",
                "description": "Short stories",
                "author": {
                    "id": "6",
                    "name": "J. D. Salinger",
                    "age": 72
                }
            }
        ]
    }
}
```

More Practice:
> [Spring Boot and Swagger 3 example](https://www.bezkoder.com/spring-boot-swagger-3/)

> [Spring Boot Redis Cache example](https://www.bezkoder.com/spring-boot-redis-cache-example/)

> [Spring Boot File upload example](https://www.bezkoder.com/spring-boot-file-upload/)

> [Exception handling: @RestControllerAdvice example in Spring Boot](https://www.bezkoder.com/spring-boot-restcontrolleradvice/)

> [Spring Boot Repository Unit Test with @DataJpaTest](https://www.bezkoder.com/spring-boot-unit-test-jpa-repo-datajpatest/)

> [Spring Boot Rest Controller Unit Test with @WebMvcTest](https://www.bezkoder.com/spring-boot-webmvctest/)

> [Spring Boot Security & JWT Authentication (MySQL)](https://www.bezkoder.com/spring-boot-jwt-authentication/)

> [Spring Boot + GraphQL + MySQL example](https://www.bezkoder.com/spring-boot-graphql-mysql-jpa/)

> [Spring Boot Rest XML example – Web service with XML Response](https://www.bezkoder.com/spring-boot-rest-xml/)

> [Spring Boot: Upload CSV file data into MySQL Database](https://www.bezkoder.com/spring-boot-upload-csv-file/)

> [Spring Boot: Upload Excel file data into MySQL Database](https://www.bezkoder.com/spring-boot-upload-excel-file-database/)