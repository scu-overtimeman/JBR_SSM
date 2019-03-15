package com.jbr.backend.Controller;

import com.jbr.backend.dto.RespBean;
import com.jbr.backend.dto.request.SearchBoxRequest;
import com.jbr.backend.dto.request.SearchRegionRequest;
import com.jbr.backend.dto.request.SearchSalaryRangeRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping("transaction/")
@RestController
public class SearchController {

    @PostMapping("searchBox")
    public @ResponseBody
    RespBean search(@RequestBody SearchBoxRequest searchBoxRequest){
        return RespBean.ok("1");

    }

    @PostMapping("searchRegion")
    public @ResponseBody
    RespBean search(@RequestBody SearchRegionRequest searchRegionRequest){
        return RespBean.ok("2");
    }

    @PostMapping("searchSalaryRange")
    public @ResponseBody
    RespBean search(@RequestBody SearchSalaryRangeRequest searchSalaryRangeRequest){
        return RespBean.ok("3");
    }
    @GetMapping("search")
    public @ResponseBody
    RespBean search(){
        return RespBean.ok("4");
    }
}
