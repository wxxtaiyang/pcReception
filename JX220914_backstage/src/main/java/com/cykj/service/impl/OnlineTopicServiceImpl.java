package com.cykj.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcOnlinetopic;
import com.cykj.bean.PcOption;
import com.cykj.mapper.OnlineTopicMapper;
import com.cykj.service.OnlineTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OnlineTopicServiceImpl implements OnlineTopicService {
    @Autowired
    private OnlineTopicMapper onlineTopic;
    @Override
    public JSONObject queryOnlinetopicById(long id, int page, int size) {
        JSONObject js = new JSONObject();
        int limit = (page-1)*size;
        js.put("data",onlineTopic.queryOnlinetopicById(id,limit,size));
        js.put("count",Math.ceil(onlineTopic.countOnlieOnlinetopicById(id)*1.0/size));
        return js;
    }

    @Override
    public JSONObject insertOnlinetopicByFieldId(PcOnlinetopic onlinetopic, List<PcOption> list) {
        onlineTopic.insertOnlietopic(onlinetopic);
        for (PcOption option : list) {
            option.setOnlineid(onlinetopic.getOnlineid());
        }
        onlineTopic.insertOnlietopicOptions(list);
        JSONObject js = new JSONObject();
        js.put("msg","添加成功");
        return js;
    }

    @Override
    public JSONObject delteOnlinetopByOnlineId(long onlineid) {
        JSONObject js = new JSONObject();
        onlineTopic.deleteOptionsById(onlineid);
        onlineTopic.deleteOnlineTopById(onlineid);
        js.put("msg","删除成功");
        return js;
    }

    @Override
    public JSONObject updateOninletop(PcOnlinetopic onlinetopic) {
        JSONObject js = new JSONObject();
        int i = 0;
        i+=onlineTopic.updateOnlineTopById(onlinetopic);
        i+=onlineTopic.deleteOptionsById(onlinetopic.getOnlineid());
        i+=onlineTopic.insertOnlietopicOptions(onlinetopic.getOptions());
        if(i >= 3){
            js.put("msg","修改成功");
        }else{
            js.put("msg","修改失败");
        }
        return js;
    }
}
