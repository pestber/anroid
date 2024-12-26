package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public final class LocationAvailability implements SafeParcelable {
    public static final LocationAvailabilityCreator CREATOR = new LocationAvailabilityCreator();
    private final int zzCY;
    int zzaxQ;
    int zzaxR;
    long zzaxS;
    int zzaxT;

    LocationAvailability(int i, int i2, int i3, int i4, long j) {
        this.zzCY = i;
        this.zzaxT = i2;
        this.zzaxQ = i3;
        this.zzaxR = i4;
        this.zzaxS = j;
    }

    public static LocationAvailability extractLocationAvailability(Intent intent) {
        if (hasLocationAvailability(intent)) {
            return (LocationAvailability) intent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
        }
        return null;
    }

    public static boolean hasLocationAvailability(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationAvailability)) {
            return false;
        }
        LocationAvailability locationAvailability = (LocationAvailability) obj;
        return this.zzaxT == locationAvailability.zzaxT && this.zzaxQ == locationAvailability.zzaxQ && this.zzaxR == locationAvailability.zzaxR && this.zzaxS == locationAvailability.zzaxS;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.zzaxT), Integer.valueOf(this.zzaxQ), Integer.valueOf(this.zzaxR), Long.valueOf(this.zzaxS));
    }

    public boolean isLocationAvailable() {
        return this.zzaxT < 1000;
    }

    public String toString() {
        return "LocationAvailability[isLocationAvailable: " + isLocationAvailable() + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        LocationAvailabilityCreator.zza(this, parcel, i);
    }
}
