package com.cykj.service;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcOnlinetopic;
import com.cykj.bean.PcOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OnlineTopicService {
    /**
     * 根据id查询题目
     * @param id id
     * @param page 页数
     * @param size 大小
     * @return json
     */
    JSONObject queryOnlinetopicById(long id,int page,int size);

    /**
     * 添加领域在线题目
     * @param onlinetopic 题目类
     * @param list 选项集合
     * @return json
     */
    JSONObject insertOnlinetopicByFieldId(PcOnlinetopic onlinetopic,List<PcOption> list);

    /**
     * 根据题目id删除该题目的信息
     * @param onlineid 题目id
     * @return json
     */
    JSONObject delteOnlinetopByOnlineId(long onlineid);

    /**
     * 修改在线题目信息
     * @param onlinetopic 在线题目类
     * @return json
     */
    JSONObject updateOninletop(PcOnlinetopic onlinetopic);
}
