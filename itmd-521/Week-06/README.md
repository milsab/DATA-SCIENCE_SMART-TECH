# ITMD 521 Spring 2018

### Deliverable 1
![Part 1](images/part1.jpg "Part 1 - Average Temperature for 1985")


### Deliverable 2
![Part 2](images/part2.jpg "Part 2 - Average Temperature for 1985 with where conditions")

### Notes
* Dataset comes from **1985**.txt
* The database name is itmd521
* The Database has an **ID** column which is AUTO-INCREMENT. Also, the temperature data type is Integer
* The results is the average temperature based on *Celsius degree * 10*
* In the Mapper I implemented the code that prepare and filter the data and in the Reducer I implemented the code to do the actual business logic (Calculate Average Temperature)
* For Part 0ne and Part Two I used two different files each file contains Mapper, Reducer, and Job: 
	1. AvgTemperature.java** contains the Mapper and Reducer, and Job to produce the result for part 1
    2. AvgTemperatureLimit.java** contains the Mapper and Reducer, and Job to produce the result for part 2
* **ATTENTION:** I did __**all data filtration and business logics (Average Calculation) in the JAVA codes according to MapReduce rules**__. In this process, I used some cast operations to convert data to appropriate type. Considering to this point in PART 1 is important that if for each casting operation there is a super small error the final result probably has some margin error to the actual answer because we have more than 30 millions of records.

