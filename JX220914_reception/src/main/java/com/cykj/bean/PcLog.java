package com.cykj.bean;

// 日志表
public class PcLog {

    private long logid;
    private long adminid;// 管理员id
    private String logcontext;// 日志明细
    private String createtime;// 创建时间

    public PcLog(long logid, long adminid, String logcontext, String createtime) {
        this.logid = logid;
        this.adminid = adminid;
        this.logcontext = logcontext;
        this.createtime = createtime;
    }

    public PcLog() {
    }

    public long getLogid() {
        return logid;
    }

    public void setLogid(long logid) {
        this.logid = logid;
    }


    public long getAdminid() {
        return adminid;
    }

    public void setAdminid(long adminid) {
        this.adminid = adminid;
    }


    public String getLogcontext() {
        return logcontext;
    }

    public void setLogcontext(String logcontext) {
        this.logcontext = logcontext;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "PcLog{" +
                "logid=" + logid +
                ", adminid=" + adminid +
                ", logcontext='" + logcontext + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
