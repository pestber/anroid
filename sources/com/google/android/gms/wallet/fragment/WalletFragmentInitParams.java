package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

/* loaded from: classes.dex */
public final class WalletFragmentInitParams implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentInitParams> CREATOR = new zza();
    final int zzCY;
    private String zzOx;
    private MaskedWalletRequest zzaRU;
    private MaskedWallet zzaRV;
    private int zzaSi;

    public final class Builder {
        private Builder() {
        }

        public WalletFragmentInitParams build() {
            zzu.zza((WalletFragmentInitParams.this.zzaRV != null && WalletFragmentInitParams.this.zzaRU == null) || (WalletFragmentInitParams.this.zzaRV == null && WalletFragmentInitParams.this.zzaRU != null), "Exactly one of MaskedWallet or MaskedWalletRequest is required");
            zzu.zza(WalletFragmentInitParams.this.zzaSi >= 0, "masked wallet request code is required and must be non-negative");
            return WalletFragmentInitParams.this;
        }

        public Builder setAccountName(String str) {
            WalletFragmentInitParams.this.zzOx = str;
            return this;
        }

        public Builder setMaskedWallet(MaskedWallet maskedWallet) {
            WalletFragmentInitParams.this.zzaRV = maskedWallet;
            return this;
        }

        public Builder setMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
            WalletFragmentInitParams.this.zzaRU = maskedWalletRequest;
            return this;
        }

        public Builder setMaskedWalletRequestCode(int i) {
            WalletFragmentInitParams.this.zzaSi = i;
            return this;
        }
    }

    private WalletFragmentInitParams() {
        this.zzCY = 1;
        this.zzaSi = -1;
    }

    WalletFragmentInitParams(int i, String str, MaskedWalletRequest maskedWalletRequest, int i2, MaskedWallet maskedWallet) {
        this.zzCY = i;
        this.zzOx = str;
        this.zzaRU = maskedWalletRequest;
        this.zzaSi = i2;
        this.zzaRV = maskedWallet;
    }

    public static Builder newBuilder() {
        WalletFragmentInitParams walletFragmentInitParams = new WalletFragmentInitParams();
        walletFragmentInitParams.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.zzOx;
    }

    public MaskedWallet getMaskedWallet() {
        return this.zzaRV;
    }

    public MaskedWalletRequest getMaskedWalletRequest() {
        return this.zzaRU;
    }

    public int getMaskedWalletRequestCode() {
        return this.zzaSi;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
