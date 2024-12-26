package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

/* loaded from: classes.dex */
public class OnListEntriesResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Parcelable.Creator<OnListEntriesResponse> CREATOR = new zzbb();
    final int zzCY;
    final boolean zzaeL;
    final DataHolder zzagp;

    OnListEntriesResponse(int i, DataHolder dataHolder, boolean z) {
        this.zzCY = i;
        this.zzagp = dataHolder;
        this.zzaeL = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.drive.WriteAwareParcelable
    protected void zzI(Parcel parcel, int i) {
        zzbb.zza(this, parcel, i);
    }

    public DataHolder zzpP() {
        return this.zzagp;
    }

    public boolean zzpQ() {
        return this.zzaeL;
    }
}
