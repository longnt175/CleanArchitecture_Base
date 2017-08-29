package com.sumsign.caterwin.presentation.presenter;

import com.sumsign.caterwin.domain.interactor.user.DoLogoutUseCase;
import com.sumsign.caterwin.presentation.view.SettingsView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;

import static junit.framework.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class SettingsPresenterTest {

    @Mock DoLogoutUseCase mockDoLogoutUseCase;
    @Mock SettingsView mockSettingsView;
    @Mock Observable mockObservable;

    private SettingsPresenter settingsPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.settingsPresenter =
                new SettingsPresenter(this.mockDoLogoutUseCase);
        this.settingsPresenter.initWithView(this.mockSettingsView);
    }

    @Test
    public void testDestroy() {

        this.settingsPresenter.destroy();

        verify(this.mockDoLogoutUseCase).unsubscribe();
        assertNull(this.settingsPresenter.settingsView);
        assertNull(this.settingsPresenter.view);
    }

    @Test
    public void testLogoutUser() throws Exception {

        this.settingsPresenter.logoutUserButtonPressed();

        verify(this.mockDoLogoutUseCase).execute(any(BasePresenter.BaseSubscriber.class));
        verify(this.mockSettingsView).closeAndDisplayLogin();
    }


}
