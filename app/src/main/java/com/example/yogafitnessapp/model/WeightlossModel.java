package com.example.yogafitnessapp.model;

public class WeightlossModel {

    Integer iv_weightloss;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    String nama;

    public WeightlossModel(Integer iv_weightloss, String nama) {
        this.iv_weightloss = iv_weightloss;
        this.nama = nama;
    }

    public Integer getIv_weightloss() {
        return iv_weightloss;
    }

    public void setIv_weightloss(Integer iv_weightloss) {
        this.iv_weightloss = iv_weightloss;
    }
}
