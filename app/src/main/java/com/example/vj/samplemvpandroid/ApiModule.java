package com.example.vj.samplemvpandroid;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.vj.samplemvpandroid.constants.Urls.BASE_URL;

/**
 * Created by vJ on 2/6/17.
 */

@Module
public class ApiModule {

    @Provides
    @Singleton
    public Retrofit providesRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
