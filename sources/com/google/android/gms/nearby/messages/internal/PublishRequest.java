package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.zzb;

/* loaded from: classes.dex */
public final class PublishRequest implements SafeParcelable {
    public static final Parcelable.Creator<PublishRequest> CREATOR = new zzi();
    final int zzCY;
    public final MessageWrapper zzaGb;
    public final Strategy zzaGc;
    public final zzb zzaGd;
    public final String zzaGe;
    public final String zzayp;

    PublishRequest(int i, MessageWrapper messageWrapper, Strategy strategy, IBinder iBinder, String str, String str2) {
        this.zzCY = i;
        this.zzaGb = messageWrapper;
        this.zzaGc = strategy;
        this.zzaGd = zzb.zza.zzde(iBinder);
        this.zzayp = str;
        this.zzaGe = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    IBinder zzxa() {
        return this.zzaGd.asBinder();
    }
}
