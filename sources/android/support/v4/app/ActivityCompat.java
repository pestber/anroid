package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ActivityCompat21;
import android.support.v4.content.ContextCompat;
import android.view.View;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ActivityCompat extends ContextCompat {
    public static boolean invalidateOptionsMenu(Activity activity) {
        ActivityCompatHoneycomb.invalidateOptionsMenu(activity);
        return true;
    }

    public static void startActivity(Activity activity, Intent intent, Bundle options) {
        ActivityCompatJB.startActivity(activity, intent, options);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int requestCode, Bundle options) {
        ActivityCompatJB.startActivityForResult(activity, intent, requestCode, options);
    }

    public static void finishAffinity(Activity activity) {
        ActivityCompatJB.finishAffinity(activity);
    }

    public static void finishAfterTransition(Activity activity) {
        ActivityCompat21.finishAfterTransition(activity);
    }

    public static void setEnterSharedElementCallback(Activity activity, SharedElementCallback callback) {
        ActivityCompat21.setEnterSharedElementCallback(activity, createCallback(callback));
    }

    public static void setExitSharedElementCallback(Activity activity, SharedElementCallback callback) {
        ActivityCompat21.setExitSharedElementCallback(activity, createCallback(callback));
    }

    public static void postponeEnterTransition(Activity activity) {
        ActivityCompat21.postponeEnterTransition(activity);
    }

    public static void startPostponedEnterTransition(Activity activity) {
        ActivityCompat21.startPostponedEnterTransition(activity);
    }

    private static ActivityCompat21.SharedElementCallback21 createCallback(SharedElementCallback callback) {
        if (callback == null) {
            return null;
        }
        ActivityCompat21.SharedElementCallback21 newCallback = new SharedElementCallback21Impl(callback);
        return newCallback;
    }

    private static class SharedElementCallback21Impl extends ActivityCompat21.SharedElementCallback21 {
        private SharedElementCallback mCallback;

        public SharedElementCallback21Impl(SharedElementCallback callback) {
            this.mCallback = callback;
        }

        @Override // android.support.v4.app.ActivityCompat21.SharedElementCallback21
        public void onSharedElementStart(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
            this.mCallback.onSharedElementStart(sharedElementNames, sharedElements, sharedElementSnapshots);
        }

        @Override // android.support.v4.app.ActivityCompat21.SharedElementCallback21
        public void onSharedElementEnd(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
            this.mCallback.onSharedElementEnd(sharedElementNames, sharedElements, sharedElementSnapshots);
        }

        @Override // android.support.v4.app.ActivityCompat21.SharedElementCallback21
        public void onRejectSharedElements(List<View> rejectedSharedElements) {
            this.mCallback.onRejectSharedElements(rejectedSharedElements);
        }

        @Override // android.support.v4.app.ActivityCompat21.SharedElementCallback21
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            this.mCallback.onMapSharedElements(names, sharedElements);
        }

        @Override // android.support.v4.app.ActivityCompat21.SharedElementCallback21
        public Parcelable onCaptureSharedElementSnapshot(View sharedElement, Matrix viewToGlobalMatrix, RectF screenBounds) {
            return this.mCallback.onCaptureSharedElementSnapshot(sharedElement, viewToGlobalMatrix, screenBounds);
        }

        @Override // android.support.v4.app.ActivityCompat21.SharedElementCallback21
        public View onCreateSnapshotView(Context context, Parcelable snapshot) {
            return this.mCallback.onCreateSnapshotView(context, snapshot);
        }
    }
}
