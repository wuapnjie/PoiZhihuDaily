package com.xiaopo.flying.poizhihudaily.model;

import com.xiaopo.flying.poizhihudaily.model.entity.DailyNews;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by snowbean on 16-9-24.
 */

@Singleton
public class DailyRepository implements DailyDataSource {
    private final DailyLocalDataSource mDailyLocalDataSource;
    private final DailyRemoteDataSource mDailyRemoteDataSource;

    @Inject
    public DailyRepository(@Local DailyLocalDataSource dailyLocalDataSource, @Remote DailyRemoteDataSource dailyRemoteDataSource) {
        mDailyLocalDataSource = dailyLocalDataSource;
        mDailyRemoteDataSource = dailyRemoteDataSource;
    }

    @Remote
    @Override
    public Observable<DailyNews> fetchLatestDailyNews() {
        return mDailyRemoteDataSource.fetchLatestDailyNews();
    }
}
