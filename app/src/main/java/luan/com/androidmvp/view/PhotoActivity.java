package luan.com.androidmvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import luan.com.androidmvp.BuildConfig;
import luan.com.androidmvp.R;
import luan.com.androidmvp.base.Photo;
import luan.com.androidmvp.base.PhotoApplication;
import luan.com.androidmvp.dagger.component.DaggerPhotoComponent;
import luan.com.androidmvp.dagger.component.RetrofitComponent;
import luan.com.androidmvp.dagger.module.PhotoModule;
import luan.com.androidmvp.presenter.PhotoPresenter;

public class PhotoActivity extends AppCompatActivity implements Photo.View, View.OnClickListener {

    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;

    @Bind(R.id.recylerview_photo)
    RecyclerView mRecylerViewPhoto;

    @Bind(R.id.btn_load)
    Button mBtnLoad;

    @Inject
    public Photo.Presenter mMainPresenter;

    private List<luan.com.androidmvp.model.entity.Photo> mListPhotos;
    private PhotoAdapter mPhotoAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initDagger();
        initMvp();
        initView();

        mBtnLoad.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.removeView();
    }

    @Override
    public void updateDataToView(List<?> data) {
        mListPhotos.addAll((Collection<? extends luan.com.androidmvp.model.entity.Photo>) data);
        mPhotoAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading(boolean isShow) {
        if (isShow) {
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(), getString(R.string.error), Toast.LENGTH_LONG).show();
    }

    private void initDagger() {
        PhotoApplication photoApplication = ((PhotoApplication) getApplication());
        RetrofitComponent retrofitComponent = photoApplication.getRetrofitComponent();
        DaggerPhotoComponent.builder().retrofitComponent(retrofitComponent).photoModule(photoApplication.getPhotoModule(this))
                .build().inject(this);
    }

    public void initMvp() {
        mMainPresenter.takeView(this);
    }

    private void initView() {
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mListPhotos = new ArrayList<>();
        mPhotoAdapter = new PhotoAdapter(mListPhotos, getApplicationContext());

        mRecylerViewPhoto.setHasFixedSize(true);
        mRecylerViewPhoto.setLayoutManager(mLayoutManager);
        mRecylerViewPhoto.setAdapter(mPhotoAdapter);
    }

    public void loadFirstTime() {
        //load first time
        mMainPresenter.requestToGetData(BuildConfig.TOKEN);
    }

    @Override
    public void onClick(View view) {
        mMainPresenter.requestToGetData(BuildConfig.TOKEN);
    }
}
