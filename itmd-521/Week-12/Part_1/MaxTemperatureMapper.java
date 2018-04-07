/*
*   Milad Sabouri
*   Assignment Week-12
*/
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxTemperatureMapper
  extends Mapper<LongWritable, Text, Text, IntWritable> {
  
  enum CustomCounters{
      TEMPERATURE_OVER_50,  //Number of records with temperature more than 50 degree
      MALFORMED_RECORDS,    //Number of records with malformed data including MISSING data 
      TOTAL_RECORDS         //Number of total records
  }

  private static final int MISSING = 9999;
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
    try{
        context.getCounter(CustomCounters.TOTAL_RECORDS).increment(1);
        String line = value.toString();
        String year = line.substring(15, 19);
        int airTemperature;
        if (line.charAt(87) == '+') { // parseInt doesn't like leading plus signs
          airTemperature = Integer.parseInt(line.substring(88, 92));
        } else {
          airTemperature = Integer.parseInt(line.substring(87, 92));
        }
        String quality = line.substring(92, 93);
        if(airTemperature == MISSING){
          context.getCounter(CustomCounters.MALFORMED_RECORDS).increment(1);
        }
        if (airTemperature != MISSING && quality.matches("[01459]") && Integer.parseInt(year) == 1983 )  {
          if (airTemperature > 500){
             context.getCounter(CustomCounters.TEMPERATURE_OVER_50).increment(1); 
          }

          context.write(new Text(year), new IntWritable(airTemperature));
        }
    } catch(Exception e){
      context.getCounter(CustomCounters.MALFORMED_RECORDS).increment(1);
    }
    
  }
}
// ^^ MaxTemperatureMapper
