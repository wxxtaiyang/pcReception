package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.OnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/online")
public class OnlineController {
    @Autowired
    private OnlineService onlineService;

    @RequestMapping("/query")
    public String queryOnlineByFieldId(long fieldid){
        return JSONObject.toJSONString(onlineService.queryAllOnlinetopicByFieldId(fieldid));
    }

}
