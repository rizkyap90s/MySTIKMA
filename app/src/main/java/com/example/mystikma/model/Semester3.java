package com.example.mystikma.model;

public class Semester3 {
    private String cekkrs;
    private String matkulkrs;
    private String skskrs;
    private String baruulang;

    public Semester3(String cekkrs, String matkulkrs, String skskrs, String baruulang) {
        this.cekkrs = cekkrs;
        this.matkulkrs = matkulkrs;
        this.skskrs = skskrs;
        this.baruulang = baruulang;
    }

    public String getCekkrs() {
        return cekkrs;
    }

    public void setCekkrs(String cekkrs) {
        this.cekkrs = cekkrs;
    }

    public String getMatkulkrs() {
        return matkulkrs;
    }

    public void setMatkulkrs(String matkulkrs) {
        this.matkulkrs = matkulkrs;
    }

    public String getSkskrs() {
        return skskrs;
    }

    public void setSkskrs(String skskrs) {
        this.skskrs = skskrs;
    }

    public String getBaruulang() {
        return baruulang;
    }

    public void setBaruulang(String baruulang) {
        this.baruulang = baruulang;
    }
}
