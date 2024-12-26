package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmr;

/* loaded from: classes.dex */
public class ReadStatsRequest implements SafeParcelable {
    public static final Parcelable.Creator<ReadStatsRequest> CREATOR = new zzr();
    private final int zzCY;
    private final String zzMZ;
    private final zzmr zzamq;

    ReadStatsRequest(int i, IBinder iBinder, String str) {
        this.zzCY = i;
        this.zzamq = zzmr.zza.zzbC(iBinder);
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
        return String.format("ReadStatsRequest", new Object[0]);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzr.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        return this.zzamq.asBinder();
    }
}
