package com.xiaopo.flying.poizhihudaily.model;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by snowbean on 16-9-24.
 */
@Singleton
@Component(modules = DailyRepositoryModule.class)
public interface DailyRepositoryComponent {
    DailyRepository getDailyRepository();
}
