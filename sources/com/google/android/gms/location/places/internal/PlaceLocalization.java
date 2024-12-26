package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public final class PlaceLocalization implements SafeParcelable {
    public static final zzn CREATOR = new zzn();
    public final String name;
    public final int versionCode;
    public final String zzaAM;
    public final String zzaAN;
    public final String zzaAO;
    public final List<String> zzaAP;

    public PlaceLocalization(int i, String str, String str2, String str3, String str4, List<String> list) {
        this.versionCode = i;
        this.name = str;
        this.zzaAM = str2;
        this.zzaAN = str3;
        this.zzaAO = str4;
        this.zzaAP = list;
    }

    public static PlaceLocalization zza(String str, String str2, String str3, String str4, List<String> list) {
        return new PlaceLocalization(0, str, str2, str3, str4, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceLocalization)) {
            return false;
        }
        PlaceLocalization placeLocalization = (PlaceLocalization) obj;
        return com.google.android.gms.common.internal.zzt.equal(this.name, placeLocalization.name) && com.google.android.gms.common.internal.zzt.equal(this.zzaAM, placeLocalization.zzaAM) && com.google.android.gms.common.internal.zzt.equal(this.zzaAN, placeLocalization.zzaAN) && com.google.android.gms.common.internal.zzt.equal(this.zzaAO, placeLocalization.zzaAO) && com.google.android.gms.common.internal.zzt.equal(this.zzaAP, placeLocalization.zzaAP);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.name, this.zzaAM, this.zzaAN, this.zzaAO);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("name", this.name).zzg("address", this.zzaAM).zzg("internationalPhoneNumber", this.zzaAN).zzg("regularOpenHours", this.zzaAO).zzg("attributions", this.zzaAP).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }
}
