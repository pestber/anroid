package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public class CancelPendingActionsRequest implements SafeParcelable {
    public static final Parcelable.Creator<CancelPendingActionsRequest> CREATOR = new zze();
    final int zzCY;
    final List<String> zzadW;

    CancelPendingActionsRequest(int i, List<String> list) {
        this.zzCY = i;
        this.zzadW = list;
    }

    public CancelPendingActionsRequest(List<String> list) {
        this(1, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
