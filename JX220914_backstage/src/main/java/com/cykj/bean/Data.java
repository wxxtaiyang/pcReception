package com.cykj.bean;

public class Data {
    private String timename;
    private int counts;

    public Data() {
    }

    public Data(String timename, int counts) {
        this.timename = timename;
        this.counts = counts;
    }

    public String getTimename() {
        return timename;
    }

    public void setTimename(String timename) {
        this.timename = timename;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }
}
