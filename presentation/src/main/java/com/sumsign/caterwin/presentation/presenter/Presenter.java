package com.sumsign.caterwin.presentation.presenter;

import com.sumsign.caterwin.presentation.view.BaseView;

public interface Presenter {

    void initWithView(BaseView view);
    void resume();
    void pause();
    void destroy();

}
