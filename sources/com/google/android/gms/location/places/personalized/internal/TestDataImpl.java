package com.google.android.gms.location.places.personalized.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.location.places.personalized.zzf;

/* loaded from: classes.dex */
public class TestDataImpl extends zzf implements SafeParcelable {
    public static final zza CREATOR = new zza();
    final int zzCY;
    private final String zzaBm;

    TestDataImpl(int i, String str) {
        this.zzCY = i;
        this.zzaBm = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TestDataImpl) {
            return this.zzaBm.equals(((TestDataImpl) obj).zzaBm);
        }
        return false;
    }

    public int hashCode() {
        return this.zzaBm.hashCode();
    }

    public String toString() {
        return zzt.zzt(this).zzg("testName", this.zzaBm).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzvf() {
        return this.zzaBm;
    }
}
