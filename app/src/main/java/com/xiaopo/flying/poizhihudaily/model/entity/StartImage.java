package com.xiaopo.flying.poizhihudaily.model.entity;

import com.xiaopo.flying.poizhihudaily.base.CellData;

/**
 * Created by snowbean on 16-9-24.
 */
public class StartImage implements CellData {
    private String text;
    private String img;

    @Override
    public int getDataBindingLayout() {
        return 0;
    }

    public StartImage(String text, String img) {
        this.text = text;
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
