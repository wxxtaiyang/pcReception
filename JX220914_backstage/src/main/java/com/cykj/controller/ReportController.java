package com.cykj.controller;

import com.cykj.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @RequestMapping("/query")
    public String queryAllReport(String min,String max,int minscore,
                                 int maxscore,int page,int limit){
        return reportService.queryAllReport(min, max, minscore, maxscore, page, limit).toString();
    }

}
