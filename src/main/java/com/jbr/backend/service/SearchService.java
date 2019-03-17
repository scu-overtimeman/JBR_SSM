package com.jbr.backend.service;

import com.jbr.backend.dto.response.LPSResponse;
import com.jbr.backend.entity.Position;
import com.jbr.backend.utils.HadoopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    public List<LPSResponse> areaSearch(String area) throws Exception {
        hadoopService.areaSearch(area);
        List<String> list = HadoopUtil.getLineFile("/usr/AreaSearchOutput/part-r-00000");
        List<LPSResponse> results = new ArrayList<>();
        for(String line : list){
            String[] keyValue = line.split("\t");
//            String[] keySpilt = keyValue[0].split("_");
            results.add(new LPSResponse(keyValue[0],keyValue[1]));
        }

        results.sort(new Comparator<LPSResponse>() {
            @Override
            public int compare(LPSResponse o1, LPSResponse o2) {
                return -Integer.valueOf(o1.getCount()).compareTo(Integer.valueOf(o2.getCount()));
            }
        });
        return results;
    }

    public List<Position> careerSearch(String career) throws Exception {
        hadoopService.careerSearch(career);
        List<String> list = HadoopUtil.getLineFile("/usr/CareerSearchOutput/part-r-00000");
        List<Position> results = new ArrayList<>();
        for(String line:list){
            String[] value = line.split("\t")[1].split("_");
            results.add(new Position(value[0],value[1],value[3],value[2],value[4],value[5]));
        }
        return results;
    }

}
