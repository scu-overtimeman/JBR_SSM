package com.jbr.backend.MapReduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;


public class AreaStatisticsMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    public Text k = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        try {
            JSONObject jsonObj = new JSONObject(value.toString());
            Iterator<String> keys = jsonObj.keys();
            while (keys.hasNext()) {
                JSONObject information = jsonObj.getJSONObject(keys.next());
             //   int salary = information.getInt("薪资上限");
             //   String data = information.getString("地域") + "_" + information.getString("职位类型");
             //   if (salary > 0) {        //剔除薪资“面议”的职位
                    k.set(information.getString("地域"));
                    context.write(k, new IntWritable(1));
             //   }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
