package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zzc;

/* loaded from: classes.dex */
public final class StopProvidingContentRequest implements SafeParcelable {
    public static final Parcelable.Creator<StopProvidingContentRequest> CREATOR = new zzj();
    final int versionCode;
    public long zzaGs;
    public zzc zzaGt;

    StopProvidingContentRequest() {
        this.versionCode = 1;
    }

    StopProvidingContentRequest(int i, long j, IBinder iBinder) {
        this.versionCode = i;
        this.zzaGs = j;
        this.zzaGt = zzc.zza.zzdj(iBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    IBinder zzxa() {
        return this.zzaGt.asBinder();
    }
}
