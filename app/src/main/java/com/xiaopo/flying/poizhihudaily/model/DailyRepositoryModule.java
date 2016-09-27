package com.xiaopo.flying.poizhihudaily.model;

import com.xiaopo.flying.poizhihudaily.model.DailyLocalDataSource;
import com.xiaopo.flying.poizhihudaily.model.DailyRemoteDataSource;
import com.xiaopo.flying.poizhihudaily.model.DailyRepository;
import com.xiaopo.flying.poizhihudaily.model.Local;
import com.xiaopo.flying.poizhihudaily.model.Remote;

import java.lang.annotation.Retention;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by snowbean on 16-9-24.
 */

@Module
public class DailyRepositoryModule {

    @Singleton
    @Provides
    @Local
    DailyLocalDataSource provideDailyLocalDataSource() {
        return new DailyLocalDataSource();
    }

    @Singleton
    @Provides
    @Remote
    DailyRemoteDataSource provideDailyRemoteDataSource(){
        return new DailyRemoteDataSource();
    }
}
