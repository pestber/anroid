package com.google.android.gms.maps.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class Point implements SafeParcelable {
    public static final zzz CREATOR = new zzz();
    private final int versionCode;
    private final android.graphics.Point zzaCO;

    public Point(int i, android.graphics.Point point) {
        this.versionCode = i;
        this.zzaCO = point;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Point) {
            return this.zzaCO.equals(((Point) obj).zzaCO);
        }
        return false;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return this.zzaCO.hashCode();
    }

    public String toString() {
        return this.zzaCO.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzz.zza(this, parcel, i);
    }

    public android.graphics.Point zzvG() {
        return this.zzaCO;
    }
}
