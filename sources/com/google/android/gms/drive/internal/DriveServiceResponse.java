package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class DriveServiceResponse implements SafeParcelable {
    public static final Parcelable.Creator<DriveServiceResponse> CREATOR = new zzab();
    final int zzCY;
    final IBinder zzafB;

    DriveServiceResponse(int i, IBinder iBinder) {
        this.zzCY = i;
        this.zzafB = iBinder;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzab.zza(this, parcel, i);
    }

    public ICancelToken zzpF() {
        return ICancelToken.zza.zzaE(this.zzafB);
    }
}
