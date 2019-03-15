package com.jbr.backend.service;

import com.jbr.backend.dto.response.LPSResponse;
import com.jbr.backend.dto.response.CareerStatisticsResponse;
import com.jbr.backend.dto.response.EducationStatisticsResponce;
import com.jbr.backend.dto.response.PSResponse;
import com.jbr.backend.utils.HadoopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {
    @Autowired
    private HadoopService hadoopService;

    public List<LPSResponse> areaStatistics() throws Exception {
        hadoopService.areaStatistics();
        List<String> list = HadoopUtil.getLineFile("/usr/AreaStatisticsOutput/part-r-00000");
        List<LPSResponse> results = new ArrayList<>();
        for(String line : list){
            String[] keyValue = line.split("\t");
            String[] keySpilt = keyValue[0].split("_");
            results.add(new LPSResponse(keySpilt[0],keySpilt[1],keyValue[1]));
        }
        return results;
    }

    public List<CareerStatisticsResponse> careerStatistics() throws Exception {
        hadoopService.careerStatistics();
        List<String> list = HadoopUtil.getLineFile("/usr/CareerStatisticsOutput/part-r-00000");
        List<CareerStatisticsResponse> results = new ArrayList<>();
        for(String line : list){
            String[] keyValue = line.split("\t");
            results.add(new CareerStatisticsResponse(keyValue[0],keyValue[1]));
        }
        return results;
    }

    public List<EducationStatisticsResponce> educationStatistics(String career) throws Exception {
        hadoopService.educationStatistics(career);
        List<String> list = HadoopUtil.getLineFile("/usr/EducationStatisticsOutput/part-r-00000");
        List<EducationStatisticsResponce> results = new ArrayList<>();
        for(String line : list){
            String[] keyValue = line.split("\t");
            results.add(new EducationStatisticsResponce(keyValue[0],keyValue[1]));
        }
        return results;
    }

    public List<PSResponse> salaryStatistics() throws Exception {
        hadoopService.salaryStatistics();
        List<String> list = HadoopUtil.getLineFile("/usr/SalaryStatisticsOutput/part-r-00000");
        List<PSResponse> results = new ArrayList<>();
        for(String line : list){
            String[] keyValue = line.split("\t");
            results.add(new PSResponse(keyValue[0],keyValue[1]));
        }
        return results;
    }
}
