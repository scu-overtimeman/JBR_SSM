package com.jbr.backend.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;

/**
 * 类或方法的功能描述 :Hadoop工具类
 * @date: 2018-11-28 13:59
 */
@Component
public class HadoopUtil {
    @Value("${hdfs.path}")
    private String path;
    @Value("${hdfs.username}")
    private String username;

    private static String hdfsPath;
    private static String hdfsName;

    /**
     * 获取HDFS配置信息
     * @return
     */
    private static Configuration getConfiguration() {

        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", hdfsPath);

        return configuration;
    }

    /**
     * 获取HDFS文件系统对象
     * @return
     * @throws Exception
     */
    public static FileSystem getFileSystem() throws Exception {
        // 客户端去操作hdfs时是有一个用户身份的，默认情况下hdfs客户端api会从jvm中获取一个参数作为自己的用户身份 DHADOOP_USER_NAME=hadoop
//        FileSystem hdfs = FileSystem.get(getHdfsConfig()); //默认获取
//        也可以在构造客户端fs对象时，通过参数传递进去
        FileSystem fileSystem = FileSystem.get(new URI(hdfsPath), getConfiguration(), hdfsName);
        return fileSystem;
    }



    @PostConstruct
    public void getPath() {
        hdfsPath = this.path;
    }
    @PostConstruct
    public void getName() {
        hdfsName = this.username;
    }


    public static String getHdfsPath() {
        return hdfsPath;
    }

    public String getUsername() {
        return username;
    }

    public static String[] getLineFile(String path) throws Exception {
        FileSystem fs = getFileSystem();
        FSDataInputStream fsDataInputStream = fs.open(new Path(path));
        BufferedReader br = new BufferedReader(new InputStreamReader(fsDataInputStream,"utf-8"));
        String line = br.readLine();

        return  line.split(" ");
    }
}


