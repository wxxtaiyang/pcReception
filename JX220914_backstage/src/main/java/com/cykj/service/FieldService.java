package com.cykj.service;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcField;

import java.util.List;

public interface FieldService {

    /**
     * 查询所有领域id和领域名称
     * @return json
     */
    JSONObject queryAllField();
}
