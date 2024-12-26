package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zzb;

/* loaded from: classes.dex */
public final class UnpublishRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnpublishRequest> CREATOR = new zzk();
    final int zzCY;
    public final MessageWrapper zzaGb;
    public final zzb zzaGd;
    public final String zzaGe;
    public final String zzayp;

    UnpublishRequest(int i, MessageWrapper messageWrapper, IBinder iBinder, String str, String str2) {
        this.zzCY = i;
        this.zzaGb = messageWrapper;
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
        zzk.zza(this, parcel, i);
    }

    IBinder zzxa() {
        return this.zzaGd.asBinder();
    }
}
