package com.xiaopo.flying.poizhihudaily.model.entity;

/**
 * Created by snowbean on 16-9-25.
 */
public class TopStory extends Story{
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int getDataBindingLayout() {
        return 0;
    }
}
