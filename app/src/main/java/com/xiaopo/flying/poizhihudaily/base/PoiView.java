package com.xiaopo.flying.poizhihudaily.base;

/**
 * Created by snowbean on 16-9-24.
 */

public interface PoiView<T extends PoiPresenter> {
    void setPresenter(T t);

    void handleError(Throwable throwable);
}
