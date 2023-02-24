package com.cykj.bean;

//管理员领域
public class PcAdminField {

    private long afid;
    private long adminid;
    private long fieldid;

    public PcAdminField(long afid, long adminid, long fieldid) {
        this.afid = afid;
        this.adminid = adminid;
        this.fieldid = fieldid;
    }

    public PcAdminField() {
    }

    public long getAfid() {
        return afid;
    }

    public void setAfid(long afid) {
        this.afid = afid;
    }


    public long getAdminid() {
        return adminid;
    }

    public void setAdminid(long adminid) {
        this.adminid = adminid;
    }


    public long getFieldid() {
        return fieldid;
    }

    public void setFieldid(long fieldid) {
        this.fieldid = fieldid;
    }

    @Override
    public String toString() {
        return "PcAdminField{" +
                "afid=" + afid +
                ", adminid=" + adminid +
                ", fieldid=" + fieldid +
                '}';
    }
}
