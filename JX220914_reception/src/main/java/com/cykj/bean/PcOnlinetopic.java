package com.cykj.bean;

import java.util.List;

// 在线评估题目
public class PcOnlinetopic {

    private long onlineid;
    private long fieldid; // 领域id
    private String onlinecontext;  //题目内容
    private List<PcOption> options;// 选项

    public PcOnlinetopic(long onlineid, long fieldid, String onlinecontext) {
        this.onlineid = onlineid;
        this.fieldid = fieldid;
        this.onlinecontext = onlinecontext;
    }

    public PcOnlinetopic() {
    }

    public long getOnlineid() {
        return onlineid;
    }

    public void setOnlineid(long onlineid) {
        this.onlineid = onlineid;
    }


    public long getFieldid() {
        return fieldid;
    }

    public void setFieldid(long fieldid) {
        this.fieldid = fieldid;
    }


    public String getOnlinecontext() {
        return onlinecontext;
    }

    public void setOnlinecontext(String onlinecontext) {
        this.onlinecontext = onlinecontext;
    }

    public List<PcOption> getOptions() {
        return options;
    }

    public void setOptions(List<PcOption> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "PcOnlinetopic{" +
                "onlineid=" + onlineid +
                ", fieldid=" + fieldid +
                ", onlinecontext='" + onlinecontext + '\'' +
                ", options=" + options +
                '}';
    }
}
