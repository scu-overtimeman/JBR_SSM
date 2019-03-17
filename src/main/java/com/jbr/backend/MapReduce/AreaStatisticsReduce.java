package com.jbr.backend.MapReduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

import static java.lang.Math.max;

public class AreaStatisticsReduce extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> ite, Context context)
            throws IOException, InterruptedException {
        int sum = 0;   //最大薪资
        for (IntWritable i : ite) {
            sum+=i.get();
        }
        context.write(key, new IntWritable(sum));
    }
}