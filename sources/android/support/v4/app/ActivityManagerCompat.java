package android.support.v4.app;

import android.app.ActivityManager;

/* loaded from: classes.dex */
public final class ActivityManagerCompat {
    private ActivityManagerCompat() {
    }

    public static boolean isLowRamDevice(ActivityManager am) {
        return ActivityManagerCompatKitKat.isLowRamDevice(am);
    }
}
