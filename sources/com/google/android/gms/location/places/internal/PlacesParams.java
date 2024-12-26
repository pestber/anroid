package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

/* loaded from: classes.dex */
public class PlacesParams implements SafeParcelable {
    public final int versionCode;
    public final String zzaAZ;
    public final String zzaBa;
    public final String zzaBb;
    public final String zzaBc;
    public final int zzaBd;
    public final String zzazX;
    public static final PlacesParams zzaAY = new PlacesParams("com.google.android.gms", Locale.getDefault(), null);
    public static final zzs CREATOR = new zzs();

    public PlacesParams(int i, String str, String str2, String str3, String str4, String str5, int i2) {
        this.versionCode = i;
        this.zzaAZ = str;
        this.zzaBa = str2;
        this.zzaBb = str3;
        this.zzazX = str4;
        this.zzaBc = str5;
        this.zzaBd = i2;
    }

    public PlacesParams(String str, Locale locale, String str2) {
        this(1, str, locale.toString(), str2, null, null, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public PlacesParams(String str, Locale locale, String str2, String str3, String str4) {
        this(1, str, locale.toString(), str2, str3, str4, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PlacesParams)) {
            return false;
        }
        PlacesParams placesParams = (PlacesParams) obj;
        return this.zzaBa.equals(placesParams.zzaBa) && this.zzaAZ.equals(placesParams.zzaAZ) && com.google.android.gms.common.internal.zzt.equal(this.zzaBb, placesParams.zzaBb) && com.google.android.gms.common.internal.zzt.equal(this.zzazX, placesParams.zzazX) && com.google.android.gms.common.internal.zzt.equal(this.zzaBc, placesParams.zzaBc);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.zzaAZ, this.zzaBa, this.zzaBb, this.zzazX, this.zzaBc);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("clientPackageName", this.zzaAZ).zzg("locale", this.zzaBa).zzg("accountName", this.zzaBb).zzg("gCoreClientName", this.zzazX).zzg("chargedPackageName", this.zzaBc).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzs.zza(this, parcel, i);
    }
}
