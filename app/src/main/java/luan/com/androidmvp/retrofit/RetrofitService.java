package luan.com.androidmvp.retrofit;

import java.util.List;

import luan.com.androidmvp.model.entity.Photo;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RetrofitService {

    @GET("photos")
    Observable<List<Photo>> getPhoto(
            @Query("access_token") String accessToken
    );
}
