package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgd;
import java.util.List;

@zzgd
/* loaded from: classes.dex */
public final class AdRequestParcel implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    public final Bundle extras;
    public final int versionCode;
    public final long zzrX;
    public final int zzrY;
    public final List<String> zzrZ;
    public final boolean zzsa;
    public final int zzsb;
    public final boolean zzsc;
    public final String zzsd;
    public final SearchAdRequestParcel zzse;
    public final Location zzsf;
    public final String zzsg;
    public final Bundle zzsh;
    public final Bundle zzsi;
    public final List<String> zzsj;
    public final String zzsk;

    public AdRequestParcel(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, SearchAdRequestParcel searchAdRequestParcel, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3) {
        this.versionCode = i;
        this.zzrX = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzrY = i2;
        this.zzrZ = list;
        this.zzsa = z;
        this.zzsb = i3;
        this.zzsc = z2;
        this.zzsd = str;
        this.zzse = searchAdRequestParcel;
        this.zzsf = location;
        this.zzsg = str2;
        this.zzsh = bundle2;
        this.zzsi = bundle3;
        this.zzsj = list2;
        this.zzsk = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
