package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ProxyResponse implements SafeParcelable {
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new zzc();
    final int versionCode;
    public final byte[] zzPs;
    final Bundle zzPt;
    public final int zzPu;
    public final PendingIntent zzPv;
    public final int zzPw;

    ProxyResponse(int i, int i2, PendingIntent pendingIntent, int i3, Bundle bundle, byte[] bArr) {
        this.versionCode = i;
        this.zzPu = i2;
        this.zzPw = i3;
        this.zzPt = bundle;
        this.zzPs = bArr;
        this.zzPv = pendingIntent;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
