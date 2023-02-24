package com.cykj.service;

import com.cykj.bean.PcOnlinetopic;

import java.util.List;

public interface OnlineService {
    /**
     * 根据领域id查询领域在线题目信息
     * @param fieldid 领域id
     * @return list
     */
    List<PcOnlinetopic> queryAllOnlinetopicByFieldId(long fieldid);
}
