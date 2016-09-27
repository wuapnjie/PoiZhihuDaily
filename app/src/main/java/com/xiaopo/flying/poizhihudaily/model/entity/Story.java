package com.xiaopo.flying.poizhihudaily.model.entity;


import android.widget.TextView;

import com.xiaopo.flying.poizhihudaily.R;
import com.xiaopo.flying.poizhihudaily.base.CellData;

import java.util.List;

import butterknife.BindView;

/**
 * Created by snowbean on 16-9-25.
 */
public class Story implements CellData {

    private String title;
    private String ga_prefix;
    private List<String> images;
    private int type;
    private long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int getDataBindingLayout() {
        return R.layout.item_story;
    }
}
