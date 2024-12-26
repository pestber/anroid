package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzk;

/* loaded from: classes.dex */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    private final int zznM;
    private final int zznN;
    private final String zznO;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");

    public AdSize(int i, int i2) {
        this(i, i2, (i == -1 ? "FULL" : String.valueOf(i)) + "x" + (i2 == -2 ? "AUTO" : String.valueOf(i2)) + "_as");
    }

    AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i);
        }
        if (i2 < 0 && i2 != -2) {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i2);
        }
        this.zznM = i;
        this.zznN = i2;
        this.zznO = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.zznM == adSize.zznM && this.zznN == adSize.zznN && this.zznO.equals(adSize.zznO);
    }

    public int getHeight() {
        return this.zznN;
    }

    public int getHeightInPixels(Context context) {
        return this.zznN == -2 ? AdSizeParcel.zzb(context.getResources().getDisplayMetrics()) : zzk.zzcA().zzb(context, this.zznN);
    }

    public int getWidth() {
        return this.zznM;
    }

    public int getWidthInPixels(Context context) {
        return this.zznM == -1 ? AdSizeParcel.zza(context.getResources().getDisplayMetrics()) : zzk.zzcA().zzb(context, this.zznM);
    }

    public int hashCode() {
        return this.zznO.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zznN == -2;
    }

    public boolean isFullWidth() {
        return this.zznM == -1;
    }

    public String toString() {
        return this.zznO;
    }
}
