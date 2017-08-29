package com.sumsign.caterwin.domain.repository;

import com.sumsign.caterwin.domain.entity.UserEntity;

public interface SessionRepository {
    String getCurrentUser();
    void setCurrentUser(UserEntity user);
    void invalidateSession();
}
