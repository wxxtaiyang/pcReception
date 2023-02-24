package com.cykj.bean;

// 角色权限表
public class PcRolePower {

    private long rpid;
    private long roleid;
    private long powerid;

    public PcRolePower() {
    }

    public PcRolePower(long rpid, long roleid, long powerid) {
        this.rpid = rpid;
        this.roleid = roleid;
        this.powerid = powerid;
    }

    public long getRpid() {
        return rpid;
    }

    public void setRpid(long rpid) {
        this.rpid = rpid;
    }


    public long getRoleid() {
        return roleid;
    }

    public void setRoleid(long roleid) {
        this.roleid = roleid;
    }


    public long getPowerid() {
        return powerid;
    }

    public void setPowerid(long powerid) {
        this.powerid = powerid;
    }

    @Override
    public String toString() {
        return "PcRolePower{" +
                "rpid=" + rpid +
                ", roleid=" + roleid +
                ", powerid=" + powerid +
                '}';
    }
}
