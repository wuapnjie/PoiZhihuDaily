package com.xiaopo.flying.poizhihudaily.ui.daily;

import com.xiaopo.flying.poizhihudaily.base.CellData;
import com.xiaopo.flying.poizhihudaily.base.PoiObserver;
import com.xiaopo.flying.poizhihudaily.model.DailyRepository;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Created by snowbean on 16-9-24.
 */
public class DailyPresenter extends PoiObserver implements DailyContract.Presenter {
    private final DailyRepository mDailyRepository;
    private final DailyContract.View mView;

    @Inject
    public DailyPresenter(DailyRepository repository, DailyContract.View view) {
        mDailyRepository = repository;
        mView = view;
    }

    @Inject
    void setListener() {
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        fetchLatestDailyNews();
    }

    @Override
    public void fetchLatestDailyNews() {
        Disposable disposable = mDailyRepository.fetchLatestDailyNews()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(dailyNews -> {
                    Disposable dis = Observable.fromIterable(dailyNews.getStories())
                            .map(story -> (CellData) story)
                            .toList()
                            .subscribe(mView::refreshDailyStory, mView::handleError);

                    addDisposable(dis);
                });

        addDisposable(disposable);
    }
}
