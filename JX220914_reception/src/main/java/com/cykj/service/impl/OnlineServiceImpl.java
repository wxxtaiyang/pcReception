package com.cykj.service.impl;

import com.cykj.bean.PcOnlinetopic;
import com.cykj.mapper.OnlineMapper;
import com.cykj.service.OnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OnlineServiceImpl implements OnlineService {
    @Autowired
    private OnlineMapper onlineMapper;
    @Override
    public List<PcOnlinetopic> queryAllOnlinetopicByFieldId(long fieldid) {
        List<PcOnlinetopic> oldlist = onlineMapper.queryOnlineByField(fieldid);
        List<PcOnlinetopic> newList = new ArrayList<>();
        if(oldlist.size() > 10){
            Random rd = new Random();
            for (int i = 0; i < 10; i++) {
                int j = rd.nextInt(oldlist.size());
                newList.add(oldlist.remove(j));
            }
        }else{
            newList = oldlist;
        }
        return newList;
    }
}
