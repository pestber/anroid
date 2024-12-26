package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class BitmapDescriptorParcelable implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final int zzCY;
    private byte zzaDM;
    private Bundle zzaDN;
    private Bitmap zzaDO;

    BitmapDescriptorParcelable(int i, byte b, Bundle bundle, Bitmap bitmap) {
        this.zzCY = i;
        this.zzaDM = b;
        this.zzaDN = bundle;
        this.zzaDO = bitmap;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bitmap getBitmap() {
        return this.zzaDO;
    }

    public Bundle getParameters() {
        return this.zzaDN;
    }

    public byte getType() {
        return this.zzaDM;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
