# ITMD 521 Spring 2018

### Deliverable 1

![Part 1](images/1.jpg "Part 1 - Hadoop Processing")

### Devliverable 2

![Part 2](images/2.jpg "Part 2 - Python/Java/MySQL Processing")

### Additional Notes
#### MySQL Notes
* **ATTENTION:** the *Table Name* in MySQL is "**itmd521**" because MySql didn't allow me to create a table with the name of 521
* To create the table I used **int** for **Temperature** and varchar for other columns
* GenerateDataBase.sql file includes the scripts which I used to create the database
#### Python Notes
* I parsed the data and inserted them into MySQL using **Python3** and **mysql.connector**. 
* To install mysql.connector I used "**sudo apt-get install python3-mysql.connector**"  

#### Java Notes
* I used **JDBC driver** to connect to MySQL (Class: com.mysql.jdbc.Driver -- File: mysql-connector-java-5.1.45-bin.jar)
* I use **useSSL=false** property to bypass ssl connection to MySQL
* The codes of https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-examples.html helped me to write the codes.

