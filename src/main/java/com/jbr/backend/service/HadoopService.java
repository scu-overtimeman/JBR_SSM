package com.jbr.backend.service;

import com.jbr.backend.MapReduce.SalarySearchMapper;
import com.jbr.backend.MapReduce.SalarySearchReduce;
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


//    public boolean location(String inputFileDir, String outputFileDir)
//            throws IOException, ClassNotFoundException, InterruptedException {
//        //创建工作跟踪者的对象
//        Job job = Job.getInstance(configuration, "LocationShow");
//        job.setJarByClass(HadoopService.class);
//        job.setMapperClass(LocationMapper.class);
//        job.setReducerClass(LocationReducer.class);
//
//
//        //设置reducer的输出的类型
//        job.setOutputKeyClass(Text.class);
//        job.setOutputValueClass(Text.class);
//
//        //指定输入输出文件的目录
//        FileInputFormat.setInputPaths(job, new Path(inputFileDir));
//        FileOutputFormat.setOutputPath(job, new Path(outputFileDir));
//
//        //判断是否执行结束
//        if (job.waitForCompletion(true)) {
//            System.out.println("程序执行结束!");
//            return true;
//        }
//        return false;
//    }

    public boolean salarySearch(String inputFileDir, String outputFileDir, String minSalary, String maxSalary)
            throws Exception {

        //设置薪资范围,不需要的时候不设置即可
        configuration.set("maxSalary", maxSalary);
        configuration.set("minSalary", minSalary);
        return salary();

    }


    public boolean salary()
            throws Exception {

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
        HadoopUtil.DeleteFile("/usr/output");
        FileOutputFormat.setOutputPath(job, new Path("/usr/output"));
        if (job.waitForCompletion(true)) {
            System.out.println("程序执行结束");
            return true;
        }
        return false;
    }

//    public boolean academic(String inputFileDir, String outputFileDir)
//            throws IOException, ClassNotFoundException, InterruptedException {
//        //创建工作跟踪者对象
//        Job job = Job.getInstance(configuration, "AcademicShow");
//        job.setJarByClass(HadoopService.class);
//        job.setMapperClass(AcademicMapper.class);
//        job.setReducerClass(AcademicReducer.class);
//
//        //设置输出类型
//        job.setOutputKeyClass(Text.class);
//        job.setOutputValueClass(IntWritable.class);
//
//        //设置输入输出
//        FileInputFormat.setInputPaths(job, new Path(inputFileDir));
//        FileOutputFormat.setOutputPath(job, new Path(outputFileDir));
//
//        if (job.waitForCompletion(true)) {
//            System.out.println("程序执行结束");
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 统计职能分类的数据，以及每个职能的最低薪资、最高薪资和该职能对应的人员需求
//     *
//     * @param inputFileDir  数据路径
//     * @param outputFileDir 输出路径
//     * @return hadoop是否执行成功
//     * @throws IOException
//     * @throws ClassNotFoundException
//     * @throws InterruptedException
//     */
//    public boolean function(String inputFileDir, String outputFileDir)
//            throws IOException, ClassNotFoundException, InterruptedException {
//        //创建工作跟踪对象
//        Job job = Job.getInstance(configuration, "getSearchSalary");
//        job.setJarByClass(HadoopService.class);
//        job.setMapperClass(FunctionMapper.class);
//        job.setReducerClass(FunctionReducer.class);
//
//        //设置reducer的输出的类型
//        job.setOutputKeyClass(Text.class);
//        job.setOutputValueClass(Text.class);
//
//        //指定输入输出文件的目录
//        FileInputFormat.setInputPaths(job, new Path(inputFileDir));
//        FileOutputFormat.setOutputPath(job, new Path(outputFileDir));
//
//        //判断是否执行结束
//        if (job.waitForCompletion(true)) {
//            System.out.println("程序执行结束!");
//            return true;
//        }
//        return false;
//    }

}
