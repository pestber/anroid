package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class LoyaltyPointsBalance implements SafeParcelable {
    public static final Parcelable.Creator<LoyaltyPointsBalance> CREATOR = new zzd();
    private final int zzCY;
    String zzaQD;
    int zzaSB;
    String zzaSC;
    double zzaSD;
    long zzaSE;
    int zzaSF;

    LoyaltyPointsBalance() {
        this.zzCY = 1;
        this.zzaSF = -1;
        this.zzaSB = -1;
        this.zzaSD = -1.0d;
    }

    LoyaltyPointsBalance(int i, int i2, String str, double d, String str2, long j, int i3) {
        this.zzCY = i;
        this.zzaSB = i2;
        this.zzaSC = str;
        this.zzaSD = d;
        this.zzaQD = str2;
        this.zzaSE = j;
        this.zzaSF = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
