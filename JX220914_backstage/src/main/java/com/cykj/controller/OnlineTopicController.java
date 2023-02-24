package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.PcOnlinetopic;
import com.cykj.bean.PcOption;
import com.cykj.service.OnlineTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/onlinetopic")
public class OnlineTopicController {
    @Autowired
    private OnlineTopicService topicService;

    @RequestMapping("/query")
    public String queryAllOnlineTopic(long fieldid,int page,int size){
        return topicService.queryOnlinetopicById(fieldid,page,size).toString();
    }

    @RequestMapping("/insert")
    public String insertOnlintToptic(long fieldid, String title,String list){
        PcOnlinetopic onlinetopic = new PcOnlinetopic();
        onlinetopic.setOnlinecontext(title);
        onlinetopic.setFieldid(fieldid);
        List<PcOption> options = JSONObject.parseArray(list,PcOption.class);
        return topicService.insertOnlinetopicByFieldId(onlinetopic,options).toString();
    }
    @RequestMapping("/del")
    public String delOnlineToptic(long onlineid){
        return topicService.delteOnlinetopByOnlineId(onlineid).toString();
    }

    @RequestMapping("/update")
    public String updateOnlinetoptic(PcOnlinetopic online,String list){
        List<PcOption> options = JSONObject.parseArray(list,PcOption.class);
        for (PcOption obj : options) {
            obj.setOnlineid(online.getOnlineid());
        }
        online.setOptions(options);
        System.out.println(online);
        return topicService.updateOninletop(online).toString();
    }
}
