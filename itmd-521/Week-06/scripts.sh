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
import --connect jdbc:mysql://localhost/itmd521 -table records -m 1 --username root -P --target-dir /user/vagrant/records/
#Run the JAR file in Hadoop
 hadoop jar avgtemp.jar AvgTemperature -libjars $SQOOP_HOME/sqoop-1.4.7.jar
#
#
#Part 2
#
#Compile the Java Code
hadoop com.sun.tools.javac.Main AvgTemperatureLimit.java Record.java
#Create JAR file
jar cf avgtemp.jar *.class
#Run the Sqoop Command
import --connect jdbc:mysql://localhost/itmd521 -table records -m 1 --username root -P --target-dir /user/vagrant/records_Part2/
#Run the JAR file in Hadoop
 hadoop jar avgtemp.jar AvgTemperatureLimit -libjars $SQOOP_HOME/sqoop-1.4.7.jar