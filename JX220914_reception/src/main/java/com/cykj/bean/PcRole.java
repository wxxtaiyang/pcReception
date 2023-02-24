package com.cykj.bean;

// 角色表
public class PcRole {

    private long roleid;
    private String rolename;

    public PcRole() {
    }

    public PcRole(long roleid, String rolename) {
        this.roleid = roleid;
        this.rolename = rolename;
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

    @Override
    public String toString() {
        return "PcRole{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
