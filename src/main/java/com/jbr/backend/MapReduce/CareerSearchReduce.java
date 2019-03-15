package com.jbr.backend.MapReduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

import static java.lang.Math.max;

public class CareerSearchReduce extends Reducer<Text, IntWritable, Text, Text>{
    /**
     *
     */
  //  @Override

    protected void reduce(Text key , Iterable<Text> ite ,Context context )
            throws IOException, InterruptedException {
        for (Text i : ite ){
            context .write( key , i);
        }

    }
}