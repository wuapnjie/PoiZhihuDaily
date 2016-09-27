package com.xiaopo.flying.poizhihudaily;

import android.app.Application;

import com.xiaopo.flying.poizhihudaily.model.DaggerDailyRepositoryComponent;
import com.xiaopo.flying.poizhihudaily.model.DailyRepository;
import com.xiaopo.flying.poizhihudaily.model.DailyRepositoryComponent;
import com.xiaopo.flying.poizhihudaily.model.DailyRepositoryModule;

/**
 * Created by snowbean on 16-9-24.
 */
public class DailyApplication extends Application {

    private DailyRepositoryComponent mDailyRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mDailyRepositoryComponent = DaggerDailyRepositoryComponent.builder()
                .dailyRepositoryModule(new DailyRepositoryModule())
                .build();

    }

    public DailyRepositoryComponent getDailyRepositoryComponent() {
        return mDailyRepositoryComponent;
    }

    public DailyRepository getDailyRepository() {
        return mDailyRepositoryComponent.getDailyRepository();
    }
}
