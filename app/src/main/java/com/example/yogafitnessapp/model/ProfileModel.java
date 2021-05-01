package com.example.yogafitnessapp.model;

public class ProfileModel {

    String gambar;
    String waktu;
    String nama;

    public ProfileModel(String gambar, String waktu, String nama) {
        this.gambar = gambar;
        this.waktu = waktu;
        this.nama = nama;
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
}
