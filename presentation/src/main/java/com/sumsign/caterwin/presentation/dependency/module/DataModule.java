package com.sumsign.caterwin.presentation.dependency.module;

import android.content.SharedPreferences;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.sumsign.caterwin.data.net.RestApi;
import com.sumsign.caterwin.data.net.interceptor.HttpInterceptor;
import com.sumsign.caterwin.data.repository.SessionDataRepository;
import com.sumsign.caterwin.data.repository.UserDataRepository;
import com.sumsign.caterwin.domain.repository.SessionRepository;
import com.sumsign.caterwin.domain.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Module
public class DataModule {

    @Provides
    @Singleton
    SessionRepository provideSessionRepository(SharedPreferences sharedPreferences) {
        return new SessionDataRepository(sharedPreferences);
    }

    @Provides
    @Singleton
    RestApi provideRestApi(SessionDataRepository sessionDataRepository, HttpLoggingInterceptor httpLoggingInterceptor) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .addInterceptor(new HttpInterceptor(sessionDataRepository))
                .addInterceptor(httpLoggingInterceptor)
                .build();
        GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create());

        return new Retrofit.Builder()
                .baseUrl(RestApi.URL_BASE)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(RestApi.class);
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(RestApi restApi) {
        return new UserDataRepository(restApi);
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message -> Timber.d(message));
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }


}
