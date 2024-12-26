package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgd;

@zzgd
/* loaded from: classes.dex */
public final class AdSizeParcel implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    public final int height;
    public final int heightPixels;
    public final int versionCode;
    public final int width;
    public final int widthPixels;
    public final String zzsm;
    public final boolean zzsn;
    public final AdSizeParcel[] zzso;
    public final boolean zzsp;

    public AdSizeParcel() {
        this(3, "interstitial_mb", 0, 0, true, 0, 0, null, false);
    }

    AdSizeParcel(int i, String str, int i2, int i3, boolean z, int i4, int i5, AdSizeParcel[] adSizeParcelArr, boolean z2) {
        this.versionCode = i;
        this.zzsm = str;
        this.height = i2;
        this.heightPixels = i3;
        this.zzsn = z;
        this.width = i4;
        this.widthPixels = i5;
        this.zzso = adSizeParcelArr;
        this.zzsp = z2;
    }

    public AdSizeParcel(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    public AdSizeParcel(Context context, AdSize[] adSizeArr) {
        int i;
        AdSize adSize = adSizeArr[0];
        this.versionCode = 3;
        this.zzsn = false;
        this.width = adSize.getWidth();
        this.height = adSize.getHeight();
        boolean z = this.width == -1;
        boolean z2 = this.height == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            this.widthPixels = (zzk.zzcA().zzQ(context) && zzk.zzcA().zzR(context)) ? zza(displayMetrics) - zzk.zzcA().zzS(context) : zza(displayMetrics);
            double d = this.widthPixels / displayMetrics.density;
            i = (int) d;
            if (d - i >= 0.01d) {
                i++;
            }
        } else {
            i = this.width;
            this.widthPixels = zzk.zzcA().zza(displayMetrics, this.width);
        }
        int zzc = z2 ? zzc(displayMetrics) : this.height;
        this.heightPixels = zzk.zzcA().zza(displayMetrics, zzc);
        this.zzsm = (z || z2) ? i + "x" + zzc + "_as" : adSize.toString();
        if (adSizeArr.length > 1) {
            this.zzso = new AdSizeParcel[adSizeArr.length];
            for (int i2 = 0; i2 < adSizeArr.length; i2++) {
                this.zzso[i2] = new AdSizeParcel(context, adSizeArr[i2]);
            }
        } else {
            this.zzso = null;
        }
        this.zzsp = false;
    }

    public AdSizeParcel(AdSizeParcel adSizeParcel, AdSizeParcel[] adSizeParcelArr) {
        this(3, adSizeParcel.zzsm, adSizeParcel.height, adSizeParcel.heightPixels, adSizeParcel.zzsn, adSizeParcel.width, adSizeParcel.widthPixels, adSizeParcelArr, adSizeParcel.zzsp);
    }

    public static int zza(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return (int) (zzc(displayMetrics) * displayMetrics.density);
    }

    private static int zzc(DisplayMetrics displayMetrics) {
        int i = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static AdSizeParcel zzcx() {
        return new AdSizeParcel(3, "reward_mb", 0, 0, false, 0, 0, null, false);
    }

    public static AdSizeParcel zzs(Context context) {
        return new AdSizeParcel(3, "320x50_mb", 0, 0, false, 0, 0, null, true);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public AdSize zzcy() {
        return com.google.android.gms.ads.zza.zza(this.width, this.height, this.zzsm);
    }
}
