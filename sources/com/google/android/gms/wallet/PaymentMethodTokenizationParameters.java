package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

/* loaded from: classes.dex */
public final class PaymentMethodTokenizationParameters implements SafeParcelable {
    public static final Parcelable.Creator<PaymentMethodTokenizationParameters> CREATOR = new zzp();
    private final int zzCY;
    Bundle zzaDN;
    int zzaRz;

    public final class Builder {
        private Builder() {
        }

        public Builder addParameter(String str, String str2) {
            zzu.zzh(str, "Tokenization parameter name must not be empty");
            zzu.zzh(str2, "Tokenization parameter value must not be empty");
            PaymentMethodTokenizationParameters.this.zzaDN.putString(str, str2);
            return this;
        }

        public PaymentMethodTokenizationParameters build() {
            return PaymentMethodTokenizationParameters.this;
        }

        public Builder setPaymentMethodTokenizationType(int i) {
            PaymentMethodTokenizationParameters.this.zzaRz = i;
            return this;
        }
    }

    private PaymentMethodTokenizationParameters() {
        this.zzaDN = new Bundle();
        this.zzCY = 1;
    }

    PaymentMethodTokenizationParameters(int i, int i2, Bundle bundle) {
        this.zzaDN = new Bundle();
        this.zzCY = i;
        this.zzaRz = i2;
        this.zzaDN = bundle;
    }

    public static Builder newBuilder() {
        PaymentMethodTokenizationParameters paymentMethodTokenizationParameters = new PaymentMethodTokenizationParameters();
        paymentMethodTokenizationParameters.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getParameters() {
        return new Bundle(this.zzaDN);
    }

    public int getPaymentMethodTokenizationType() {
        return this.zzaRz;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
