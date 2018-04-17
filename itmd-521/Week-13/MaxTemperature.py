from pyspark import SparkContext
import re, sys

sc = SparkContext("local", "Max Temperature")
sc.textFile(sys.argv[1]) \
  .map(lambda s: s.split("\t")) \
  .filter(lambda rec: (int(rec[0]) >= 0 and int(rec[0]) <= 10000 and rec[2] != "9999" and re.match("[01459]", rec[1]))) \
  .map(lambda rec: (int(rec[0]), int(rec[2]))) \
  .reduceByKey(max) \
  .saveAsTextFile(sys.argv[2])
