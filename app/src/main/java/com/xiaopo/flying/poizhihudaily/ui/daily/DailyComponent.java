package com.xiaopo.flying.poizhihudaily.ui.daily;

import com.xiaopo.flying.poizhihudaily.FragmentScope;
import com.xiaopo.flying.poizhihudaily.model.DailyRepositoryComponent;

import dagger.Component;

/**
 * Created by snowbean on 16-9-24.
 */
@FragmentScope
@Component(dependencies = DailyRepositoryComponent.class, modules = DailyModule.class)
public interface DailyComponent {
    void inject(DailyActivity activity);
}
