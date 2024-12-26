package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.zzmu;

/* loaded from: classes.dex */
public class SubscribeRequest implements SafeParcelable {
    public static final Parcelable.Creator<SubscribeRequest> CREATOR = new zzac();
    private final int zzCY;
    private final String zzMZ;
    private final zzmu zzalN;
    private final Subscription zzamM;
    private final boolean zzamN;

    SubscribeRequest(int i, Subscription subscription, boolean z, IBinder iBinder, String str) {
        this.zzCY = i;
        this.zzamM = subscription;
        this.zzamN = z;
        this.zzalN = iBinder == null ? null : zzmu.zza.zzbF(iBinder);
        this.zzMZ = str;
    }

    public SubscribeRequest(Subscription subscription, boolean z, zzmu zzmuVar, String str) {
        this.zzCY = 2;
        this.zzamM = subscription;
        this.zzamN = z;
        this.zzalN = zzmuVar;
        this.zzMZ = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("subscription", this.zzamM).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzac.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        if (this.zzalN == null) {
            return null;
        }
        return this.zzalN.asBinder();
    }

    public Subscription zzrr() {
        return this.zzamM;
    }

    public boolean zzrs() {
        return this.zzamN;
    }
}
