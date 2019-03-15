package com.jbr.backend.Controller;

import com.jbr.backend.dto.RespBean;
import com.jbr.backend.dto.request.SearchBoxRequest;
import com.jbr.backend.dto.request.SearchRegionRequest;
import com.jbr.backend.dto.request.SearchSalaryRangeRequest;
import com.jbr.backend.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("transaction/")
@RestController
public class SearchController {
    @Autowired
    SearchService searchService;

    @PostMapping("searchBox")
    public @ResponseBody
    RespBean search(@RequestBody SearchBoxRequest searchBoxRequest) {
        return RespBean.ok("1");

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
    @GetMapping("search")
    public @ResponseBody
    RespBean search() {
        return RespBean.ok("4");
    }
}
