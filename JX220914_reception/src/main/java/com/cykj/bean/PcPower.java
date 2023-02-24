package com.cykj.bean;

// 权限
public class PcPower {

    private long powerid;
    private String powername; // 权限名称
    private String powerurl; // 权限路径
    private long prowerparent;// 父级id

    public PcPower(long powerid, String powername, String powerurl, long prowerparent) {
        this.powerid = powerid;
        this.powername = powername;
        this.powerurl = powerurl;
        this.prowerparent = prowerparent;
    }

    public PcPower() {
    }

    public long getPowerid() {
        return powerid;
    }

    public void setPowerid(long powerid) {
        this.powerid = powerid;
    }


    public String getPowername() {
        return powername;
    }

    public void setPowername(String powername) {
        this.powername = powername;
    }


    public String getPowerurl() {
        return powerurl;
    }

    public void setPowerurl(String powerurl) {
        this.powerurl = powerurl;
    }


    public long getProwerparent() {
        return prowerparent;
    }

    public void setProwerparent(long prowerparent) {
        this.prowerparent = prowerparent;
    }

    @Override
    public String toString() {
        return "PcPower{" +
                "powerid=" + powerid +
                ", powername='" + powername + '\'' +
                ", powerurl='" + powerurl + '\'' +
                ", prowerparent=" + prowerparent +
                '}';
    }
}
