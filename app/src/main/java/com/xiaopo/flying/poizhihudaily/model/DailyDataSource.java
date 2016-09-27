package com.xiaopo.flying.poizhihudaily.model;

import com.xiaopo.flying.poizhihudaily.model.entity.DailyNews;

import io.reactivex.Observable;

/**
 * Created by snowbean on 16-9-24.
 */

public interface DailyDataSource {
    @Remote
    Observable<DailyNews> fetchLatestDailyNews();
}
