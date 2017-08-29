package com.sumsign.caterwin.domain.interactor.user;

import com.sumsign.caterwin.domain.entity.UserEntity;
import com.sumsign.caterwin.domain.entity.request.UserLoginModel;
import com.sumsign.caterwin.domain.entity.response.UserResponse;
import com.sumsign.caterwin.domain.executor.PostExecutionThread;
import com.sumsign.caterwin.domain.executor.ThreadExecutor;
import com.sumsign.caterwin.domain.interactor.UseCase;
import com.sumsign.caterwin.domain.repository.SessionRepository;
import com.sumsign.caterwin.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class CreateUserUseCase extends UseCase<UserResponse> {

    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    private UserLoginModel user;

    @Inject
    public CreateUserUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                             UserRepository userRepository, SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public void setParams(UserLoginModel user) {
        this.user = user;
    }

    @Override
    protected Observable<UserResponse> buildUseCaseObservable() {
        return this.userRepository.createUser(this.user)
                .doOnNext(new Consumer<UserResponse>() {
                    @Override
                    public void accept(UserResponse userResponse) throws Exception {
                        sessionRepository.setCurrentUser(userResponse.getData());
                    }
                });
    }
}
