package com.sumsign.caterwin.domain.interactor.user;

import com.sumsign.caterwin.domain.entity.VoidEntity;
import com.sumsign.caterwin.domain.executor.PostExecutionThread;
import com.sumsign.caterwin.domain.executor.ThreadExecutor;
import com.sumsign.caterwin.domain.interactor.UseCase;
import com.sumsign.caterwin.domain.repository.SessionRepository;
import com.sumsign.caterwin.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DoLogoutUseCase extends UseCase<VoidEntity> {

    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    @Inject
    public DoLogoutUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                           UserRepository userRepository, SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    protected Observable<VoidEntity> buildUseCaseObservable() {
        this.sessionRepository.invalidateSession();
        return this.userRepository.logoutUser();
    }
}
