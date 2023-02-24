package com.cykj.bean;

// 管理员表
public class PcAdmin {

    private long adminid;
    private long roleid;
    private String rolename;
    private String adminname;
    private String adminacc;
    private String adminpwd;
    private long adminstate; // 管理员状态 1正常 0冻结
    private String adminimg;// 管理员头像
    private String socialcontext; // 专业背景
    private String adminschool; // 毕业院校(所在公司)
    private String admintitle; // 职称
    private double adminprice; // 服务价格
    private double adminbalance; // 账户余额
    private long isdelete;// 假删除 0为删除 1为正常

    public PcAdmin() {
    }


    public PcAdmin(long adminid, long roleid, String rolename, String adminname, String adminacc, String adminpwd, long adminstate, String adminimg, String socialcontext, String adminschool, String admintitle, double adminprice, double adminbalance, long isdelete) {
        this.adminid = adminid;
        this.roleid = roleid;
        this.rolename = rolename;
        this.adminname = adminname;
        this.adminacc = adminacc;
        this.adminpwd = adminpwd;
        this.adminstate = adminstate;
        this.adminimg = adminimg;
        this.socialcontext = socialcontext;
        this.adminschool = adminschool;
        this.admintitle = admintitle;
        this.adminprice = adminprice;
        this.adminbalance = adminbalance;
        this.isdelete = isdelete;
    }

    public long getAdminid() {
        return adminid;
    }

    public void setAdminid(long adminid) {
        this.adminid = adminid;
    }

    public long getRoleid() {
        return roleid;
    }

    public void setRoleid(long roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminacc() {
        return adminacc;
    }

    public void setAdminacc(String adminacc) {
        this.adminacc = adminacc;
    }

    public String getAdminpwd() {
        return adminpwd;
    }

    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd;
    }

    public long getAdminstate() {
        return adminstate;
    }

    public void setAdminstate(long adminstate) {
        this.adminstate = adminstate;
    }

    public String getAdminimg() {
        return adminimg;
    }

    public void setAdminimg(String adminimg) {
        this.adminimg = adminimg;
    }

    public String getSocialcontext() {
        return socialcontext;
    }

    public void setSocialcontext(String socialcontext) {
        this.socialcontext = socialcontext;
    }

    public String getAdminschool() {
        return adminschool;
    }

    public void setAdminschool(String adminschool) {
        this.adminschool = adminschool;
    }

    public String getAdmintitle() {
        return admintitle;
    }

    public void setAdmintitle(String admintitle) {
        this.admintitle = admintitle;
    }

    public double getAdminprice() {
        return adminprice;
    }

    public void setAdminprice(double adminprice) {
        this.adminprice = adminprice;
    }

    public long getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(long isdelete) {
        this.isdelete = isdelete;
    }

    public double getAdminbalance() {
        return adminbalance;
    }

    public void setAdminbalance(double adminbalance) {
        this.adminbalance = adminbalance;
    }

    @Override
    public String toString() {
        return "PcAdmin{" +
                "adminid=" + adminid +
                ", roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", adminname='" + adminname + '\'' +
                ", adminacc='" + adminacc + '\'' +
                ", adminpwd='" + adminpwd + '\'' +
                ", adminstate=" + adminstate +
                ", adminimg='" + adminimg + '\'' +
                ", socialcontext='" + socialcontext + '\'' +
                ", adminschool='" + adminschool + '\'' +
                ", admintitle='" + admintitle + '\'' +
                ", adminprice=" + adminprice +
                ", adminbalance=" + adminbalance +
                ", isdelete=" + isdelete +
                '}';
    }
}
