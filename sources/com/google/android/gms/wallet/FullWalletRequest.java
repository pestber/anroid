package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class FullWalletRequest implements SafeParcelable {
    public static final Parcelable.Creator<FullWalletRequest> CREATOR = new zzf();
    private final int zzCY;
    String zzaQm;
    String zzaQn;
    Cart zzaQx;

    public final class Builder {
        private Builder() {
        }

        public FullWalletRequest build() {
            return FullWalletRequest.this;
        }

        public Builder setCart(Cart cart) {
            FullWalletRequest.this.zzaQx = cart;
            return this;
        }

        public Builder setGoogleTransactionId(String str) {
            FullWalletRequest.this.zzaQm = str;
            return this;
        }

        public Builder setMerchantTransactionId(String str) {
            FullWalletRequest.this.zzaQn = str;
            return this;
        }
    }

    FullWalletRequest() {
        this.zzCY = 1;
    }

    FullWalletRequest(int i, String str, String str2, Cart cart) {
        this.zzCY = i;
        this.zzaQm = str;
        this.zzaQn = str2;
        this.zzaQx = cart;
    }

    public static Builder newBuilder() {
        FullWalletRequest fullWalletRequest = new FullWalletRequest();
        fullWalletRequest.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Cart getCart() {
        return this.zzaQx;
    }

    public String getGoogleTransactionId() {
        return this.zzaQm;
    }

    public String getMerchantTransactionId() {
        return this.zzaQn;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
