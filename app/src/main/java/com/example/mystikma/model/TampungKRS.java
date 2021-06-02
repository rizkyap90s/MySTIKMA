package com.example.mystikma.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TampungKRS implements Parcelable {
    private String cekkrs;
    private String matkulkrs;
    private String skskrs;
    private String baruulang;



    public TampungKRS(String matkulkrs, String skskrs, String baruulang) {
        this.matkulkrs = matkulkrs;
        this.skskrs = skskrs;
        this.baruulang = baruulang;
    }

    public TampungKRS() {

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

    public TampungKRS(Parcel in) {
        cekkrs = in.readString();
        matkulkrs = in.readString();
        skskrs = in.readString();
        baruulang = in.readString();
    }

    public static final Creator<TampungKRS> CREATOR = new Creator<TampungKRS>() {
        @Override
        public TampungKRS createFromParcel(Parcel in) {
            return new TampungKRS(in);
        }

        @Override
        public TampungKRS[] newArray(int size) {
            return new TampungKRS[size];
        }
    };

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
