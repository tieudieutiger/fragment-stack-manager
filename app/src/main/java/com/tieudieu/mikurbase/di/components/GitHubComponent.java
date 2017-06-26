package com.tieudieu.mikurbase.di.components;

import com.tieudieu.mikurbase.MApplication;
import com.tieudieu.mikurbase.di.modules.GitHubModule;
import com.tieudieu.mikurbase.di.scopes.UserScope;

import dagger.Component;

@UserScope
@Component(dependencies = NetComponent.class, modules = {GitHubModule.class})
public interface GitHubComponent {
    void inject(MApplication application);
}
