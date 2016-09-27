package com.xiaopo.flying.poizhihudaily.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by snowbean on 16-9-11.
 */
public abstract class PoiObserver implements PoiPresenter {

    private CompositeDisposable mCompositeDisposable;

    protected void addDisposable(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    protected void removeDisposable(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }

        mCompositeDisposable.remove(disposable);
    }

    protected void dispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
            mCompositeDisposable = null;
        }

    }

    public CompositeDisposable getCompositeDisposable() {
        if (this.mCompositeDisposable == null) {
            this.mCompositeDisposable = new CompositeDisposable();
        }

        return this.mCompositeDisposable;
    }

    @Override
    public void end() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }
}
