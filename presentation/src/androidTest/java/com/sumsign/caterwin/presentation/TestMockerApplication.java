package com.sumsign.caterwin.presentation;

import com.sumsign.caterwin.presentation.dependency.component.FragmentInjector;

public class TestMockerApplication extends BaseApplication {

    @Override
    public FragmentInjector getFragmentInjector() {
        return DaggerTestMockerComponent.builder()
                .applicationComponent(this.applicationComponent)
                .testMockerModule(new TestMockerModule()).build();
    }
}
