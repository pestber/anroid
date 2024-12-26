package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.SharedContent;
import com.google.android.gms.nearby.sharing.internal.zzb;
import com.google.android.gms.nearby.sharing.internal.zzc;
import java.util.List;

/* loaded from: classes.dex */
public final class ProvideContentRequest implements SafeParcelable {
    public static final Parcelable.Creator<ProvideContentRequest> CREATOR = new zzf();
    final int versionCode;
    public IBinder zzaGp;
    public zzb zzaGq;

    @Deprecated
    public List<SharedContent> zzaGr;
    public long zzaGs;
    public zzc zzaGt;

    ProvideContentRequest() {
        this.versionCode = 1;
    }

    ProvideContentRequest(int i, IBinder iBinder, IBinder iBinder2, List<SharedContent> list, long j, IBinder iBinder3) {
        this.versionCode = i;
        this.zzaGp = iBinder;
        this.zzaGq = zzb.zza.zzdi(iBinder2);
        this.zzaGr = list;
        this.zzaGs = j;
        this.zzaGt = zzc.zza.zzdj(iBinder3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    IBinder zzxa() {
        return this.zzaGt.asBinder();
    }

    IBinder zzxi() {
        if (this.zzaGq == null) {
            return null;
        }
        return this.zzaGq.asBinder();
    }
}
