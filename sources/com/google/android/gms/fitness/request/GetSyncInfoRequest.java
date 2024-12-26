package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmv;

/* loaded from: classes.dex */
public class GetSyncInfoRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetSyncInfoRequest> CREATOR = new zzm();
    private final int zzCY;
    private final String zzMZ;
    private final zzmv zzaml;

    GetSyncInfoRequest(int i, IBinder iBinder, String str) {
        this.zzCY = i;
        this.zzaml = zzmv.zza.zzbG(iBinder);
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
        return String.format("GetSyncInfoRequest {%d, %s, %s}", Integer.valueOf(this.zzCY), this.zzaml, this.zzMZ);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        return this.zzaml.asBinder();
    }
}
