package com.jbr.backend.service;

import com.jbr.backend.MapReduce.*;
import com.jbr.backend.utils.DescSort;
import com.jbr.backend.utils.HadoopUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HadoopService {



    private static final String HDFS_URL = "hdfs://127.0.0.1:9000";
    private Configuration configuration;

    public HadoopService() {
        configuration = new Configuration();
        configuration.set("fs.default.name", HDFS_URL);
    }

    public boolean salarySearch(String minSalary, String maxSalary)
            throws Exception {

        //设置薪资范围,不需要的时候不设置即可
        configuration.set("maxSalary", maxSalary);
        configuration.set("minSalary", minSalary);

        Job job = Job.getInstance(configuration, "SalarySearch");
        job.setJarByClass(HadoopService.class);
        job.setMapperClass(SalarySearchMapper.class);
        job.setReducerClass(SalarySearchReduce.class);

        //设置输出类型
        job.setSortComparatorClass(DescSort.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(Text.class);

        //设置输入输出
        FileInputFormat.setInputPaths(job, new Path("/usr/input/*"));
        HadoopUtil.DeleteFile("/usr/SalarySearchOutput");
        FileOutputFormat.setOutputPath(job, new Path("/usr/SalarySearchOutput"));
        if (job.waitForCompletion(true)) {
            System.out.println("程序执行结束");
            return true;
        }
        return false;


    }

    public boolean careerSearch(String career)
            throws Exception {

        //设置薪资范围,不需要的时候不设置即可
        configuration.set("career", career);

        Job job = Job.getInstance(configuration, "CareerSearch");
        job.setJarByClass(HadoopService.class);
        job.setMapperClass(CareerSearchMapper.class);
        job.setReducerClass(CareerSearchReduce.class);

        //设置输出类型
        job.setSortComparatorClass(DescSort.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        //设置输入输出
        FileInputFormat.setInputPaths(job, new Path("/usr/input/*"));
        HadoopUtil.DeleteFile("/usr/CareerSearchOutput");
        FileOutputFormat.setOutputPath(job, new Path("/usr/CareerSearchOutput"));
        if (job.waitForCompletion(true)) {
            System.out.println("程序执行结束");
            return true;
        }
        return false;
    }

    public boolean areaSearch(String area)
            throws Exception {


        configuration.set("area", area);

        Job job = Job.getInstance(configuration, "AreaSearch");
        job.setJarByClass(HadoopService.class);
        job.setMapperClass(AreaSearchMapper.class);
        job.setReducerClass(AreaSearchReduce.class);

        //设置输出类型
//        job.setSortComparatorClass(DescSort.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //设置输入输出
        FileInputFormat.setInputPaths(job, new Path("/usr/input/*"));
        HadoopUtil.DeleteFile("/usr/AreaSearchOutput");
        FileOutputFormat.setOutputPath(job, new Path("/usr/AreaSearchOutput"));
        if (job.waitForCompletion(true)) {
            System.out.println("程序执行结束");
            return true;
        }
        return false;
    }

    public boolean salaryStatistics() throws Exception {

        Job job = Job.getInstance(configuration, "SalaryStatistics");
        job.setJarByClass(HadoopService.class);
        job.setMapperClass(SalaryStatisticsMapper.class);
        job.setReducerClass(SalaryStatisticsReduce.class);

        //设置输出类型
        job.setSortComparatorClass(DescSort.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //设置输入输出
        FileInputFormat.setInputPaths(job, new Path("/usr/input/*"));
        HadoopUtil.DeleteFile("/usr/SalaryStatisticsOutput");
        FileOutputFormat.setOutputPath(job, new Path("/usr/SalaryStatisticsOutput"));
        if (job.waitForCompletion(true)) {
            System.out.println("程序执行结束");
            return true;
        }
        return false;
    }

    public boolean educationStatistics() throws Exception {


//        configuration.set("career", career);


        Job job = Job.getInstance(configuration, "EducationStatistics");
        job.setJarByClass(HadoopService.class);
        job.setMapperClass(EducationStatisticsMapper.class);
        job.setReducerClass(EducationStatisticsReduce.class);

        //设置输出类型
        job.setSortComparatorClass(DescSort.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //设置输入输出
        FileInputFormat.setInputPaths(job, new Path("/usr/input/*"));
        HadoopUtil.DeleteFile("/usr/EducationStatisticsOutput");
        FileOutputFormat.setOutputPath(job, new Path("/usr/EducationStatisticsOutput"));
        if (job.waitForCompletion(true)) {
            System.out.println("程序执行结束");
            return true;
        }
        return false;
    }

    public boolean areaStatistics() throws Exception {


        Job job = Job.getInstance(configuration, "AreaStatistics");
        job.setJarByClass(HadoopService.class);
        job.setMapperClass(AreaStatisticsMapper.class);
        job.setReducerClass(AreaStatisticsReduce.class);

        //设置输出类型
        job.setSortComparatorClass(DescSort.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //设置输入输出
        FileInputFormat.setInputPaths(job, new Path("/usr/input/*"));
        HadoopUtil.DeleteFile("/usr/AreaStatisticsOutput");
        FileOutputFormat.setOutputPath(job, new Path("/usr/AreaStatisticsOutput"));
        if (job.waitForCompletion(true)) {
            System.out.println("程序执行结束");
            return true;
        }
        return false;
    }


    public boolean careerStatistics() throws Exception {


        Job job = Job.getInstance(configuration, "careerStatistics");
        job.setJarByClass(HadoopService.class);
        job.setMapperClass(CareerStatisticsMapper.class);
        job.setReducerClass(CareerStatisticsReduce.class);

        //设置输出类型
        job.setSortComparatorClass(DescSort.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //设置输入输出
        FileInputFormat.setInputPaths(job, new Path("/usr/input/*"));
        HadoopUtil.DeleteFile("/usr/CareerStatisticsOutput");
        FileOutputFormat.setOutputPath(job, new Path("/usr/CareerStatisticsOutput"));
        if (job.waitForCompletion(true)) {
            System.out.println("程序执行结束");
            return true;
        }
        return false;
    }
}

