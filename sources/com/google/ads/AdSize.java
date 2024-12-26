package com.google.ads;

import android.content.Context;

@Deprecated
/* loaded from: classes.dex */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    public static final int LANDSCAPE_AD_HEIGHT = 32;
    public static final int LARGE_AD_HEIGHT = 90;
    public static final int PORTRAIT_AD_HEIGHT = 50;
    private final com.google.android.gms.ads.AdSize zzaK;
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");
    public static final AdSize BANNER = new AdSize(320, 50, "mb");
    public static final AdSize IAB_MRECT = new AdSize(300, 250, "as");
    public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
    public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
    public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");

    public AdSize(int i, int i2) {
        this(new com.google.android.gms.ads.AdSize(i, i2));
    }

    private AdSize(int i, int i2, String str) {
        this(new com.google.android.gms.ads.AdSize(i, i2));
    }

    public AdSize(com.google.android.gms.ads.AdSize adSize) {
        this.zzaK = adSize;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AdSize) {
            return this.zzaK.equals(((AdSize) obj).zzaK);
        }
        return false;
    }

    public AdSize findBestSize(AdSize... adSizeArr) {
        AdSize adSize = null;
        if (adSizeArr == null) {
            return null;
        }
        int width = getWidth();
        int height = getHeight();
        float f = 0.0f;
        for (AdSize adSize2 : adSizeArr) {
            if (isSizeAppropriate(adSize2.getWidth(), adSize2.getHeight())) {
                float f2 = (r7 * r8) / (width * height);
                if (f2 > 1.0f) {
                    f2 = 1.0f / f2;
                }
                if (f2 > f) {
                    adSize = adSize2;
                    f = f2;
                }
            }
        }
        return adSize;
    }

    public int getHeight() {
        return this.zzaK.getHeight();
    }

    public int getHeightInPixels(Context context) {
        return this.zzaK.getHeightInPixels(context);
    }

    public int getWidth() {
        return this.zzaK.getWidth();
    }

    public int getWidthInPixels(Context context) {
        return this.zzaK.getWidthInPixels(context);
    }

    public int hashCode() {
        return this.zzaK.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zzaK.isAutoHeight();
    }

    public boolean isCustomAdSize() {
        return false;
    }

    public boolean isFullWidth() {
        return this.zzaK.isFullWidth();
    }

    public boolean isSizeAppropriate(int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        float f = width;
        if (i <= f * 1.25f && i >= f * 0.8f) {
            float f2 = height;
            if (i2 <= 1.25f * f2 && i2 >= f2 * 0.8f) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.zzaK.toString();
    }
}
