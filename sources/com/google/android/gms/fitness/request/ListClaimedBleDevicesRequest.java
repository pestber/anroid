package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzni;

/* loaded from: classes.dex */
public class ListClaimedBleDevicesRequest implements SafeParcelable {
    public static final Parcelable.Creator<ListClaimedBleDevicesRequest> CREATOR = new zzo();
    private final int zzCY;
    private final String zzMZ;
    private final zzni zzamm;

    ListClaimedBleDevicesRequest(int i, IBinder iBinder, String str) {
        this.zzCY = i;
        this.zzamm = zzni.zza.zzbH(iBinder);
        this.zzMZ = str;
    }

    public ListClaimedBleDevicesRequest(zzni zzniVar, String str) {
        this.zzCY = 1;
        this.zzamm = zzniVar;
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
        return String.format("ListClaimedBleDevicesRequest", new Object[0]);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        return this.zzamm.asBinder();
    }
}
