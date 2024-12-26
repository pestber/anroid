package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class InstrumentInfo implements SafeParcelable {
    public static final Parcelable.Creator<InstrumentInfo> CREATOR = new zzh();
    private final int zzCY;
    private String zzaQG;
    private String zzaQH;

    InstrumentInfo(int i, String str, String str2) {
        this.zzCY = i;
        this.zzaQG = str;
        this.zzaQH = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getInstrumentDetails() {
        return this.zzaQH;
    }

    public String getInstrumentType() {
        return this.zzaQG;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
