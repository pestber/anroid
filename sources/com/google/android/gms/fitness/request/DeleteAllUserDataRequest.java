package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmu;

/* loaded from: classes.dex */
public class DeleteAllUserDataRequest implements SafeParcelable {
    public static final Parcelable.Creator<DeleteAllUserDataRequest> CREATOR = new zzk();
    private final int zzCY;
    private final String zzMZ;
    private final zzmu zzalN;

    DeleteAllUserDataRequest(int i, IBinder iBinder, String str) {
        this.zzCY = i;
        this.zzalN = zzmu.zza.zzbF(iBinder);
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
        return String.format("DisableFitRequest", new Object[0]);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        return this.zzalN.asBinder();
    }
}
