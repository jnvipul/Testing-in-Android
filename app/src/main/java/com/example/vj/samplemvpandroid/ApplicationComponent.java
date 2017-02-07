package com.example.vj.samplemvpandroid;

import com.example.vj.samplemvpandroid.list.ListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by vJ on 2/6/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {
    void inject(ListActivity listActivity);
}
