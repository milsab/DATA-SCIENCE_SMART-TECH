/*
** Developed By: Milad Sabouri
** A20389859
** HW-06 
** Part 2 - Includeing Where Clause
*/

import java.io.IOException;

import com.cloudera.sqoop.lib.RecordParser.ParseError;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.*;
import java.util.*;

public class AvgTemp_part2 extends Configured implements Tool {

	public static class AvgTempRecMapper extends Mapper<LongWritable, Text, LongWritable, IntWritable> {

		private Record avgTemp = null;

		public void map(LongWritable k, Text v, Context context) {
			Record record = new Record();
			try {
				record.parse(v); 
			} catch (ParseError pe) {
				return;
			}

			try {
				Integer id = record.get_id();
				Integer temperature = record.get_temperature();
				if (null == temperature) {
					return;
				} else {
					//Implement the where clause conditions here in the Map function
        			//ATTENSION: 2 Celcius is going to 20 and 200 Celcius is going to 200 according to Data Set Description
					if (temperature.intValue() != 9999 && temperature.intValue() >= 20 && temperature.intValue() <= 200 && id.intValue() >= 1000 && id.intValue() <= 5000) {
						context.write(new LongWritable(0), new IntWritable(temperature.intValue()));

					}
				}
			} catch (Exception e) {
				//Handle Exception
			}
		}
	}

	public static class AvgTempRecReducer extends Reducer<LongWritable, IntWritable, FloatWritable, NullWritable> {

		public void reduce(LongWritable k, Iterable<IntWritable> list, Context context)
				throws IOException, InterruptedException {

			//Sum all temperatures
			int sum = 0;
			
			//Count the total number of records
			int count = 0;

			for (IntWritable i : list) {
				sum += i.get();
				count++;
			}

			//Calculate Average of Temperatures
			Float avg = (float) sum / count;
			context.write(new FloatWritable(avg), NullWritable.get());
		}
	}

	public int run(String[] args) throws Exception {
		Job job = new Job(getConf());

		job.setJarByClass(AvgTemp_part2.class);

		job.setMapperClass(AvgTempRecMapper.class);
		job.setReducerClass(AvgTempRecReducer.class);

		FileInputFormat.addInputPath(job, new Path("records_part2"));
		FileOutputFormat.setOutputPath(job, new Path("avgtemp_part2"));

		job.setMapOutputKeyClass(LongWritable.class);
		job.setMapOutputValueClass(IntWritable.class);

		job.setOutputKeyClass(FloatWritable.class);
		job.setOutputValueClass(NullWritable.class);

		job.setNumReduceTasks(1);

		if (!job.waitForCompletion(true)) {
			return 1; // error.
		}

		return 0;
	}

	public static void main(String[] args) throws Exception {
		int ret = ToolRunner.run(new AvgTemp_part2(), args);
		System.exit(ret);
	}
}