package com.jbr.backend.MapReduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;


/**
 * 用到默认的 inputformat ： fileInputFormat 类，把数据片段中的数据一行一行读进来，每行下标为 key ，每行的内容为 value
 * @author benxi
 *
 */
public class SalarySearchMapper extends Mapper<LongWritable, Text, IntWritable, Text>{
    // 以薪资上限作为键
 //  public IntWritable k = new IntWritable();

    @Override
    protected void map(LongWritable key , Text value , Context context ) throws IOException, InterruptedException{
        Configuration config=context.getConfiguration();
        try {
            int salaryT=Integer.valueOf(config.get("maxSalary"));    //获取传入的参数
            int salaryB=Integer.valueOf(config.get("minSalary"));    //获取传入的参数
            JSONObject jsonObj = new JSONObject(value.toString());
            Iterator<String> keys = jsonObj.keys();
            while (keys.hasNext()){
                String name=keys.next();
                JSONObject information=jsonObj.getJSONObject(name);
                if(information.getInt("薪资上限")<=salaryT && information.getInt("薪资下限")>=salaryB){
                    context.write(new IntWritable(information.getInt("薪资上限")),
                                  new Text(name+"_"+
                                                  information.getString("单位")+"_"+
                                                  information.getInt("薪资上限")+"_"+
                                                  information.getInt("薪资下限")+"_"+
                                                  information.getString("学历要求")+"_"+
                                                  information.getString("地域")));
                }

            }
        }catch(JSONException e){
                e.printStackTrace();
        }
    }
}
