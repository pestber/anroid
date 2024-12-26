package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class WalletObjectMessage implements SafeParcelable {
    public static final Parcelable.Creator<WalletObjectMessage> CREATOR = new zzi();
    String zzCI;
    private final int zzCY;
    String zzaSG;
    TimeInterval zzaSJ;
    UriData zzaSK;
    UriData zzaSL;

    WalletObjectMessage() {
        this.zzCY = 1;
    }

    WalletObjectMessage(int i, String str, String str2, TimeInterval timeInterval, UriData uriData, UriData uriData2) {
        this.zzCY = i;
        this.zzaSG = str;
        this.zzCI = str2;
        this.zzaSJ = timeInterval;
        this.zzaSK = uriData;
        this.zzaSL = uriData2;
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
        zzi.zza(this, parcel, i);
    }
}
