package com.dinda.myrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class SekolahIkatanDinas implements Parcelable {
    private String name, remarks, photo, penjelasan;

    public String getPenjelasan() {
        return penjelasan;
    }
    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.remarks);
        dest.writeString(this.photo);
        dest.writeString(this.penjelasan);
    }

    public SekolahIkatanDinas() {
    }

    protected SekolahIkatanDinas(Parcel in) {
        this.name = in.readString();
        this.remarks = in.readString();
        this.photo = in.readString();
        this.penjelasan = in.readString();
    }
    public static final Parcelable.Creator<SekolahIkatanDinas> CREATOR = new Parcelable.Creator<SekolahIkatanDinas>() {
        @Override
        public SekolahIkatanDinas createFromParcel(Parcel source) {
            return new SekolahIkatanDinas(source);
        }

        @Override
        public SekolahIkatanDinas[] newArray(int size) {
            return new SekolahIkatanDinas [size];
        }
    };
}
