import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

public class MaxTemperatureSpark {
  
  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage: MaxTemperatureSpark <input path> <output path>");
      System.exit(-1);
    }

    SparkConf conf = new SparkConf();
    JavaSparkContext sc = new JavaSparkContext("local", "MaxTemperatureSpark", conf);
    JavaRDD<String> lines = sc.textFile(args[0]);
    JavaRDD<String[]> records = lines.map(new Function<String, String[]>() {
      @Override public String[] call(String s) {
        return s.split("\t");
      }
    });
    JavaRDD<String[]> filtered = records.filter(new Function<String[], Boolean>() {
      @Override public Boolean call(String[] rec) {
        if(rec[0] < 10000) rec[0] = 0;
        if(rec[0] < 20000) rec[0] = 10;
        return rec[1] != "9999" && rec[2].matches("[01459]");
      }
    });
    JavaPairRDD<Integer, Integer> tuples = filtered.mapToPair(
      new PairFunction<String[], Integer, Integer>() {
        @Override public Tuple2<Integer, Integer> call(String[] rec) {
          if(Integer.parseInt(rec[0]) < 10000) rec[0] = 0;
          if(10000 <= Integer.parseInt(rec[0]) < 20000) rec[0] = 10;
          if(20000 <= Integer.parseInt(rec[0]) < 30000) rec[0] = 20;
          if(30000 <= Integer.parseInt(rec[0]) < 40000) rec[0] = 30;
          if(40000 <= Integer.parseInt(rec[0]) < 50000) rec[0] = 40;
          if(50000 <= Integer.parseInt(rec[0]) < 60000) rec[0] = 50;
          if(60000 <= Integer.parseInt(rec[0]) < 70000) rec[0] = 60;
          if(70000 <= Integer.parseInt(rec[0]) < 80000) rec[0] = 70;
          if(80000 <= Integer.parseInt(rec[0]) < 90000) rec[0] = 80;
          if(90000 <= Integer.parseInt(rec[0]) < 100000) rec[0] = 90;
          if(100000 <= Integer.parseInt(rec[0]) < 110000) rec[0] = 100;
          if(110000 <= Integer.parseInt(rec[0]) < 120000) rec[0] = 110;
          if(120000 <= Integer.parseInt(rec[0]) < 130000) rec[0] = 120;
          if(130000 <= Integer.parseInt(rec[0]) < 140000) rec[0] = 130;
          if(140000 <= Integer.parseInt(rec[0]) < 150000) rec[0] = 140;
          if(150000 <= Integer.parseInt(rec[0]) < 160000) rec[0] = 150;
          if(160000 <= Integer.parseInt(rec[0]) < 170000) rec[0] = 160;
          if(170000 <= Integer.parseInt(rec[0]) < 180000) rec[0] = 170;

          if(-10000 <= Integer.parseInt(rec[0]) < 0) rec[0] = -10;
          if(-20000 <= Integer.parseInt(rec[0]) < -10000) rec[0] = -20;
          if(-30000 <= Integer.parseInt(rec[0]) < -20000) rec[0] = -30;
          if(-40000 <= Integer.parseInt(rec[0]) < -30000) rec[0] = -40;
          if(-50000 <= Integer.parseInt(rec[0]) < -60000) rec[0] = -50;
          if(-60000 <= Integer.parseInt(rec[0]) < -70000) rec[0] = -60;
          if(-70000 <= Integer.parseInt(rec[0]) < -80000) rec[0] = -70;
          if(-80000 <= Integer.parseInt(rec[0]) < -90000) rec[0] = -80;
          if(-90000 <= Integer.parseInt(rec[0]) < -100000) rec[0] = -90;
          if(-100000 <= Integer.parseInt(rec[0]) < -110000) rec[0] = -100;
          if(-110000 <= Integer.parseInt(rec[0]) < -120000) rec[0] = -110;
          if(-120000 <= Integer.parseInt(rec[0]) < -130000) rec[0] = -120;
          if(-130000 <= Integer.parseInt(rec[0]) < -140000) rec[0] = -130;
          if(-140000 <= Integer.parseInt(rec[0]) < -150000) rec[0] = -140;
          if(-150000 <= Integer.parseInt(rec[0]) < -160000) rec[0] = -150;
          if(-160000 <= Integer.parseInt(rec[0]) < -170000) rec[0] = -160;
          if(-170000 <= Integer.parseInt(rec[0]) < -180000) rec[0] = -170;
          
          return new Tuple2<Integer, Integer<(
              Integer.parseInt(rec[0]), Integer.parseInt(rec[1]));
        }
      }
    );
    JavaPairRDD<Integer, Integer> maxTemps = tuples.reduceByKey(
      new Function2<Integer, Integer, Integer>() {
        @Override public Integer call(Integer i1, Integer i2) {
          return Math.max(i1, i2);
        }
      }
    );
    maxTemps.saveAsTextFile(args[1]);
  }
}
