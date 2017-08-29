package com.sumsign.caterwin.data.repository;

import com.sumsign.caterwin.data.net.RestApi;
import com.sumsign.caterwin.domain.entity.MessageEntity;
import com.sumsign.caterwin.domain.entity.UserEntity;
import com.sumsign.caterwin.domain.entity.VoidEntity;
import com.sumsign.caterwin.domain.entity.request.UserLoginModel;
import com.sumsign.caterwin.domain.entity.response.UserResponse;
import com.sumsign.caterwin.domain.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class UserDataRepository extends RestApiRepository implements UserRepository {

    private final RestApi restApi;

    @Inject
    public UserDataRepository(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<UserResponse> createUser(UserLoginModel userLoginModel) {
        return this.restApi.createUser(userLoginModel)
                .map(userEntityResponse -> {
                    handleResponseError(userEntityResponse);
                    return userEntityResponse.body();
                });
    }


    @Override
    public Observable<MessageEntity> resetPassword(UserLoginModel userLoginModel) {
        return this.restApi.resetPassword(userLoginModel)
                .map(messageEntityResponse -> {
                    handleResponseError(messageEntityResponse);
                    return messageEntityResponse.body();
                });
    }

    @Override
    public Observable<UserResponse> loginUser(UserLoginModel userLoginModel) {
        return this.restApi.doLogin(userLoginModel)
                .map(userResponseResponse -> {
                    handleResponseError(userResponseResponse);
                    return userResponseResponse.body();
                });
    }

    @Override
    public Observable<VoidEntity> logoutUser() {
        return null;
    }
}
