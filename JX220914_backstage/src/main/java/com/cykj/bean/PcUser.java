package com.cykj.bean;

// 前端用户
public class PcUser {

    private long userid;
    private String username; // 用户昵称
    private String useracc; //
    private String userpwd;
    private long usersex; // 性别 1男 0女
    private long userage;
    private String userphone;
    private String address;
    private double balance; // 余额
    private long state; // 状态 1正常 0冻结
    private String createtime; // 创建时间
    private long isdelete; // 假删除 0为删除 1为正常

    public PcUser() {
    }


    public PcUser(long userid, String username, String useracc, String userpwd, long usersex, long userage, String userphone, String address, double balance, long state, String createtime, long isdelete) {
        this.userid = userid;
        this.username = username;
        this.useracc = useracc;
        this.userpwd = userpwd;
        this.usersex = usersex;
        this.userage = userage;
        this.userphone = userphone;
        this.address = address;
        this.balance = balance;
        this.state = state;
        this.createtime = createtime;
        this.isdelete = isdelete;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }


    public String getUseracc() {
        return useracc;
    }

    public void setUseracc(String useracc) {
        this.useracc = useracc;
    }


    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }


    public long getUsersex() {
        return usersex;
    }

    public void setUsersex(long usersex) {
        this.usersex = usersex;
    }


    public long getUserage() {
        return userage;
    }

    public void setUserage(long userage) {
        this.userage = userage;
    }


    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public long getState() {
        return state;
    }

    public void setState(long state) {
        this.state = state;
    }


    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public long getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(long isdelete) {
        this.isdelete = isdelete;
    }

    @Override
    public String toString() {
        return "PcUser{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", useracc='" + useracc + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", usersex=" + usersex +
                ", userage=" + userage +
                ", userphone='" + userphone + '\'' +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", state=" + state +
                ", createtime='" + createtime + '\'' +
                ", isdelete=" + isdelete +
                '}';
    }
}
