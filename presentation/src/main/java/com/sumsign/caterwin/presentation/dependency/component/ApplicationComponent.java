package com.sumsign.caterwin.presentation.dependency.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.sumsign.caterwin.data.net.RestApi;
import com.sumsign.caterwin.domain.executor.PostExecutionThread;
import com.sumsign.caterwin.domain.executor.ThreadExecutor;
import com.sumsign.caterwin.domain.repository.SessionRepository;
import com.sumsign.caterwin.domain.repository.UserRepository;
import com.sumsign.caterwin.presentation.dependency.module.ApplicationModule;
import com.sumsign.caterwin.presentation.dependency.module.DataModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, DataModule.class })
public interface ApplicationComponent {

    Context context();
    SharedPreferences sharedPreferences();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();

    SessionRepository sessionRepository();
    RestApi restApi();
    UserRepository userRepository();

}
