package com.cykj.controller;

import com.cykj.bean.PcUser;
import com.cykj.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @RequestMapping("/insert")
    public String insertReport(HttpSession session,long num,long fieldid){
        return reportService.insertReport(session,num,fieldid).toString();
    }

    @RequestMapping("/query")
    public String queryReport(HttpSession session,int page,int size){
        PcUser user = (PcUser) session.getAttribute("user");
        return reportService.queryReportByUserId(user.getUserid(),page,size).toString();
    }
}
