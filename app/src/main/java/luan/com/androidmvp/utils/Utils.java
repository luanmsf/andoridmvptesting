package luan.com.androidmvp.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;

import static android.media.AudioManager.RINGER_MODE_SILENT;
import static android.media.AudioManager.STREAM_RING;

/**
 * Created by ntluan on 9/27/17.
 */

public class Utils {

    public static int[] getMeasureSize(Context context, int width, int height) {
        int measureWidth = getWidthScreen((Activity) context);
        int measureHeight = (measureWidth * height) / width;

        if (measureHeight < 2 * 250) {
            measureHeight = 250;
        } else {
            measureHeight = 420;
        }

        return new int[]{measureWidth, measureHeight};
    }

    public static int getWidthScreen(Activity context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;

        return width;
    }

    public static void maximizeVolume(AudioManager audioManager) {
        if (audioManager.getRingerMode() != RINGER_MODE_SILENT) {
            int max = audioManager.getStreamMaxVolume(STREAM_RING);
            audioManager.setStreamVolume(STREAM_RING, max, 0);
        }


    }

    public void test(String text) {
        boolean testCheck = TextUtils.isEmpty(text);
    }
}
