package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.io.File;

/* loaded from: classes.dex */
public class ContextCompat {
    private static final String DIR_ANDROID = "Android";
    private static final String DIR_CACHE = "cache";
    private static final String DIR_DATA = "data";
    private static final String DIR_FILES = "files";
    private static final String DIR_OBB = "obb";
    private static final String TAG = "ContextCompat";

    public static boolean startActivities(Context context, Intent[] intents) {
        return startActivities(context, intents, null);
    }

    public static boolean startActivities(Context context, Intent[] intents, Bundle options) {
        int i = Build.VERSION.SDK_INT;
        ContextCompatJellybean.startActivities(context, intents, options);
        return true;
    }

    public static File[] getObbDirs(Context context) {
        int i = Build.VERSION.SDK_INT;
        return ContextCompatKitKat.getObbDirs(context);
    }

    public static File[] getExternalFilesDirs(Context context, String type) {
        int i = Build.VERSION.SDK_INT;
        return ContextCompatKitKat.getExternalFilesDirs(context, type);
    }

    public static File[] getExternalCacheDirs(Context context) {
        int i = Build.VERSION.SDK_INT;
        return ContextCompatKitKat.getExternalCacheDirs(context);
    }

    private static File buildPath(File base, String... segments) {
        File cur = base;
        for (String segment : segments) {
            if (cur == null) {
                cur = new File(segment);
            } else if (segment != null) {
                cur = new File(cur, segment);
            }
        }
        return cur;
    }

    public static final Drawable getDrawable(Context context, int id) {
        int i = Build.VERSION.SDK_INT;
        return ContextCompatApi21.getDrawable(context, id);
    }

    public final File getNoBackupFilesDir(Context context) {
        int i = Build.VERSION.SDK_INT;
        return ContextCompatApi21.getNoBackupFilesDir(context);
    }

    public final File getCodeCacheDir(Context context) {
        int i = Build.VERSION.SDK_INT;
        return ContextCompatApi21.getCodeCacheDir(context);
    }

    private static synchronized File createFilesDir(File file) {
        synchronized (ContextCompat.class) {
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            if (file.exists()) {
                return file;
            }
            Log.w(TAG, "Unable to create files subdir " + file.getPath());
            return null;
        }
    }
}
