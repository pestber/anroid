package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public class ApplicationStatus implements SafeParcelable {
    public static final Parcelable.Creator<ApplicationStatus> CREATOR = new zza();
    private final int zzCY;
    private String zzUd;

    public ApplicationStatus() {
        this(1, null);
    }

    ApplicationStatus(int i, String str) {
        this.zzCY = i;
        this.zzUd = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ApplicationStatus) {
            return zzf.zza(this.zzUd, ((ApplicationStatus) obj).zzUd);
        }
        return false;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzUd);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzlI() {
        return this.zzUd;
    }
}
