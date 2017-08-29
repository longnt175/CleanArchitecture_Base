package com.sumsign.caterwin.domain.repository;

import com.sumsign.caterwin.domain.entity.MessageEntity;
import com.sumsign.caterwin.domain.entity.UserEntity;
import com.sumsign.caterwin.domain.entity.VoidEntity;
import com.sumsign.caterwin.domain.entity.request.UserLoginModel;
import com.sumsign.caterwin.domain.entity.response.UserResponse;

import io.reactivex.Observable;

public interface UserRepository {
    Observable<UserResponse> createUser(UserLoginModel user);

    Observable<MessageEntity> resetPassword(UserLoginModel user);

    Observable<UserResponse> loginUser(UserLoginModel user);

    Observable<VoidEntity> logoutUser();
}
