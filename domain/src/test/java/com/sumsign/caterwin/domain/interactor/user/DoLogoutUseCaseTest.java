package com.sumsign.caterwin.domain.interactor.user;

import com.sumsign.caterwin.domain.executor.PostExecutionThread;
import com.sumsign.caterwin.domain.executor.ThreadExecutor;
import com.sumsign.caterwin.domain.repository.SessionRepository;
import com.sumsign.caterwin.domain.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

public class DoLogoutUseCaseTest {

    @Mock private ThreadExecutor mockThreadExecutor;
    @Mock private PostExecutionThread mockPostExecutionThread;
    @Mock private UserRepository mockUserRepository;
    @Mock private SessionRepository mockSessionRepository;

    @Before
    public void setup() { MockitoAnnotations.initMocks(this); }

    @Test
    public void testDoLogoutUseCaseSuccess() {
        DoLogoutUseCase doLogoutUseCase = new DoLogoutUseCase(mockThreadExecutor,
                mockPostExecutionThread, mockUserRepository, mockSessionRepository);

        doLogoutUseCase.buildUseCaseObservable();

        verify(mockSessionRepository).getCurrentUser();
        verify(mockSessionRepository).invalidateSession();
        verifyNoMoreInteractions(mockSessionRepository);
        verify(mockUserRepository).logoutUser(null);
        verifyNoMoreInteractions(mockUserRepository);
        verifyZeroInteractions(mockThreadExecutor);
        verifyZeroInteractions(mockPostExecutionThread);
    }
}