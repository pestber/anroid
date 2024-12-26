package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

/* loaded from: classes.dex */
public final class Scope implements SafeParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zzj();
    final int zzCY;
    private final String zzXO;

    Scope(int i, String str) {
        zzu.zzh(str, "scopeUri must not be null or empty");
        this.zzCY = i;
        this.zzXO = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.zzXO.equals(((Scope) obj).zzXO);
        }
        return false;
    }

    public int hashCode() {
        return this.zzXO.hashCode();
    }

    public String toString() {
        return this.zzXO;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public String zzmS() {
        return this.zzXO;
    }
}
