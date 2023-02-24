package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcAdmin;
import com.cykj.service.PowerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/power")
public class PowerController {
    private static PcAdmin admin;
    @Autowired
    private PowerService powerService;

    @RequestMapping("/getlist")
    public String getPowerByRole(HttpSession session){
        admin = (PcAdmin) session.getAttribute("admin");
        return powerService.getPowerByRoleId(admin.getRoleid()).toString();
    }

    @RequestMapping("/rolePower")
    public String getNotRolePower(long roleid){
        JSONObject js= new JSONObject();
        js.put("role",powerService.getPowerByRoleId(roleid).get("list"));
        js.put("not",powerService.getNotRolePower(roleid).get("list"));
        return js.toString();

    }
    @RequestMapping("/updatePower")
    public String updatePowerByRoleId(long roleid,@RequestParam("arr[]")List<Integer> arr){
        return powerService.updateRolePower(roleid,arr).toString();
    }

}
