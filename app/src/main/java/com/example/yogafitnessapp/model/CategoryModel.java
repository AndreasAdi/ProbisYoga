package com.example.yogafitnessapp.model;

public class CategoryModel {

    String tv_week,tv_trial,tv_yoga,tv_level;

    Integer iv_yoga;

    public CategoryModel(String tv_week, String tv_trial, String tv_yoga, String tv_level, Integer iv_yoga) {
        this.tv_week = tv_week;
        this.tv_trial = tv_trial;
        this.tv_yoga = tv_yoga;
        this.tv_level = tv_level;
        this.iv_yoga = iv_yoga;
    }

    public String getTv_week() {
        return tv_week;
    }

    public void setTv_week(String tv_week) {
        this.tv_week = tv_week;
    }

    public String getTv_trial() {
        return tv_trial;
    }

    public void setTv_trial(String tv_trial) {
        this.tv_trial = tv_trial;
    }

    public String getTv_yoga() {
        return tv_yoga;
    }

    public void setTv_yoga(String tv_yoga) {
        this.tv_yoga = tv_yoga;
    }

    public String getTv_level() {
        return tv_level;
    }

    public void setTv_level(String tv_level) {
        this.tv_level = tv_level;
    }

    public Integer getIv_yoga() {
        return iv_yoga;
    }

    public void setIv_yoga(Integer iv_yoga) {
        this.iv_yoga = iv_yoga;
    }
}
