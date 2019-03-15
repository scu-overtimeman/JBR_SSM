package com.jbr.backend.service;

import com.jbr.backend.entity.AreaSearchResponse;
import com.jbr.backend.entity.Position;
import com.jbr.backend.utils.HadoopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.jbr.backend.utils.HadoopUtil.getLineFile;

@Service
public class SearchService {
    @Autowired
    private HadoopService hadoopService;

    public List<Position> salarySearch(String minSalary,String maxSalary) throws Exception {
        hadoopService.salarySearch(minSalary,maxSalary);
        List<String> list = HadoopUtil.getLineFile("/usr/SalarySearchOutput/part-r-00000");
        List<Position> results = new ArrayList<>();
        for(String line : list){
            String[] lineSpilt = line.split("\t");
            String[] s = lineSpilt[1].split("_");
            results.add(new Position(s[0],s[1],s[3],s[2],s[4],s[5]));
        }
        return results;
    }

    public List<AreaSearchResponse> areaSearch(String position) throws Exception {
        hadoopService.areaSearch(position);
        List<String> list = HadoopUtil.getLineFile("/usr/AreaSearchOutput/part-r-00000");
        List<AreaSearchResponse> results = new ArrayList<>();
        for(String line : list){
            String[] keyValue = line.split("\t");
            String[] keySpilt = keyValue[0].split("_");
            results.add(new AreaSearchResponse(keySpilt[0],keySpilt[1],keyValue[1]));
        }
        return results;
    }

}
