# Spring Boot + GraphQL + MySQL example

For more detail, please visit:
> [Spring Boot + GraphQL + MySQL example](https://bezkoder.com/spring-boot-graphql-mysql-jpa/)

## Run Spring Boot application
```
mvn spring-boot:run
```

## Connect to the database
```
PS C:\Users\kenwu> docker exec -it mysql-graphql-db bash
bash-4.4# mysql -uroot -p123456
mysql: [Warning] Using a password on the command line interface can be insecure.
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 8
Server version: 8.2.0 MySQL Community Server - GPL

Copyright (c) 2000, 2023, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
| testdb             |
+--------------------+
5 rows in set (0.01 sec)

mysql> use testdb;
Database changed
```

## Create Test Data
```
C:\idev\graphql\spring-boot-graphql-mysql\liquibase>liquibase --changeLogFile=dbchangelog.sql update
####################################################
##   _     _             _ _                      ##
##  | |   (_)           (_) |                     ##
##  | |    _  __ _ _   _ _| |__   __ _ ___  ___   ##
##  | |   | |/ _` | | | | | '_ \ / _` / __|/ _ \  ##
##  | |___| | (_| | |_| | | |_) | (_| \__ \  __/  ##
##  \_____/_|\__, |\__,_|_|_.__/ \__,_|___/\___|  ##
##              | |                               ##
##              |_|                               ##
##                                                ##
##  Get documentation at docs.liquibase.com       ##
##  Get certified courses at learn.liquibase.com  ##
##                                                ##
####################################################
Starting Liquibase at 20:58:17 (version 4.26.0 #1141 built at 2024-02-06 21:31+0000)
Liquibase Version: 4.26.0
Liquibase Open Source 4.26.0 by Liquibase
Running Changeset: dbchangelog.sql::001::author-inserts
Running Changeset: dbchangelog.sql::001::tutorial-inserts

UPDATE SUMMARY
Run:                          2
Previously run:               0
Filtered out:                 0
-------------------------------
Total change sets:            2

Liquibase: Update has been successful. Rows affected: 56
Liquibase command 'update' was executed successfully.
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