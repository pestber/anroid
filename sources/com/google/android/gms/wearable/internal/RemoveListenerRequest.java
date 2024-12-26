package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzas;

/* loaded from: classes.dex */
public class RemoveListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator<RemoveListenerRequest> CREATOR = new zzbc();
    final int zzCY;
    public final zzas zzaTq;

    RemoveListenerRequest(int i, IBinder iBinder) {
        this.zzCY = i;
        this.zzaTq = iBinder != null ? zzas.zza.zzdP(iBinder) : null;
    }

    public RemoveListenerRequest(zzas zzasVar) {
        this.zzCY = 1;
        this.zzaTq = zzasVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbc.zza(this, parcel, i);
    }

    IBinder zzAT() {
        if (this.zzaTq == null) {
            return null;
        }
        return this.zzaTq.asBinder();
    }
}
