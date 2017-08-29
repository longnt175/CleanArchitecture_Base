package com.sumsign.caterwin.data.repository;

import android.content.SharedPreferences;

import com.sumsign.caterwin.domain.entity.UserEntity;
import com.sumsign.caterwin.domain.repository.SessionRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SessionDataRepository implements SessionRepository {

    private static final String EMAIL = "email";
    private static final String AUTH_TOKEN = "auth_token";

    private final SharedPreferences sharedPreferences;

    @Inject
    public SessionDataRepository(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public String getCurrentUser() {
        if (sharedPreferences.contains(EMAIL) && sharedPreferences.contains(AUTH_TOKEN)) {
            return sharedPreferences.getString(AUTH_TOKEN, null);
        }
        return null;
    }

    @Override
    public void setCurrentUser(UserEntity user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(EMAIL, user.getEmail());
        editor.putString(AUTH_TOKEN, user.getToken());
        editor.apply();
    }

    @Override
    public void invalidateSession() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(EMAIL);
        editor.remove(AUTH_TOKEN);
        editor.apply();
    }
}
