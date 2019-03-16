package com.jbr.backend.MapReduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SalarySearchReduce extends Reducer<Text, IntWritable, IntWritable, Text> {


    protected void reduce(IntWritable key, Iterable<Text> ite, Context context)
            throws IOException, InterruptedException {
        for (Text i : ite) {
            context.write(key, i);
        }

    }
}