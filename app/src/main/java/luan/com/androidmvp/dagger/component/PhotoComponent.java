package luan.com.androidmvp.dagger.component;

import dagger.Component;
import luan.com.androidmvp.dagger.CustomScope;
import luan.com.androidmvp.dagger.module.PhotoModule;
import luan.com.androidmvp.view.PhotoActivity;

@CustomScope
@Component (modules = {PhotoModule.class}, dependencies = {RetrofitComponent.class})
public interface PhotoComponent {
    void inject(PhotoActivity photoActivity);
}
