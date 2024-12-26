package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zza;
import com.google.android.gms.nearby.sharing.internal.zzc;

/* loaded from: classes.dex */
public final class ReceiveContentRequest implements SafeParcelable {
    public static final Parcelable.Creator<ReceiveContentRequest> CREATOR = new zzg();
    public String packageName;
    final int versionCode;
    public IBinder zzaGp;
    public zzc zzaGt;
    public zza zzaGu;

    ReceiveContentRequest() {
        this.versionCode = 1;
    }

    ReceiveContentRequest(int i, IBinder iBinder, IBinder iBinder2, String str, IBinder iBinder3) {
        this.versionCode = i;
        this.zzaGp = iBinder;
        this.zzaGu = zza.AbstractBinderC0226zza.zzdh(iBinder2);
        this.packageName = str;
        this.zzaGt = zzc.zza.zzdj(iBinder3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    IBinder zzxa() {
        return this.zzaGt.asBinder();
    }

    IBinder zzxj() {
        if (this.zzaGu == null) {
            return null;
        }
        return this.zzaGu.asBinder();
    }
}
