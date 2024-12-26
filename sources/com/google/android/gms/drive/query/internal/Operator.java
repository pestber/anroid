package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class Operator implements SafeParcelable {
    public static final Parcelable.Creator<Operator> CREATOR = new zzn();
    public static final Operator zzaih = new Operator("=");
    public static final Operator zzaii = new Operator("<");
    public static final Operator zzaij = new Operator("<=");
    public static final Operator zzaik = new Operator(">");
    public static final Operator zzail = new Operator(">=");
    public static final Operator zzaim = new Operator("and");
    public static final Operator zzain = new Operator("or");
    public static final Operator zzaio = new Operator("not");
    public static final Operator zzaip = new Operator("contains");
    final String mTag;
    final int zzCY;

    Operator(int i, String str) {
        this.zzCY = i;
        this.mTag = str;
    }

    private Operator(String str) {
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
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Operator operator = (Operator) obj;
        if (this.mTag == null) {
            if (operator.mTag != null) {
                return false;
            }
        } else if (!this.mTag.equals(operator.mTag)) {
            return false;
        }
        return true;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return 31 + (this.mTag == null ? 0 : this.mTag.hashCode());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }
}
