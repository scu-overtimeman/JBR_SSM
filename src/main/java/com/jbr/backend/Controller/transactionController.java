package com.jbr.backend.Controller;

import com.jbr.backend.dto.RespBean;
import com.jbr.backend.dto.request.EducationStatisticsRequest;
import com.jbr.backend.dto.request.SearchBoxRequest;
import com.jbr.backend.dto.request.SearchRegionRequest;
import com.jbr.backend.dto.request.SearchSalaryRangeRequest;
import com.jbr.backend.service.SearchService;
import com.jbr.backend.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("transaction/")
@RestController
public class transactionController {
    final SearchService searchService;
    final StatisticsService statisticsService;
    @Autowired
    public transactionController(SearchService searchService, StatisticsService statisticsService) {
        this.searchService = searchService;
        this.statisticsService = statisticsService;
    }

    @PostMapping("searchBox")
    public @ResponseBody
    RespBean search(@RequestBody SearchBoxRequest searchBoxRequest) {
        try{
            return RespBean.ok("检索成功",searchService.careerSearch(searchBoxRequest.getSearchKeys()));
        }catch (Exception e){
            return RespBean.error("检索失败");
        }

    }

    @PostMapping("searchRegion")
    public @ResponseBody
    RespBean search(@RequestBody SearchRegionRequest searchRegionRequest) {
        try {
            return RespBean.ok("检索成功", searchService.areaSearch(searchRegionRequest.format()));
        } catch (Exception e) {
            return RespBean.error("检索失败");
        }
    }

    @PostMapping("searchSalaryRange")
    public @ResponseBody
    RespBean search(@RequestBody SearchSalaryRangeRequest searchSalaryRangeRequest) {
        try {
            return RespBean.ok("检索成功", searchService.salarySearch(searchSalaryRangeRequest.getFloor(), searchSalaryRangeRequest.getCeiling()));
        } catch (Exception e) {
            return RespBean.error("检索失败");
        }
    }
    @PostMapping("AreaStatistics")
    public @ResponseBody
    RespBean areaStatistics(){
        try{
            return RespBean.ok("统计成功",statisticsService.areaStatistics());
        }catch (Exception e){
            return RespBean.error("统计失败");

        }
    }
    @PostMapping("AreaStatistics")
    public @ResponseBody
    RespBean careerStatistics(){
        try{
            return RespBean.ok("统计成功",statisticsService.careerStatistics());
        }catch (Exception e){
            return RespBean.error("统计失败");
        }
    }
    @PostMapping("EducationStatistics")
    public @ResponseBody
    RespBean educationStatistics(@RequestBody EducationStatisticsRequest request){
        try {
            return RespBean.ok("统计成功",statisticsService.educationStatistics(request.getCareer()));
        } catch (Exception e) {
            return RespBean.error("统计失败");
        }
    }
    @PostMapping("SalaryStatistics")
    public @ResponseBody
    RespBean salaryStatistics(){
        try {
            return RespBean.ok("统计成功",statisticsService.salaryStatistics());
        } catch (Exception e) {
            return RespBean.error("统计失败");
        }
    }
}
