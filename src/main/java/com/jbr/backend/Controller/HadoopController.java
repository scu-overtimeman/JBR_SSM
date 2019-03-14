package com.jbr.backend.Controller;

import com.jbr.backend.dto.RespBean;
import com.jbr.backend.utils.HadoopUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.Configuration;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 类或方法的功能描述 :TODO
 * @date: 2018-11-28 13:51
 */
@RestController
@RequestMapping("/hadoop")
public class HadoopController {

    /**
     * 创建文件夹
     * @param path
     * @return
     * @throws Exception
     */
    @PostMapping("/mkdir")
    public RespBean mkdir(@RequestParam("path") String path) throws Exception {
        if (StringUtils.isEmpty(path)) {
            return RespBean.error("请求参数为空");
        }
        // 文件对象
        FileSystem fs = HadoopUtil.getFileSystem();
        // 目标路径
        Path newPath = new Path(path);
        // 创建空文件夹
        boolean isOk = fs.mkdirs(newPath);
        fs.close();
        if (isOk) {
            return RespBean.ok("create dir success");
        } else {
            return RespBean.error("create dir fail");
        }
    }
    @PostMapping("/createFile")
    public RespBean createFile(@RequestParam("path")String path) throws Exception {
        if(StringUtils.isEmpty(path)){
            return RespBean.error("请求参数为空");
        }
        FileSystem fs = HadoopUtil.getFileSystem();

        Path newPath = new Path(path);
        boolean isOk = fs.createNewFile(newPath);
        if (isOk) {
            return RespBean.ok("create file success");
        } else {
            return RespBean.error("create file fail");
        }
    }

    @GetMapping("/getFile")
    public RespBean getWc(@RequestParam("path")String path) throws Exception {

        try{
            FileSystem fs = HadoopUtil.getFileSystem();

            FSDataInputStream fsDataInputStream = fs.open(new Path(path));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsDataInputStream, "utf-8"));
            String line;
            StringBuilder res = null;
            while ((line=bufferedReader.readLine())!=null){
                res.append(line);
            }
            return RespBean.ok("获取成功",res);
        }catch (Exception e){
            return RespBean.error("get file faile");
        }
    }
}

