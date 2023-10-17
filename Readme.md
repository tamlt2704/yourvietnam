postgresql 
```
docker run --name yourvn-postgres -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 -d postgres

check if there is a application is running on port 5432
    netstat -tln
    
attach to container
    docker exec -it yourvn-postgres bash

List all users    
    postgres=# \du
                             List of roles
     Role name |                         Attributes                         
    -----------+------------------------------------------------------------
     postgres  | Superuser, Create role, Create DB, Replication, Bypass RLS
     
list all db
    postgres=# \l
                                                      List of databases
       Name    |  Owner   | Encoding | Locale Provider |  Collate   |   Ctype    | ICU Locale | ICU Rules |   Access privileges   
    -----------+----------+----------+-----------------+------------+------------+------------+-----------+-----------------------
     postgres  | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           | 
     template0 | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           | =c/postgres          +
               |          |          |                 |            |            |            |           | postgres=CTc/postgres
     template1 | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           | =c/postgres          +
               |          |          |                 |            |            |            |           | postgres=CTc/postgres
    (3 rows)



postgres admin
    docker pull dpage/pgadmin4
    docker run -p 80:80 \
    -e 'PGADMIN_DEFAULT_EMAIL=user@domain.com' \
    -e 'PGADMIN_DEFAULT_PASSWORD=SuperSecret' \
    -d dpage/pgadmin4
```