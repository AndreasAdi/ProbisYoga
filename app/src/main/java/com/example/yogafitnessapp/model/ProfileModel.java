package com.example.yogafitnessapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ProfileModel implements Parcelable {

    String gambar;
    String waktu;
    String nama;
    String id;
    String video;

    public ProfileModel(String gambar, String waktu, String nama, String id, String video) {
        this.gambar = gambar;
        this.waktu = waktu;
        this.nama = nama;
        this.id = id;
        this.video = video;
    }

    protected ProfileModel(Parcel in) {
        gambar = in.readString();
        waktu = in.readString();
        nama = in.readString();
        id = in.readString();
        video = in.readString();
    }

    public static final Creator<ProfileModel> CREATOR = new Creator<ProfileModel>() {
        @Override
        public ProfileModel createFromParcel(Parcel in) {
            return new ProfileModel(in);
        }

        @Override
        public ProfileModel[] newArray(int size) {
            return new ProfileModel[size];
        }
    };

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(gambar);
        parcel.writeString(waktu);
        parcel.writeString(nama);
        parcel.writeString(id);
        parcel.writeString(video);
    }
}
