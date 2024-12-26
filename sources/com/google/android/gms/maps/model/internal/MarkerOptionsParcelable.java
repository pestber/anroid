package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class MarkerOptionsParcelable implements SafeParcelable {
    public static final zzm CREATOR = new zzm();
    private final int zzCY;
    private BitmapDescriptorParcelable zzaDQ;

    public MarkerOptionsParcelable() {
        this.zzCY = 1;
    }

    MarkerOptionsParcelable(int i, BitmapDescriptorParcelable bitmapDescriptorParcelable) {
        this.zzCY = i;
        this.zzaDQ = bitmapDescriptorParcelable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    public BitmapDescriptorParcelable zzvO() {
        return this.zzaDQ;
    }
}
