package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class GroundOverlayOptionsParcelable implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    private final int zzCY;
    private BitmapDescriptorParcelable zzaDP;

    public GroundOverlayOptionsParcelable() {
        this.zzCY = 1;
    }

    GroundOverlayOptionsParcelable(int i, BitmapDescriptorParcelable bitmapDescriptorParcelable) {
        this.zzCY = i;
        this.zzaDP = bitmapDescriptorParcelable;
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
        zzc.zza(this, parcel, i);
    }

    public BitmapDescriptorParcelable zzvM() {
        return this.zzaDP;
    }
}
