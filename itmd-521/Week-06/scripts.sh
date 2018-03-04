#Milad Sabouri
#HW-06
#
#
#Scripts for Part 1
#
#Compile the Java Code
hadoop com.sun.tools.javac.Main AvgTemperature.java Record.java
#Create JAR file
jar cf avgtemp.jar *.class
#Run the Sqoop Command
sqoop import --connect jdbc:mysql://localhost/itmd521 -table records -m 1 --username root -P --target-dir /user/vagrant/records/
#Run the JAR file in Hadoop
 hadoop jar avgtemp.jar AvgTemperature -libjars $SQOOP_HOME/sqoop-1.4.7.jar
#
#
#Part 2
#
#Compile the Java Code
hadoop com.sun.tools.javac.Main AvgTemp_part2.java Record.java
#Create JAR file
jar cf avgtemp.jar *.class
#Run the Sqoop Command
sqoop import --connect jdbc:mysql://localhost/itmd521 -table records -m 1 --username root -P --target-dir /user/vagrant/records_part2/
#Run the JAR file in Hadoop
 hadoop jar avgtemp.jar AvgTemp_part2 -libjars $SQOOP_HOME/sqoop-1.4.7.jar