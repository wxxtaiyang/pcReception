package com.cykj.service;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcField;

import java.util.List;

public interface FieldService {
    /**
     * 查询所有的领域信息
     * @return list
     */
    List<PcField> queryAllFiled();

    /**
     * 根据领域id查询咨询师信息
     * @param fieldid 领域id
     * @return json
     */
    JSONObject queryAdminsByFieldId(long fieldid);

    /**
     * 根据管理员id查询管理员的所有信息
     * @param adminid 管理员id
     * @return json
     */
    JSONObject queryAdminByAdminId(long adminid);

    /**
     * 根据咨询师id和时间查询可预约时间段
     * @param adminid 咨询师id
     * @param time 时间
     * @return json
     */
    JSONObject queryAdminacpByAdminidDatetime(long adminid,String time);
}
