package com.cykj.bean;

// 报告表
public class PcReport {

    private long reportid;
    private long userid;
    private long fieldid;// 领域id
    private String reportresult;// 检测结果
    private String reportcontext;// 报告明细
    private long score;// 得分
    private String createtime;// 创建时间
    private String updatetime;// 修改时间

    public PcReport() {
    }

    public long getFieldid() {
        return fieldid;
    }

    public void setFieldid(long fieldid) {
        this.fieldid = fieldid;
    }

    public PcReport(long reportid, long userid, String reportresult, String reportcontext, String createtime, String updatetime) {
        this.reportid = reportid;
        this.userid = userid;
        this.reportresult = reportresult;
        this.reportcontext = reportcontext;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public long getReportid() {
        return reportid;
    }

    public void setReportid(long reportid) {
        this.reportid = reportid;
    }


    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }


    public String getReportresult() {
        return reportresult;
    }

    public void setReportresult(String reportresult) {
        this.reportresult = reportresult;
    }


    public String getReportcontext() {
        return reportcontext;
    }

    public void setReportcontext(String reportcontext) {
        this.reportcontext = reportcontext;
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
        return "PcReport{" +
                "reportid=" + reportid +
                ", userid=" + userid +
                ", reportresult='" + reportresult + '\'' +
                ", reportcontext='" + reportcontext + '\'' +
                ", createtime='" + createtime + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }
}
