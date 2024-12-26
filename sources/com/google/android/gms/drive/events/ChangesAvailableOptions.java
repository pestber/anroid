package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public final class ChangesAvailableOptions implements SafeParcelable {
    public static final Parcelable.Creator<ChangesAvailableOptions> CREATOR = new zzd();
    final int zzCY;
    final int zzadP;
    final boolean zzadQ;
    final List<DriveSpace> zzadR;
    private final Set<DriveSpace> zzadS;

    ChangesAvailableOptions(int i, int i2, boolean z, List<DriveSpace> list) {
        this(i, i2, z, list, list == null ? null : new HashSet(list));
    }

    private ChangesAvailableOptions(int i, int i2, boolean z, List<DriveSpace> list, Set<DriveSpace> set) {
        this.zzCY = i;
        this.zzadP = i2;
        this.zzadQ = z;
        this.zzadR = list;
        this.zzadS = set;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ChangesAvailableOptions changesAvailableOptions = (ChangesAvailableOptions) obj;
        return zzt.equal(this.zzadS, changesAvailableOptions.zzadS) && this.zzadP == changesAvailableOptions.zzadP && this.zzadQ == changesAvailableOptions.zzadQ;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzadS, Integer.valueOf(this.zzadP), Boolean.valueOf(this.zzadQ));
    }

    public String toString() {
        return String.format(Locale.US, "ChangesAvailableOptions[ChangesSizeLimit=%d, Repeats=%s, Spaces=%s]", Integer.valueOf(this.zzadP), Boolean.valueOf(this.zzadQ), this.zzadR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
