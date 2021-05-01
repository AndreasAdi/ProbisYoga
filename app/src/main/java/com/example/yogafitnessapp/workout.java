package com.example.yogafitnessapp;

import android.os.Parcel;
import android.os.Parcelable;

public class workout implements  Parcelable{
    String id;
    String nama;
    String desc;
    String time;
    String video;
    String gambar;


    public workout(String id, String nama, String desc, String time, String video, String gambar) {
        this.id = id;
        this.nama = nama;
        this.desc = desc;
        this.time = time;
        this.video = video;
        this.gambar = gambar;
    }

    protected workout(Parcel in) {
        id = in.readString();
        nama = in.readString();
        desc = in.readString();
        time = in.readString();
        video = in.readString();
        gambar = in.readString();
    }

    public static final Creator<workout> CREATOR = new Creator<workout>() {
        @Override
        public workout createFromParcel(Parcel in) {
            return new workout(in);
        }

        @Override
        public workout[] newArray(int size) {
            return new workout[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(nama);
        parcel.writeString(desc);
        parcel.writeString(time);
        parcel.writeString(video);
        parcel.writeString(gambar);
    }
}
