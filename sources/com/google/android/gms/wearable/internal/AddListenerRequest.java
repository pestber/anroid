package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzas;

/* loaded from: classes.dex */
public class AddListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator<AddListenerRequest> CREATOR = new zzb();
    final int zzCY;
    public final zzas zzaTq;
    public final IntentFilter[] zzaTr;
    public final String zzaTs;
    public final String zzaTt;

    AddListenerRequest(int i, IBinder iBinder, IntentFilter[] intentFilterArr, String str, String str2) {
        this.zzCY = i;
        this.zzaTq = iBinder != null ? zzas.zza.zzdP(iBinder) : null;
        this.zzaTr = intentFilterArr;
        this.zzaTs = str;
        this.zzaTt = str2;
    }

    public AddListenerRequest(zzbl zzblVar) {
        this.zzCY = 1;
        this.zzaTq = zzblVar;
        this.zzaTr = zzblVar.zzBh();
        this.zzaTs = zzblVar.zzBi();
        this.zzaTt = zzblVar.zzBj();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    IBinder zzAT() {
        if (this.zzaTq == null) {
            return null;
        }
        return this.zzaTq.asBinder();
    }
}
