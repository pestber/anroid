package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class PaymentMethodToken implements SafeParcelable {
    public static final Parcelable.Creator<PaymentMethodToken> CREATOR = new zzo();
    private final int zzCY;
    String zzaFl;
    int zzaRz;

    private PaymentMethodToken() {
        this.zzCY = 1;
    }

    PaymentMethodToken(int i, int i2, String str) {
        this.zzCY = i;
        this.zzaRz = i2;
        this.zzaFl = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPaymentMethodTokenizationType() {
        return this.zzaRz;
    }

    public String getToken() {
        return this.zzaFl;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }
}
