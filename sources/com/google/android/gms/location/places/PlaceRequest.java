package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class PlaceRequest implements SafeParcelable {
    public static final Parcelable.Creator<PlaceRequest> CREATOR = new zzl();
    static final long zzazM = TimeUnit.HOURS.toMillis(1);
    private final int mPriority;
    final int zzCY;
    private final long zzaxU;
    private final long zzaxz;
    private final PlaceFilter zzazN;

    public PlaceRequest(int i, PlaceFilter placeFilter, long j, int i2, long j2) {
        this.zzCY = i;
        this.zzazN = placeFilter;
        this.zzaxU = j;
        this.mPriority = i2;
        this.zzaxz = j2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceRequest)) {
            return false;
        }
        PlaceRequest placeRequest = (PlaceRequest) obj;
        return zzt.equal(this.zzazN, placeRequest.zzazN) && this.zzaxU == placeRequest.zzaxU && this.mPriority == placeRequest.mPriority && this.zzaxz == placeRequest.zzaxz;
    }

    public long getExpirationTime() {
        return this.zzaxz;
    }

    public long getInterval() {
        return this.zzaxU;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzazN, Long.valueOf(this.zzaxU), Integer.valueOf(this.mPriority), Long.valueOf(this.zzaxz));
    }

    public String toString() {
        return zzt.zzt(this).zzg("filter", this.zzazN).zzg("interval", Long.valueOf(this.zzaxU)).zzg("priority", Integer.valueOf(this.mPriority)).zzg("expireAt", Long.valueOf(this.zzaxz)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }

    public PlaceFilter zzuG() {
        return this.zzazN;
    }
}
