package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgd;

@zzgd
/* loaded from: classes.dex */
public final class MobileAdsSettingsParcel implements SafeParcelable {
    public static final zzad CREATOR = new zzad();
    public final int versionCode;
    public final boolean zztf;
    public final String zztg;

    public MobileAdsSettingsParcel(int i, boolean z, String str) {
        this.versionCode = i;
        this.zztf = z;
        this.zztg = str;
    }

    public MobileAdsSettingsParcel(zzab zzabVar) {
        this(1, zzabVar.isGoogleAnalyticsEnabled(), zzabVar.getTrackingId());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzad.zza(this, parcel, i);
    }
}
