package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class UserDataType implements SafeParcelable {
    final int zzCY;
    final String zzEl;
    final int zzaAd;
    public static final UserDataType zzazZ = zzy("test_type", 1);
    public static final UserDataType zzaAa = zzy("labeled_place", 6);
    public static final UserDataType zzaAb = zzy("here_content", 7);
    public static final Set<UserDataType> zzaAc = Collections.unmodifiableSet(new HashSet(Arrays.asList(zzazZ, zzaAa, zzaAb)));
    public static final zzn CREATOR = new zzn();

    UserDataType(int i, String str, int i2) {
        zzu.zzcj(str);
        this.zzCY = i;
        this.zzEl = str;
        this.zzaAd = i2;
    }

    private static UserDataType zzy(String str, int i) {
        return new UserDataType(0, str, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserDataType)) {
            return false;
        }
        UserDataType userDataType = (UserDataType) obj;
        return this.zzEl.equals(userDataType.zzEl) && this.zzaAd == userDataType.zzaAd;
    }

    public int hashCode() {
        return this.zzEl.hashCode();
    }

    public String toString() {
        return this.zzEl;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }
}
