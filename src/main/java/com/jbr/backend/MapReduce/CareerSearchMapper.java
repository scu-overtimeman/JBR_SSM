package com.jbr.backend.MapReduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;

public class CareerSearchMapper extends Mapper<LongWritable, Text, Text, Text> {
    // 以职位类型作为键
    public Text k = new Text();


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Configuration config = context.getConfiguration();
        try {
            String career = config.get("career");    //获取传入的参数
            JSONObject jsonObj = new JSONObject(value.toString());
            Iterator<String> keys = jsonObj.keys();
            while (keys.hasNext()) {
                String data = keys.next();
                JSONObject information = jsonObj.getJSONObject(data);
                if (information.getString("职位类型").contains(career)) {
                    k.set(data);
                    context.write(k, new Text(new Text(data + "_" +
                            information.getString("单位") + "_" +
                            information.getInt("薪资上限") + "_" +
                            information.getInt("薪资下限") + "_" +
                            information.getString("学历要求") + "_" +
                            information.getString("地域"))));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
