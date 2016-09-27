package com.xiaopo.flying.poizhihudaily.ui.daily;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xiaopo.flying.poizhihudaily.R;
import com.xiaopo.flying.poizhihudaily.base.PoiAdapter;
import com.xiaopo.flying.poizhihudaily.base.PoiTypeViewHolder;
import com.xiaopo.flying.poizhihudaily.base.PoiViewHolder;
import com.xiaopo.flying.poizhihudaily.model.entity.DailyNews;
import com.xiaopo.flying.poizhihudaily.model.entity.Story;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by snowbean on 16-9-24.
 */
public class StoryAdapter extends PoiAdapter {

    @Override
    protected PoiViewHolder createCell(View itemView, int viewType) {
        return new Cell(itemView);
    }

    public static class Cell extends PoiTypeViewHolder<Story> {

        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.iv_pic)
        ImageView mIvPic;

        public Cell(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindCellData(Story data) {
            mTvTitle.setText(data.getTitle());
            Picasso.with(context())
                    .load(data.getImages().get(0))
                    .fit()
                    .centerInside()
                    .into(mIvPic);
        }
    }
}
