package com.cykj.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.mapper.ReportMapper;
import com.cykj.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public JSONObject queryAllReport(String min, String max, int minscore, int maxscore, int page, int size) {
        int index = (page-1)*size;
        JSONObject js = new JSONObject();
        js.put("data",reportMapper.queryReport(min,max,minscore,maxscore,index,size));
        js.put("count",reportMapper.queryCountReport(min,max,minscore,maxscore));
        js.put("msg","");
        js.put("code",0);
        return js;
    }
}
