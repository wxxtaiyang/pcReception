package com.cykj.bean;

// 用户账单明细
public class PcAccount {

    private long accountid;
    private long userid;
    private long adminid;
    private String accounttime; //账单时间
    private String accountevent;// 发生事项
    private long accountsort; // 账单分类 1充值 0花费
    private double accountprice;// 账单金额

    public PcAccount() {
    }

    public PcAccount(long accountid, long userid, long adminid, String accounttime, String accountevent, long accountsort, double accountprice) {
        this.accountid = accountid;
        this.userid = userid;
        this.adminid = adminid;
        this.accounttime = accounttime;
        this.accountevent = accountevent;
        this.accountsort = accountsort;
        this.accountprice = accountprice;
    }

    public long getAccountid() {
        return accountid;
    }

    public void setAccountid(long accountid) {
        this.accountid = accountid;
    }


    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }


    public long getAdminid() {
        return adminid;
    }

    public void setAdminid(long adminid) {
        this.adminid = adminid;
    }


    public String getAccounttime() {
        return accounttime;
    }

    public void setAccounttime(String accounttime) {
        this.accounttime = accounttime;
    }

    public String getAccountevent() {
        return accountevent;
    }

    public void setAccountevent(String accountevent) {
        this.accountevent = accountevent;
    }


    public long getAccountsort() {
        return accountsort;
    }

    public void setAccountsort(long accountsort) {
        this.accountsort = accountsort;
    }


    public double getAccountprice() {
        return accountprice;
    }

    public void setAccountprice(double accountprice) {
        this.accountprice = accountprice;
    }

    @Override
    public String toString() {
        return "PcAccount{" +
                "accountid=" + accountid +
                ", userid=" + userid +
                ", adminid=" + adminid +
                ", accounttime='" + accounttime + '\'' +
                ", accountevent='" + accountevent + '\'' +
                ", accountsort=" + accountsort +
                ", accountprice=" + accountprice +
                '}';
    }
}
