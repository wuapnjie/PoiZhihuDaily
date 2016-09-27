package com.xiaopo.flying.poizhihudaily.model;

import com.xiaopo.flying.poizhihudaily.model.entity.DailyNews;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by snowbean on 16-9-24.
 */

public interface DailyService {

    @GET("news/latest")
    Observable<DailyNews> fetchLatestDailyNews();
}
