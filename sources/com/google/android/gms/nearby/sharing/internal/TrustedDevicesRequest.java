package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.nearby.sharing.internal.zzc;

/* loaded from: classes.dex */
public final class TrustedDevicesRequest implements SafeParcelable {
    public static final Parcelable.Creator<TrustedDevicesRequest> CREATOR = new zzk();
    final int versionCode;
    public zzc zzaGt;
    public String zzaGv;
    public byte[] zzaGw;

    TrustedDevicesRequest(int i, String str, byte[] bArr, IBinder iBinder) {
        this.versionCode = i;
        this.zzaGv = (String) zzu.zzu(str);
        this.zzaGw = (byte[]) zzu.zzu(bArr);
        this.zzaGt = zzc.zza.zzdj(iBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    IBinder zzxa() {
        return this.zzaGt.asBinder();
    }
}
