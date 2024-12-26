package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zza;
import com.google.android.gms.nearby.messages.internal.zzb;

/* loaded from: classes.dex */
public final class UnsubscribeRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnsubscribeRequest> CREATOR = new zzl();
    final int zzCY;
    public final zzb zzaGd;
    public final String zzaGe;
    public final zza zzaGf;
    public final PendingIntent zzaGh;
    public final int zzaGi;
    public final String zzayp;

    UnsubscribeRequest(int i, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, int i2, String str, String str2) {
        this.zzCY = i;
        this.zzaGf = zza.AbstractBinderC0222zza.zzdd(iBinder);
        this.zzaGd = zzb.zza.zzde(iBinder2);
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
        zzl.zza(this, parcel, i);
    }

    IBinder zzxa() {
        return this.zzaGd.asBinder();
    }

    IBinder zzxb() {
        if (this.zzaGf == null) {
            return null;
        }
        return this.zzaGf.asBinder();
    }
}
