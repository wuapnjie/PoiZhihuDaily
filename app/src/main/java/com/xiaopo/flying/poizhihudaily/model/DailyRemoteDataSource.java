package com.xiaopo.flying.poizhihudaily.model;

import android.support.compat.BuildConfig;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.xiaopo.flying.poizhihudaily.model.entity.DailyNews;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by snowbean on 16-9-24.
 */

@Singleton
public class DailyRemoteDataSource implements DailyDataSource {
    private static final String BASE_URL = "http://news-at.zhihu.com/api/4/";
    private Retrofit mRetrofit;
    private DailyService mDailyService;
    private OkHttpClient mOkHttpClient;

    public DailyRemoteDataSource() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        mOkHttpClient = builder.addInterceptor(loggingInterceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();


        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(MoshiConverterFactory.create())
                .client(mOkHttpClient)
                .build();

        mDailyService = mRetrofit.create(DailyService.class);

    }

    @Override
    public Observable<DailyNews> fetchLatestDailyNews() {
        return mDailyService.fetchLatestDailyNews();
    }
}
