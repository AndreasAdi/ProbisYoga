package com.example.yogafitnessapp.model;

public class ProfileModel {

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
}
