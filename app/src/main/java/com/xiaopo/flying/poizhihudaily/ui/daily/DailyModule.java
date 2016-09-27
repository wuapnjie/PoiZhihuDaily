package com.xiaopo.flying.poizhihudaily.ui.daily;

import dagger.Module;
import dagger.Provides;

/**
 * Created by snowbean on 16-9-24.
 */
@Module
public class DailyModule {
    private final DailyContract.View mView;


    public DailyModule(DailyContract.View view) {
        mView = view;
    }

    @Provides
    DailyContract.View provideDailyView() {
        return mView;
    }
}
