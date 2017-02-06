package com.example.vj.samplemvpandroid;

import com.example.vj.samplemvpandroid.list.ListActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by vJ on 2/6/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(ListActivity listActivity);
}
