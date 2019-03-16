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

public class AreaSearchMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    // 以职位类型作为键
    public Text k = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Configuration config = context.getConfiguration();
        try {
            String area = config.get("area");    //获取传入的参数
            JSONObject jsonObj = new JSONObject(value.toString());
            Iterator<String> keys = jsonObj.keys();
            while (keys.hasNext()) {
                JSONObject information = jsonObj.getJSONObject(keys.next());
                if (information.getString("地域").equals(area)) {
                    String data = information.getString("地域") + "_" + information.getString("职位类型");
                    k.set(data);
                    context.write(k, new IntWritable(information.getInt("薪资上限")));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
