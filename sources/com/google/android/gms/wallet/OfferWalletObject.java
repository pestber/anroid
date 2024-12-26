package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

/* loaded from: classes.dex */
public final class OfferWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<OfferWalletObject> CREATOR = new zzn();
    private final int zzCY;
    CommonWalletObject zzaQz;
    String zzaRy;
    String zzhI;

    OfferWalletObject() {
        this.zzCY = 3;
    }

    OfferWalletObject(int i, String str, String str2, CommonWalletObject commonWalletObject) {
        this.zzCY = i;
        this.zzaRy = str2;
        if (i < 3) {
            this.zzaQz = CommonWalletObject.zzAN().zzff(str).zzAO();
        } else {
            this.zzaQz = commonWalletObject;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzaQz.getId();
    }

    public String getRedemptionCode() {
        return this.zzaRy;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }
}
