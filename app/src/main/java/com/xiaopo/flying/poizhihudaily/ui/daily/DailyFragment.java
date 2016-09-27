package com.xiaopo.flying.poizhihudaily.ui.daily;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaopo.flying.poizhihudaily.R;
import com.xiaopo.flying.poizhihudaily.base.CellData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by snowbean on 16-9-24.
 */
public class DailyFragment extends Fragment implements DailyContract.View {

    @BindView(R.id.daily_news_list)
    RecyclerView mDailyNewsList;

    private DailyPresenter mPresenter;
    private StoryAdapter mStoryAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mDailyNewsList.setLayoutManager(new LinearLayoutManager(getContext()));
        mStoryAdapter = new StoryAdapter();
        mDailyNewsList.setAdapter(mStoryAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.start();
        }
    }

    @Override
    public void setPresenter(DailyContract.Presenter presenter) {
        mPresenter = (DailyPresenter) presenter;
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.end();
        }
    }

    @Override
    public void refreshDailyStory(List<CellData> stories) {
        mStoryAdapter.refreshData(stories);
    }
}
