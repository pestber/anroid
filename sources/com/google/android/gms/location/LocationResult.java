package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class LocationResult implements SafeParcelable {
    private final int zzCY;
    private final List<Location> zzaya;
    static final List<Location> zzaxZ = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new zzf();

    LocationResult(int i, List<Location> list) {
        this.zzCY = i;
        this.zzaya = list;
    }

    public static LocationResult create(List<Location> list) {
        if (list == null) {
            list = zzaxZ;
        }
        return new LocationResult(2, list);
    }

    public static LocationResult extractResult(Intent intent) {
        if (hasResult(intent)) {
            return (LocationResult) intent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
        }
        return null;
    }

    public static boolean hasResult(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.zzaya.size() != this.zzaya.size()) {
            return false;
        }
        Iterator<Location> it = locationResult.zzaya.iterator();
        Iterator<Location> it2 = this.zzaya.iterator();
        while (it.hasNext()) {
            if (it2.next().getTime() != it.next().getTime()) {
                return false;
            }
        }
        return true;
    }

    public Location getLastLocation() {
        int size = this.zzaya.size();
        if (size == 0) {
            return null;
        }
        return this.zzaya.get(size - 1);
    }

    public List<Location> getLocations() {
        return this.zzaya;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        Iterator<Location> it = this.zzaya.iterator();
        int i = 17;
        while (it.hasNext()) {
            long time = it.next().getTime();
            i = (i * 31) + ((int) (time ^ (time >>> 32)));
        }
        return i;
    }

    public String toString() {
        return "LocationResult[locations: " + this.zzaya + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
