package com.cykj.bean;

// 咨询师预约时间表
public class PcOrdertime {

    private long ordertimeid;
    private long adminid;
    private String ordertimedate; // 日期
    private long ordertimeint;// 时间段 1八点 2九点 3十点 4十一点 5两点 6三点 7四点 8五点
    private long orderstate; //时间段状态 1可预约 2不可预约


    public long getOrdertimeid() {
        return ordertimeid;
    }

    public void setOrdertimeid(long ordertimeid) {
        this.ordertimeid = ordertimeid;
    }


    public long getAdminid() {
        return adminid;
    }

    public void setAdminid(long adminid) {
        this.adminid = adminid;
    }

    public String getOrdertimedate() {
        return ordertimedate;
    }

    public void setOrdertimedate(String ordertimedate) {
        this.ordertimedate = ordertimedate;
    }

    public long getOrdertimeint() {
        return ordertimeint;
    }

    public void setOrdertimeint(long ordertimeint) {
        this.ordertimeint = ordertimeint;
    }

    public long getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(long orderstate) {
        this.orderstate = orderstate;
    }

    @Override
    public String toString() {
        return "PcOrdertime{" +
                "ordertimeid=" + ordertimeid +
                ", adminid=" + adminid +
                ", ordertimedate='" + ordertimedate + '\'' +
                ", ordertimeint=" + ordertimeint +
                '}';
    }
}
