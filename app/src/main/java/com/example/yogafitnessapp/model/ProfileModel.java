package com.example.yogafitnessapp.model;

public class ProfileModel {

    Integer iv_profile;
    String tv_name,tv_city;

    public ProfileModel(Integer iv_profile, String tv_name, String tv_city) {
        this.iv_profile = iv_profile;
        this.tv_name = tv_name;
        this.tv_city = tv_city;
    }

    public Integer getIv_profile() {
        return iv_profile;
    }

    public void setIv_profile(Integer iv_profile) {
        this.iv_profile = iv_profile;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_city() {
        return tv_city;
    }

    public void setTv_city(String tv_city) {
        this.tv_city = tv_city;
    }
}
