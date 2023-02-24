package com.cykj.bean;

// 题目选项表
public class PcOption {

    private long optionid;
    private long onlineid; // 题目id
    private String optioncontext;// 选项内容
    private long optionscore;// 选项得分

    public PcOption() {
    }

    public PcOption(long optionid, long onlineid, String optioncontext, long optionscore) {
        this.optionid = optionid;
        this.onlineid = onlineid;
        this.optioncontext = optioncontext;
        this.optionscore = optionscore;
    }

    public long getOptionid() {
        return optionid;
    }

    public void setOptionid(long optionid) {
        this.optionid = optionid;
    }


    public long getOnlineid() {
        return onlineid;
    }

    public void setOnlineid(long onlineid) {
        this.onlineid = onlineid;
    }


    public String getOptioncontext() {
        return optioncontext;
    }

    public void setOptioncontext(String optioncontext) {
        this.optioncontext = optioncontext;
    }


    public long getOptionscore() {
        return optionscore;
    }

    public void setOptionscore(long optionscore) {
        this.optionscore = optionscore;
    }

    @Override
    public String toString() {
        return "PcOption{" +
                "optionid=" + optionid +
                ", onlineid=" + onlineid +
                ", optioncontext='" + optioncontext + '\'' +
                ", optionscore=" + optionscore +
                '}';
    }
}
