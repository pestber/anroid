package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class ParentDriveIdSet implements SafeParcelable {
    public static final Parcelable.Creator<ParentDriveIdSet> CREATOR = new zzk();
    final int zzCY;
    final List<PartialDriveId> zzagJ;

    public ParentDriveIdSet() {
        this(1, new ArrayList());
    }

    ParentDriveIdSet(int i, List<PartialDriveId> list) {
        this.zzCY = i;
        this.zzagJ = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public Set<DriveId> zzC(long j) {
        HashSet hashSet = new HashSet();
        Iterator<PartialDriveId> it = this.zzagJ.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().zzD(j));
        }
        return hashSet;
    }

    public void zza(PartialDriveId partialDriveId) {
        this.zzagJ.add(partialDriveId);
    }
}
