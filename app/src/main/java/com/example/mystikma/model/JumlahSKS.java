package com.example.mystikma.model;

import android.os.Parcel;
import android.os.Parcelable;

public class JumlahSKS implements Parcelable {
    public JumlahSKS(int jumlahKRS) {
        this.jumlahKRS = jumlahKRS;
    }

    private int jumlahKRS = 0;

    protected JumlahSKS(Parcel in) {
        jumlahKRS = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(jumlahKRS);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<JumlahSKS> CREATOR = new Creator<JumlahSKS>() {
        @Override
        public JumlahSKS createFromParcel(Parcel in) {
            return new JumlahSKS(in);
        }

        @Override
        public JumlahSKS[] newArray(int size) {
            return new JumlahSKS[size];
        }
    };

    public int getJumlahKRS() {
        return jumlahKRS;
    }

    public void setJumlahKRS(int jumlahKRS) {
        this.jumlahKRS = jumlahKRS;
    }
}
