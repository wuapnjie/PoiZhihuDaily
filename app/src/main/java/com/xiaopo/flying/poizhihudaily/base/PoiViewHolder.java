package com.xiaopo.flying.poizhihudaily.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by snowbean on 16-9-10.
 */
public abstract class PoiViewHolder extends RecyclerView.ViewHolder {

    public PoiViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public abstract void onBind(CellData data);

    protected Context context() {
        return itemView.getContext();
    }

}
