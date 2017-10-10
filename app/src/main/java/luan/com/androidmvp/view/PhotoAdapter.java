package luan.com.androidmvp.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import luan.com.androidmvp.R;
import luan.com.androidmvp.model.entity.Photo;

public class PhotoAdapter extends RecyclerView.Adapter {

    private List<Photo> mPhotos;
    private Context mContext;

    public PhotoAdapter(List<Photo> photos, Context context) {
        mPhotos = photos;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        PhotoViewHolder mainViewHolder = new PhotoViewHolder(itemView);

        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PhotoViewHolder photoViewHolder = (PhotoViewHolder) holder;
        Photo photo = mPhotos.get(position);

        final int color = Color.parseColor(photo.getColor());
        photoViewHolder.mImgPhoto.setBackgroundColor(color);

        Glide.with(mContext)
                .load(photo.getUrls().getRegular())
                .into(photoViewHolder.mImgPhoto);
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }
}
