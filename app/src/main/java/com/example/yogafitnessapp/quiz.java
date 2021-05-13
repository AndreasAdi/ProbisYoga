package com.example.yogafitnessapp;

public class quiz {

    String pertanyaan;
    String gambar;
    String jawaban;
    String pilihan_a;
    String pilihan_b;
    String pilihan_c;
    String pilihan_d;

    public quiz(String pertanyaan, String gambar, String jawaban, String pilihan_a, String pilihan_b, String pilihan_c, String pilihan_d) {
        this.pertanyaan = pertanyaan;
        this.gambar = gambar;
        this.jawaban = jawaban;
        this.pilihan_a = pilihan_a;
        this.pilihan_b = pilihan_b;
        this.pilihan_c = pilihan_c;
        this.pilihan_d = pilihan_d;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    public String getPilihan_a() {
        return pilihan_a;
    }

    public void setPilihan_a(String pilihan_a) {
        this.pilihan_a = pilihan_a;
    }

    public String getPilihan_b() {
        return pilihan_b;
    }

    public void setPilihan_b(String pilihan_b) {
        this.pilihan_b = pilihan_b;
    }

    public String getPilihan_c() {
        return pilihan_c;
    }

    public void setPilihan_c(String pilihan_c) {
        this.pilihan_c = pilihan_c;
    }

    public String getPilihan_d() {
        return pilihan_d;
    }

    public void setPilihan_d(String pilihan_d) {
        this.pilihan_d = pilihan_d;
    }
}
