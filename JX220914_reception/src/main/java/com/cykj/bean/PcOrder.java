package com.cykj.bean;

// 预约表
public class PcOrder {

    private long orderid;
    private long userid;
    private long fieldid;
    private long adminid;
    private String adminname;
    private String fieldname;
    private long orderstate;//  预约状态 0预约失败 1已预约 2已确认 3已诊断 4已评价 5/15用户已知  5/10管理员已知 20已终止
    private String ordertime;// 预约时间
    private long timeslot;// 时间段
    private String orderproblem;// 预约问题
    private String orderresult;// 预约回复
    private String resulttime;// 回复时间
    private String orderrate;// 预约评价
    private String ratetime;// 评价时间
    private String createtime;// 创建时间
    private String updatetime;// 修改时间
    private String username;//

    public PcOrder() {
    }

    public PcOrder(long userid, long fieldid, long adminid, long orderstate, String ordertime, long timeslot, String orderproblem) {
        this.userid = userid;
        this.fieldid = fieldid;
        this.adminid = adminid;
        this.orderstate = orderstate;
        this.ordertime = ordertime;
        this.timeslot = timeslot;
        this.orderproblem = orderproblem;
    }

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }


    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }


    public long getFieldid() {
        return fieldid;
    }

    public void setFieldid(long fieldid) {
        this.fieldid = fieldid;
    }


    public long getAdminid() {
        return adminid;
    }

    public void setAdminid(long adminid) {
        this.adminid = adminid;
    }


    public long getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(long orderstate) {
        this.orderstate = orderstate;
    }


    public String getOrderproblem() {
        return orderproblem;
    }

    public void setOrderproblem(String orderproblem) {
        this.orderproblem = orderproblem;
    }


    public String getOrderresult() {
        return orderresult;
    }

    public void setOrderresult(String orderresult) {
        this.orderresult = orderresult;
    }


    public String getOrderrate() {
        return orderrate;
    }

    public void setOrderrate(String orderrate) {
        this.orderrate = orderrate;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getResulttime() {
        return resulttime;
    }

    public void setResulttime(String resulttime) {
        this.resulttime = resulttime;
    }

    public String getRatetime() {
        return ratetime;
    }

    public void setRatetime(String ratetime) {
        this.ratetime = ratetime;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public long getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(long timeslot) {
        this.timeslot = timeslot;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "PcOrder{" +
                "orderid=" + orderid +
                ", userid=" + userid +
                ", fieldid=" + fieldid +
                ", adminid=" + adminid +
                ", orderstate=" + orderstate +
                ", ordertime='" + ordertime + '\'' +
                ", timeslot=" + timeslot +
                ", orderproblem='" + orderproblem + '\'' +
                ", orderresult='" + orderresult + '\'' +
                ", resulttime='" + resulttime + '\'' +
                ", orderrate='" + orderrate + '\'' +
                ", ratetime='" + ratetime + '\'' +
                ", createtime='" + createtime + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }
}
