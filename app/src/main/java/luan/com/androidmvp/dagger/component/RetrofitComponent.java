package luan.com.androidmvp.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import luan.com.androidmvp.dagger.module.RetrofitModule;
import luan.com.androidmvp.retrofit.RetrofitService;

@Singleton
@Component(modules = {RetrofitModule.class})
public interface RetrofitComponent {
    RetrofitService getRetrofitService();
}
