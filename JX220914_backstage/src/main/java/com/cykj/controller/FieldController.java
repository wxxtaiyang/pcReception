package com.cykj.controller;

import com.cykj.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/field")
public class FieldController {
    @Autowired
    private FieldService fieldService;

    @RequestMapping("/all")
    public String queryAll(){
       return fieldService.queryAllField().toString();
    }
}
