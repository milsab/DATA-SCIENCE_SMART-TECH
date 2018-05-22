# ITMD 521 Spring 2018

### Deliverable 1
![Part 1](images/Part1.png "Part 1")

### Deliverable 2

#### Comparing Execution Time (One Year Data)
Here it is a graph which compares the execution times (Based on Seconds) for running the job on small data set (One Year Data Set). 
![Graph1](images/smallData/Graph_SmallData.png "Graph2")

#### Comparing Execution Time (Ten Years Data)
Here it is a graph which compares the execution times (Based on Seconds) for running the job on big data set (One Decade Data Set). 
![Graph2](images/bigData/Graph_BigData.png "Graph2")

#### Results for 1 Year Dataset (SMALL DATA)

##### Small Data - First Run
![SmallData_R1](images/smallData/one.png "SmallData_R1")
##### Small Data - Second Run
![SmallData_R2](images/smallData/two.png "SmallData_R2")
##### Small Data - Third Run
![SmallData_R3](images/smallData/three.png "SmallData_R3")
##### Small Data - With Combiner - First Run
![SmallData_CM_R1](images/smallData/combiner/one.png "SmallData_CM_R1")
##### Small Data - With Combiner - Second Run
![SmallData_CM_R2](images/smallData/combiner/two.png "SmallData_CM_R2")
##### Small Data - With Combiner - Third Run
![SmallData_CM_R3](images/smallData/combiner/three.png "SmallData_CM_R3")

#### Results for 10 Years Dataset (BIG DATA)
##### Big Data - First Run
![BigData_R1](images/bigData/one.png "BigData_R1")
##### Big Data - Second Run
![BigData_R2](images/bigData/two.png "BigData_R2")
##### Big Data - Third Run
![BigData_R3](images/bigData/three.png "BigData_R3")
##### Big Data - With Combiner - First Run
![BigData_CM_R1](images/bigData/combiner/one.png "BigData_CM_R1")
##### Big Data - With Combiner - Second Run
![BigData_CM_R2](images/bigData/combiner/two.png "BigData_CM_R2")
##### Big Data - With Combiner - Third Run
![BigData_CM_R3](images/bigData/combiner/three.png "BigData_CM_R3")




### Deliverable 3
According to the above results, obviously it indicates that running the job with Combiner can reduce the execution time significantly. The reason is that Combiner behaves as a local reducer, so according to **page 198 in chapter 7 of the textbook (PDF Version)**, "Running the combiner function makes for a more compact map output, so there is less data to write to local disk and to transfer to the reducer." So, it can decrease the execution time in Map side.
On the other hand, in the reduce side, "if a combiner is specified, it will be run during the merge to reduce the amount of data written to disk." **(Page 199, PDF Version)**. So, it can reduce the reduce execution time.
As a result, using combiner, can reduce the job execution time significantly, specially when the data set is vary large.

## Additional Notes

* In graphs, the the vertical axis unit is seconds.
* Here there are three results for each job (Small Data without combiner, Small Data with combiner, Big Data without combiner, Big Data with Combiner)
* There are a little bit difference in results of each run for a single job. When the number of jobs which were running at a same time was more than 10 usually it took more time to complete the job.



## Setup Remote Hadoop Cluster Notes

Copy all *.xml and .sh files into your ```~/hadoop-2.6.5/etc/hadoop``` directory overwritting the defaults 

Copy the hosts file content into your ```/etc/hosts file``` -- note ```/etc/hosts``` is owned by root so you need to use ```sudo```
