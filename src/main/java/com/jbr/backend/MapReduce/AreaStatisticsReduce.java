package com.jbr.backend.MapReduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

import static java.lang.Math.max;

public class AreaStatisticsReduce extends Reducer<Text, IntWritable, Text, IntWritable>{
    /**
     *
     */
    @Override
    protected void reduce(Text key , Iterable<IntWritable> ite ,Context context )
            throws IOException, InterruptedException {
        int maxSalary = 0;   //最大薪资
        for (IntWritable i : ite ){
            maxSalary = max(maxSalary,i.get());    //获取最大薪资
        }
        context .write( key , new IntWritable(maxSalary));
    }
}