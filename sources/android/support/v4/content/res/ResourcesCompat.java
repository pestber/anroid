package android.support.v4.content.res;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* loaded from: classes.dex */
public class ResourcesCompat {
    public static Drawable getDrawable(Resources res, int id, Resources.Theme theme) throws Resources.NotFoundException {
        int i = Build.VERSION.SDK_INT;
        return ResourcesCompatApi21.getDrawable(res, id, theme);
    }

    public static Drawable getDrawableForDensity(Resources res, int id, int density, Resources.Theme theme) throws Resources.NotFoundException {
        int i = Build.VERSION.SDK_INT;
        return ResourcesCompatApi21.getDrawableForDensity(res, id, density, theme);
    }
}
