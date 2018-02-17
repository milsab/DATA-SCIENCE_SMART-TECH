# ITMD 521 Spring 2018

## Week 5 assignment

### Part I

In chapter 15 (up to page 390 in the ePub edition -- stop at the heading **Text and Binary Formats**)  You are to install Sqoop binary on your local Hadoop Cluster (Vagrant Box).  You are to use the  WHERE clause on page 393 (epub) to execute an import from your mysql to hadoop for all records that have temperatures >= 38.0 Celcius  

### Part II 

Upon succesful completion of this operation, use the ```hadoop fs -tail <file>``` command to display the last 10 records of the file (see page 388 epub ) or right before the heading **Text and Binary Formats**.  Place screen shot in the space allocated below.

### Deliverable Instructions

 [Clone my repo](https://github.com/illinoistech-itm/jhajek.git) and use this file as your template.   Add the required photo deliverables to the document as noted and submit your github URL to blackboard.

Include a the command you used to generate the output in a file named: ```sqoop.sh```  

### Deliverable 1

vagrant@itmd521:/$ sqoop import --connect jdbc:mysql://localhost/itmd521 --table records -m 1 --username root -P --where "temperature >= 380 and temperature <> 9999" --target-dir /HW5/5

### Deliverable 2

![Part 2](images/part2.jpg "Part 2 - The 10 last records")

### Additional Notes
* The Database name is itmd521.
* 12th column is temperature. 