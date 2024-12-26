package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class GetChangesRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetChangesRequest> CREATOR = new zzaf();
    final int zzCY;
    final List<DriveSpace> zzadR;
    private final Set<DriveSpace> zzadS;
    final ChangeSequenceNumber zzafJ;
    final int zzafK;

    GetChangesRequest(int i, ChangeSequenceNumber changeSequenceNumber, int i2, List<DriveSpace> list) {
        this(i, changeSequenceNumber, i2, list, list == null ? null : new HashSet(list));
    }

    private GetChangesRequest(int i, ChangeSequenceNumber changeSequenceNumber, int i2, List<DriveSpace> list, Set<DriveSpace> set) {
        this.zzCY = i;
        this.zzafJ = changeSequenceNumber;
        this.zzafK = i2;
        this.zzadR = list;
        this.zzadS = set;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaf.zza(this, parcel, i);
    }
}
