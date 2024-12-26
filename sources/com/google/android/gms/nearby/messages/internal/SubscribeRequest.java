package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.zza;
import com.google.android.gms.nearby.messages.internal.zzb;

/* loaded from: classes.dex */
public final class SubscribeRequest implements SafeParcelable {
    public static final Parcelable.Creator<SubscribeRequest> CREATOR = new zzj();
    final int zzCY;
    public final Strategy zzaGc;
    public final zzb zzaGd;
    public final String zzaGe;
    public final zza zzaGf;
    public final MessageFilter zzaGg;
    public final PendingIntent zzaGh;
    public final int zzaGi;
    public final String zzayp;

    SubscribeRequest(int i, IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, int i2, String str, String str2) {
        this.zzCY = i;
        this.zzaGf = zza.AbstractBinderC0222zza.zzdd(iBinder);
        this.zzaGc = strategy;
        this.zzaGd = zzb.zza.zzde(iBinder2);
        this.zzaGg = messageFilter;
        this.zzaGh = pendingIntent;
        this.zzaGi = i2;
        this.zzayp = str;
        this.zzaGe = str2;
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
        if (this.zzaGd == null) {
            return null;
        }
        return this.zzaGd.asBinder();
    }

    IBinder zzxb() {
        if (this.zzaGf == null) {
            return null;
        }
        return this.zzaGf.asBinder();
    }
}
