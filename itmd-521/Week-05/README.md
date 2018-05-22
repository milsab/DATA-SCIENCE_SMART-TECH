# ITMD 521 Spring 2018

### Deliverable 1

#### One Map Task:
sqoop import --connect jdbc:mysql://localhost/itmd521 --table records -m 1 --username root -P --where "temperature >= 380 and temperature <> 9999" --target-dir /HW5/8

#### Four Map Tasks:
sqoop import --connect jdbc:mysql://localhost/itmd521 --table records -m 4 --username root -P --where "temperature >= 380 and temperature <> 9999" --target-dir /HW5/9


### Deliverable 2

#### Result According to one Map task (-m 1)
![Part 2](images/part2_colored.jpg "Part 2 - The 10 last records, According to 1 map task")

#### Result According to four Map tasks (-m 4)
![Part 2](images/four_mr.jpg "Part 2 - The 10 last records, According to 4 map task")

### Additional Notes
* The Database name is itmd521.
* **ATTENTION: 13th column is temperature.**
* I used the condition "temperature >= 380" because according to the dataset description in the book the temperature is Celsius * 10 so 38 degree Celsius in the dataset is equivalent of 380 
* I used **"temperature >= 380 and temperature <> 9999"** condition to prevent the returning results which contain 9999
* When I imported data to MySql, I had not included id column in the table. So, to use more than one Map task I added one id column to records table with the following command:
** ALTER TABLE records ADD id int NOT NULL AUTO_INCREMENT primary key FIRST;
* The first screenshot is the result for one Map task (-m 1) and the second screenshot is the result for four Map tasks (-m 4)
