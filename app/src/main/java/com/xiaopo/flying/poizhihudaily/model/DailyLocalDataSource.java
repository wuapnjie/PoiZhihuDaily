package com.xiaopo.flying.poizhihudaily.model;

import com.xiaopo.flying.poizhihudaily.model.entity.DailyNews;

import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by snowbean on 16-9-24.
 */

@Singleton
public class DailyLocalDataSource implements DailyDataSource{
    public DailyLocalDataSource(){

    }

    @Override
    public Observable<DailyNews> fetchLatestDailyNews() {
        return null;
    }
}
