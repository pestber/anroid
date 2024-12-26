package android.support.v4.os;

import android.os.Build;
import java.io.File;

/* loaded from: classes.dex */
public class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    public static String getStorageState(File path) {
        int i = Build.VERSION.SDK_INT;
        return EnvironmentCompatKitKat.getStorageState(path);
    }
}
