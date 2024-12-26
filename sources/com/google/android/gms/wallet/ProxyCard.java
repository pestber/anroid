package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class ProxyCard implements SafeParcelable {
    public static final Parcelable.Creator<ProxyCard> CREATOR = new zzq();
    private final int zzCY;
    String zzaRB;
    String zzaRC;
    int zzaRD;
    int zzaRE;

    ProxyCard(int i, String str, String str2, int i2, int i3) {
        this.zzCY = i;
        this.zzaRB = str;
        this.zzaRC = str2;
        this.zzaRD = i2;
        this.zzaRE = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCvn() {
        return this.zzaRC;
    }

    public int getExpirationMonth() {
        return this.zzaRD;
    }

    public int getExpirationYear() {
        return this.zzaRE;
    }

    public String getPan() {
        return this.zzaRB;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzq.zza(this, parcel, i);
    }
}
