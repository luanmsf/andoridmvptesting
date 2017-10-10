package luan.com.androidmvp.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import luan.com.androidmvp.R;

public class PhotoViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.img_photo)
    ImageView mImgPhoto;

    public PhotoViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }
}
