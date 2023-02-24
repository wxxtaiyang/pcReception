package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/field")
public class FieldController {
    @Autowired
    private FieldService fieldService;

    @RequestMapping("/query")
    public String queryAllField(){
        return JSONObject.toJSONString(fieldService.queryAllFiled());
    }

    @RequestMapping("/fields")
    public String queryAdminByFieldId(long fieldid){
        return fieldService.queryAdminsByFieldId(fieldid).toString();
    }

    @RequestMapping("/admins")
    public String queryAdminByAdminId(long adminid){
        return fieldService.queryAdminByAdminId(adminid).toString();
    }

    @RequestMapping("/datetime")
    public String queryAdminacpByAdminidAndTime(String datetime,long adminid){
        return fieldService.queryAdminacpByAdminidDatetime(adminid,datetime).toString();
    }
}
