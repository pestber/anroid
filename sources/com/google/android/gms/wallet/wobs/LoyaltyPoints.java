package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class LoyaltyPoints implements SafeParcelable {
    public static final Parcelable.Creator<LoyaltyPoints> CREATOR = new zze();
    String label;
    String type;
    private final int zzCY;
    TimeInterval zzaQV;
    LoyaltyPointsBalance zzaSA;

    LoyaltyPoints() {
        this.zzCY = 1;
    }

    LoyaltyPoints(int i, String str, LoyaltyPointsBalance loyaltyPointsBalance, String str2, TimeInterval timeInterval) {
        this.zzCY = i;
        this.label = str;
        this.zzaSA = loyaltyPointsBalance;
        this.type = str2;
        this.zzaQV = timeInterval;
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
        zze.zza(this, parcel, i);
    }
}
