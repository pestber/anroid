package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.WriteAwareParcelable;
import java.util.List;

/* loaded from: classes.dex */
public class OnChangesResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Parcelable.Creator<OnChangesResponse> CREATOR = new zzat();
    final int zzCY;
    final DataHolder zzaga;
    final List<DriveId> zzagb;
    final ChangeSequenceNumber zzagc;
    final boolean zzagd;

    OnChangesResponse(int i, DataHolder dataHolder, List<DriveId> list, ChangeSequenceNumber changeSequenceNumber, boolean z) {
        this.zzCY = i;
        this.zzaga = dataHolder;
        this.zzagb = list;
        this.zzagc = changeSequenceNumber;
        this.zzagd = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.drive.WriteAwareParcelable
    protected void zzI(Parcel parcel, int i) {
        zzat.zza(this, parcel, i | 1);
    }
}
