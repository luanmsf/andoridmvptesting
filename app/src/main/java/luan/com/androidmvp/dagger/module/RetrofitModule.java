package luan.com.androidmvp.dagger.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import luan.com.androidmvp.retrofit.RetrofitService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static luan.com.androidmvp.BuildConfig.END_POINT;

@Module
public class RetrofitModule {

    @Singleton
    @Provides
    public Retrofit provideRetrofit() {
        return new retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(END_POINT)
                .build();
    }

    @Singleton
    @Provides
    public RetrofitService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(RetrofitService.class);
    }
}
