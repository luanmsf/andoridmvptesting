package luan.com.androidmvp;

import android.media.AudioManager;
import android.text.TextUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import luan.com.androidmvp.utils.Utils;

import static android.media.AudioManager.RINGER_MODE_NORMAL;
import static android.media.AudioManager.STREAM_RING;
import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * Created by ntluan on 9/27/17.
 */

public class UtilsTest {

    @Test
    public void Utils_getMeasureSize() {
    }

    @Test
    public void Utils_maxAudio() {
//        AudioManager audioManager = Mockito.mock(AudioManager.class);
//        Mockito.when(audioManager.getRingerMode())
//                .thenReturn(RINGER_MODE_SILENT);
//
//        Utils.maximizeVolume(audioManager);
//
//        Mockito.verify(audioManager).getRingerMode();
//        Mockito.verifyNoMoreInteractions(audioManager);

        /*AudioManager audioManager = Mockito.mock(AudioManager.class);
        Mockito.when(audioManager.getRingerMode()).thenReturn(RINGER_MODE_NORMAL);
        Mockito.when(audioManager.getStreamMaxVolume(STREAM_RING)).thenReturn(100);

        Utils.maximizeVolume(audioManager);

        Mockito.verify(audioManager).setStreamVolume(STREAM_RING, 100, 0);

        TextUtils textUtils = Mockito.mock(TextUtils.class);
        Mockito.when(textUtils.isEmpty(anyString())).thenReturn(false);*/


    }

    @Test
    public void test() {
        Utils utils = new Utils();
        utils.test(null);
    }
}
