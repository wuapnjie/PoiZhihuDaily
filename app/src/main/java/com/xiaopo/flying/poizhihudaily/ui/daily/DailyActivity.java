package com.xiaopo.flying.poizhihudaily.ui.daily;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xiaopo.flying.poizhihudaily.DailyApplication;
import com.xiaopo.flying.poizhihudaily.R;
import com.xiaopo.flying.poizhihudaily.ui.BaseActivity;
import com.xiaopo.flying.poizhihudaily.util.ActivityUtil;

import javax.inject.Inject;

/**
 * Created by snowbean on 16-9-24.
 */
public class DailyActivity extends BaseActivity {
    private static final String TAG = "DailyActivity";

    @Inject
    DailyPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        DailyFragment fragment = (DailyFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new DailyFragment();
            ActivityUtil.addFragmentToActivity(getSupportFragmentManager(),
                    fragment,
                    R.id.fragment_container);
        }

        DaggerDailyComponent.builder()
                .dailyModule(new DailyModule(fragment))
                .dailyRepositoryComponent(((DailyApplication) getApplication()).getDailyRepositoryComponent())
                .build()
                .inject(this);

    }
}
