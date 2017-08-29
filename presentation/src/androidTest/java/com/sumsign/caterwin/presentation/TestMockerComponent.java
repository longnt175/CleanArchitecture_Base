package com.sumsign.caterwin.presentation;

import com.sumsign.caterwin.presentation.dependency.ActivityScope;
import com.sumsign.caterwin.presentation.dependency.component.ApplicationComponent;
import com.sumsign.caterwin.presentation.dependency.component.FragmentInjector;

import dagger.Component;

@ActivityScope
@Component(modules = TestMockerModule.class, dependencies = ApplicationComponent.class)
public interface TestMockerComponent extends FragmentInjector {}
