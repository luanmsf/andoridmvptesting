package luan.com.androidmvp.model.entity;

import com.google.gson.annotations.SerializedName;

public class Url {
    public Url(String full, String regular, String small) {
        mFull = full;
        mRegular = regular;
        mSmall = small;
    }

    @SerializedName("full")
    private String mFull;

    @SerializedName("regular")
    private String mRegular;

    @SerializedName("small")
    private String mSmall;

    public String getFull() {
        return mFull;
    }

    public String getRegular() {
        return mRegular;
    }

    public String getSmall() {
        return mSmall;
    }
}
