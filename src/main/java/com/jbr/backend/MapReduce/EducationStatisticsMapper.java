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

public class EducationStatisticsMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    // 以职位类型作为键
    public Text k = new Text();
    // 以 1 作为 value
    public IntWritable v = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Configuration config = context.getConfiguration();
        try {

//            String careerNeed = config.get("career");    //获取传入的参数
            JSONObject jsonObj = new JSONObject(value.toString());
            Iterator<String> keys = jsonObj.keys();
            while (keys.hasNext()) {
                JSONObject information = jsonObj.getJSONObject(keys.next());
//                if (information.getString("职位类型").contains(careerNeed)) {
                k.set(information.getString("学历要求"));
                context.write(k, v);
//                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
