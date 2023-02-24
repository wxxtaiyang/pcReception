package com.cykj.bean;

// 领域表
public class PcField {

    private long fieldid;
    private String fieldname; // 领域名称
    private String createtime;// 创建时间
    private String updatetime;// 修改时间

    public PcField(long fieldid, String fieldname, String createtime, String updatetime) {
        this.fieldid = fieldid;
        this.fieldname = fieldname;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public PcField() {
    }

    public long getFieldid() {
        return fieldid;
    }

    public void setFieldid(long fieldid) {
        this.fieldid = fieldid;
    }


    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
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

    @Override
    public String toString() {
        return "PcField{" +
                "fieldid=" + fieldid +
                ", fieldname='" + fieldname + '\'' +
                ", createtime='" + createtime + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }
}
