package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public class PlaceAlias implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public static final PlaceAlias zzaBg = new PlaceAlias(0, "Home");
    public static final PlaceAlias zzaBh = new PlaceAlias(0, "Work");
    final int zzCY;
    private final String zzaBi;

    PlaceAlias(int i, String str) {
        this.zzCY = i;
        this.zzaBi = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlaceAlias) {
            return zzt.equal(this.zzaBi, ((PlaceAlias) obj).zzaBi);
        }
        return false;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzaBi);
    }

    public String toString() {
        return zzt.zzt(this).zzg("alias", this.zzaBi).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public String zzva() {
        return this.zzaBi;
    }
}
