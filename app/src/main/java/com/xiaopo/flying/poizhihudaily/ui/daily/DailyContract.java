package com.xiaopo.flying.poizhihudaily.ui.daily;

import com.xiaopo.flying.poizhihudaily.base.CellData;
import com.xiaopo.flying.poizhihudaily.base.PoiPresenter;
import com.xiaopo.flying.poizhihudaily.base.PoiView;
import com.xiaopo.flying.poizhihudaily.model.entity.Story;

import java.util.List;

/**
 * Created by snowbean on 16-9-24.
 */

public interface DailyContract {
    interface Presenter extends PoiPresenter {
        void fetchLatestDailyNews();
    }

    interface View extends PoiView<Presenter> {
        void refreshDailyStory(List<CellData> stories);
    }

}
