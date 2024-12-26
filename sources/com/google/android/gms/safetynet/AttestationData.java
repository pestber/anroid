package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class AttestationData implements SafeParcelable {
    public static final Parcelable.Creator<AttestationData> CREATOR = new zza();
    public final int zzCY;
    private String zzaJx;

    AttestationData(int i, String str) {
        this.zzCY = i;
        this.zzaJx = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getJwsResult() {
        return this.zzaJx;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
