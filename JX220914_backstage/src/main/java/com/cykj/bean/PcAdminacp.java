package com.cykj.bean;

// 咨询师资金账户明细
public class PcAdminacp {

    private long capid;
    private long adminid;
    private String adminname;
    private long userid;
    private String username;
    private String createtime; // 发生时间
    private long capsort; // 资金类别 1咨询 0预约
    private double capprice;// 金额大小

    public PcAdminacp() {
    }

    public PcAdminacp(long capid, long adminid, String adminname, long userid, String username, String createtime, long capsort, double capprice) {
        this.capid = capid;
        this.adminid = adminid;
        this.adminname = adminname;
        this.userid = userid;
        this.username = username;
        this.createtime = createtime;
        this.capsort = capsort;
        this.capprice = capprice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getCapid() {
        return capid;
    }

    public void setCapid(long capid) {
        this.capid = capid;
    }


    public long getAdminid() {
        return adminid;
    }

    public void setAdminid(long adminid) {
        this.adminid = adminid;
    }


    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public long getCapsort() {
        return capsort;
    }

    public void setCapsort(long capsort) {
        this.capsort = capsort;
    }


    public double getCapprice() {
        return capprice;
    }

    public void setCapprice(double capprice) {
        this.capprice = capprice;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    @Override
    public String toString() {
        return "PcAdminacp{" +
                "capid=" + capid +
                ", adminid=" + adminid +
                ", userid=" + userid +
                ", createtime='" + createtime + '\'' +
                ", capsort=" + capsort +
                ", capprice=" + capprice +
                '}';
    }
}
