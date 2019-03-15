package com.jbr.backend.MapReduce;

import java.io.IOException;
import java.util.Iterator;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


/**
 * 用到默认的 inputformat ： fileInputFormat 类，把数据片段中的数据一行一行读进来，每行下标为 key ，每行的内容为 value
 * @author benxi
 *
 */
public class CareerStatisticsMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
    // 以职位类型作为键
    public Text k = new Text();
    // 以 1 作为 value
    public IntWritable v = new IntWritable(1);
    @Override
    protected void map(LongWritable key , Text value , Context context ) throws IOException, InterruptedException{
        try {
            JSONObject jsonObj = new JSONObject(value.toString());
            Iterator<String> keys = jsonObj.keys();
            while (keys.hasNext()){
                String career = jsonObj.getJSONObject(keys.next()).getString("职位类型");
                k.set(career);
                context.write(k, v);
            }
        }catch(JSONException e){
                e.printStackTrace();
        }
    }
}
