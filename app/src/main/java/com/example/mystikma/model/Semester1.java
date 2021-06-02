package com.example.mystikma.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Semester1 implements Parcelable {

    private String cekkrs;
    private String matkulkrs;
    private String skskrs;
    private String baruulang;

    public Semester1(String cekkrs, String matkulkrs, String skskrs, String baruulang) {
        this.cekkrs = cekkrs;
        this.matkulkrs = matkulkrs;
        this.skskrs = skskrs;
        this.baruulang = baruulang;
    }

    protected Semester1(Parcel in) {
        cekkrs = in.readString();
        matkulkrs = in.readString();
        skskrs = in.readString();
        baruulang = in.readString();
    }

    public static final Creator<Semester1> CREATOR = new Creator<Semester1>() {
        @Override
        public Semester1 createFromParcel(Parcel in) {
            return new Semester1(in);
        }

        @Override
        public Semester1[] newArray(int size) {
            return new Semester1[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cekkrs);
        dest.writeString(matkulkrs);
        dest.writeString(skskrs);
        dest.writeString(baruulang);
    }
}
