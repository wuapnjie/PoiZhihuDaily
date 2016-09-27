package com.xiaopo.flying.poizhihudaily.base;

import android.view.View;

/**
 * Created by snowbean on 16-9-10.
 */
public abstract class PoiTypeViewHolder<T extends CellData> extends PoiViewHolder {

    public PoiTypeViewHolder(View itemView) {
        super(itemView);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBind(CellData data) {
        bindCellData((T) data);
    }

    public abstract void bindCellData(T data);
}
