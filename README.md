vaccine-inventory

clone project

download dependencies with gradlew buildDependents

create vaccination postgres database, this configuration will see at datasource application.yml tag where you can set your database connection

this project will deploy at port 8080, and you'll can data access with follow links:

http://localhost:8080/loginUser -- to login

http://localhost:8080/findAll -- to see all employees

http://localhost:8080/saveUpdateEmployee -- to save new employees, this will create a new user with dni like pass and firstname.lastname like user

http://localhost:8080/deleteEmployeeVaccine -- to delete a employee vaccine relation

http://localhost:8080/saveVaccine -- to save a new employee vaccine relation

In this version the roles and permission logic is not correctly implemented

made by Adonis Estrada

email: adonis.estrada123@gmail.com

