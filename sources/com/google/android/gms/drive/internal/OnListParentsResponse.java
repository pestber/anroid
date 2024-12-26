package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

/* loaded from: classes.dex */
public class OnListParentsResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Parcelable.Creator<OnListParentsResponse> CREATOR = new zzbc();
    final int zzCY;
    final DataHolder zzagq;

    OnListParentsResponse(int i, DataHolder dataHolder) {
        this.zzCY = i;
        this.zzagq = dataHolder;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.drive.WriteAwareParcelable
    protected void zzI(Parcel parcel, int i) {
        zzbc.zza(this, parcel, i);
    }

    public DataHolder zzpR() {
        return this.zzagq;
    }
}
