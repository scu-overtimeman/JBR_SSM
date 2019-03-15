package com.jbr.backend.MapReduce;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CareerStatisticsReduce extends Reducer<Text, IntWritable, Text, IntWritable>{
    /**
     *
     */
    @Override
    protected void reduce(Text key , Iterable<IntWritable> ite ,Context context )
            throws IOException, InterruptedException {
        int sum = 0;
        for (IntWritable i : ite ){
            sum += i .get();
        }
        context .write( key , new IntWritable( sum ));
    }
}