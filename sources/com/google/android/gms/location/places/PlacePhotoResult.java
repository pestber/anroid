package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public class PlacePhotoResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<PlacePhotoResult> CREATOR = new zzj();
    private final Bitmap mBitmap;
    final int zzCY;
    private final Status zzOt;
    final BitmapTeleporter zzazJ;

    PlacePhotoResult(int i, Status status, BitmapTeleporter bitmapTeleporter) {
        this.zzCY = i;
        this.zzOt = status;
        this.zzazJ = bitmapTeleporter;
        this.mBitmap = this.zzazJ != null ? bitmapTeleporter.zznc() : null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzOt;
    }

    public String toString() {
        return zzt.zzt(this).zzg("status", this.zzOt).zzg("bitmap", this.mBitmap).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
