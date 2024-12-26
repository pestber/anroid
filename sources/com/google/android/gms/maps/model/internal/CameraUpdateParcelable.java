package com.google.android.gms.maps.model.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class CameraUpdateParcelable implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    private int type;
    private final int zzCY;
    private Bundle zzaDN;

    CameraUpdateParcelable(int i, int i2, Bundle bundle) {
        this.zzCY = i;
        this.type = i2;
        this.zzaDN = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getParameters() {
        return this.zzaDN;
    }

    public int getType() {
        return this.type;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
