package com.sumsign.caterwin.presentation.dependency.component;

import com.sumsign.caterwin.presentation.dependency.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class)
public interface ActivityComponent extends FragmentInjector {}
