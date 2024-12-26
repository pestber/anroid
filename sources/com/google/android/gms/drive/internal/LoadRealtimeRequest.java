package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

/* loaded from: classes.dex */
public class LoadRealtimeRequest implements SafeParcelable {
    public static final Parcelable.Creator<LoadRealtimeRequest> CREATOR = new zzap();
    final int zzCY;
    final DriveId zzacT;
    final boolean zzafQ;
    final List<String> zzafR;
    final boolean zzafS;
    final DataHolder zzafT;

    LoadRealtimeRequest(int i, DriveId driveId, boolean z, List<String> list, boolean z2, DataHolder dataHolder) {
        this.zzCY = i;
        this.zzacT = driveId;
        this.zzafQ = z;
        this.zzafR = list;
        this.zzafS = z2;
        this.zzafT = dataHolder;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzap.zza(this, parcel, i);
    }
}
