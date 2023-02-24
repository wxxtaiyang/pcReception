package com.cykj.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcPower;
import com.cykj.mapper.PowerMapper;
import com.cykj.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerMapperImpl implements PowerService {
    @Autowired
    private PowerMapper powerMapper;

    @Override
    public JSONObject getPowerByRoleId(long roleid) {
        JSONObject js = new JSONObject();
        List<PcPower> list = powerMapper.getPowerListByRole(roleid);
        js.put("list",list);
        return js;
    }

    @Override
    public JSONObject getNotRolePower(long roleid) {
        JSONObject js = new JSONObject();
        js.put("list",powerMapper.getPowerListByNotRoleId(roleid));
        return js;
    }

    @Override
    public JSONObject updateRolePower(long roleid, List<Integer> arr) {
        JSONObject js = new JSONObject();
        powerMapper.deleteRolePower(roleid);
        js.put("flag",powerMapper.addRolePower(roleid,arr));
        js.put("msg","修改成功");
        return js;
    }
}
