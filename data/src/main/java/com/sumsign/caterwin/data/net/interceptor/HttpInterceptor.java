package com.sumsign.caterwin.data.net.interceptor;

import com.sumsign.caterwin.data.net.RestApi;
import com.sumsign.caterwin.data.repository.SessionDataRepository;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
public class HttpInterceptor implements Interceptor {
    SessionDataRepository sessionDataRepository;

    @Inject
    public HttpInterceptor(SessionDataRepository sessionDataRepository) {
        this.sessionDataRepository = sessionDataRepository;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer " + sessionDataRepository.getCurrentUser())
                .addHeader("Accept", RestApi.ACCEPT)
                .build();
        return chain.proceed(request);
    }

}
