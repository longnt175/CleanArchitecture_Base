package com.sumsign.caterwin.presentation;

import android.app.Application;

import com.sumsign.caterwin.presentation.dependency.component.ApplicationComponent;
import com.sumsign.caterwin.presentation.dependency.component.DaggerActivityComponent;
import com.sumsign.caterwin.presentation.dependency.component.DaggerApplicationComponent;
import com.sumsign.caterwin.presentation.dependency.component.FragmentInjector;
import com.sumsign.caterwin.presentation.dependency.module.ApplicationModule;

import timber.log.Timber;

public class BaseApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    protected void initializeInjector() {
        Timber.plant(new Timber.DebugTree());
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    public FragmentInjector getFragmentInjector() {
        return DaggerActivityComponent.builder()
                .applicationComponent(this.applicationComponent).build();
    }

}
