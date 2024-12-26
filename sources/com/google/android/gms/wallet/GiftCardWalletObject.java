package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

/* loaded from: classes.dex */
public final class GiftCardWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<GiftCardWalletObject> CREATOR = new zzg();
    String pin;
    final int zzCY;
    String zzaQA;
    String zzaQB;
    long zzaQC;
    String zzaQD;
    long zzaQE;
    String zzaQF;
    CommonWalletObject zzaQz;

    GiftCardWalletObject() {
        this.zzaQz = CommonWalletObject.zzAN().zzAO();
        this.zzCY = 1;
    }

    GiftCardWalletObject(int i, CommonWalletObject commonWalletObject, String str, String str2, String str3, long j, String str4, long j2, String str5) {
        this.zzaQz = CommonWalletObject.zzAN().zzAO();
        this.zzCY = i;
        this.zzaQz = commonWalletObject;
        this.zzaQA = str;
        this.pin = str2;
        this.zzaQC = j;
        this.zzaQD = str4;
        this.zzaQE = j2;
        this.zzaQF = str5;
        this.zzaQB = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzaQz.getId();
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
