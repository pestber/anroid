package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgd;

@zzgd
/* loaded from: classes.dex */
public class NativeAdOptionsParcel implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    public final int versionCode;
    public final boolean zzvC;
    public final int zzvD;
    public final boolean zzvE;

    public NativeAdOptionsParcel(int i, boolean z, int i2, boolean z2) {
        this.versionCode = i;
        this.zzvC = z;
        this.zzvD = i2;
        this.zzvE = z2;
    }

    public NativeAdOptionsParcel(NativeAdOptions nativeAdOptions) {
        this(1, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
