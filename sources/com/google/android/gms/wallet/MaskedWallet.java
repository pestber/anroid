package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.identity.intents.model.UserAddress;

/* loaded from: classes.dex */
public final class MaskedWallet implements SafeParcelable {
    public static final Parcelable.Creator<MaskedWallet> CREATOR = new zzk();
    private final int zzCY;
    String zzaQm;
    String zzaQn;
    String zzaQp;
    Address zzaQq;
    Address zzaQr;
    String[] zzaQs;
    UserAddress zzaQt;
    UserAddress zzaQu;
    InstrumentInfo[] zzaQv;
    LoyaltyWalletObject[] zzaRf;
    OfferWalletObject[] zzaRg;

    public final class Builder {
        private Builder() {
        }

        public MaskedWallet build() {
            return MaskedWallet.this;
        }

        public Builder setBillingAddress(Address address) {
            MaskedWallet.this.zzaQq = address;
            return this;
        }

        public Builder setBuyerBillingAddress(UserAddress userAddress) {
            MaskedWallet.this.zzaQt = userAddress;
            return this;
        }

        public Builder setBuyerShippingAddress(UserAddress userAddress) {
            MaskedWallet.this.zzaQu = userAddress;
            return this;
        }

        public Builder setEmail(String str) {
            MaskedWallet.this.zzaQp = str;
            return this;
        }

        public Builder setGoogleTransactionId(String str) {
            MaskedWallet.this.zzaQm = str;
            return this;
        }

        public Builder setInstrumentInfos(InstrumentInfo[] instrumentInfoArr) {
            MaskedWallet.this.zzaQv = instrumentInfoArr;
            return this;
        }

        public Builder setLoyaltyWalletObjects(LoyaltyWalletObject[] loyaltyWalletObjectArr) {
            MaskedWallet.this.zzaRf = loyaltyWalletObjectArr;
            return this;
        }

        public Builder setMerchantTransactionId(String str) {
            MaskedWallet.this.zzaQn = str;
            return this;
        }

        public Builder setOfferWalletObjects(OfferWalletObject[] offerWalletObjectArr) {
            MaskedWallet.this.zzaRg = offerWalletObjectArr;
            return this;
        }

        public Builder setPaymentDescriptions(String[] strArr) {
            MaskedWallet.this.zzaQs = strArr;
            return this;
        }

        public Builder setShippingAddress(Address address) {
            MaskedWallet.this.zzaQr = address;
            return this;
        }
    }

    private MaskedWallet() {
        this.zzCY = 2;
    }

    MaskedWallet(int i, String str, String str2, String[] strArr, String str3, Address address, Address address2, LoyaltyWalletObject[] loyaltyWalletObjectArr, OfferWalletObject[] offerWalletObjectArr, UserAddress userAddress, UserAddress userAddress2, InstrumentInfo[] instrumentInfoArr) {
        this.zzCY = i;
        this.zzaQm = str;
        this.zzaQn = str2;
        this.zzaQs = strArr;
        this.zzaQp = str3;
        this.zzaQq = address;
        this.zzaQr = address2;
        this.zzaRf = loyaltyWalletObjectArr;
        this.zzaRg = offerWalletObjectArr;
        this.zzaQt = userAddress;
        this.zzaQu = userAddress2;
        this.zzaQv = instrumentInfoArr;
    }

    public static Builder newBuilderFrom(MaskedWallet maskedWallet) {
        zzu.zzu(maskedWallet);
        return zzAJ().setGoogleTransactionId(maskedWallet.getGoogleTransactionId()).setMerchantTransactionId(maskedWallet.getMerchantTransactionId()).setPaymentDescriptions(maskedWallet.getPaymentDescriptions()).setInstrumentInfos(maskedWallet.getInstrumentInfos()).setEmail(maskedWallet.getEmail()).setLoyaltyWalletObjects(maskedWallet.getLoyaltyWalletObjects()).setOfferWalletObjects(maskedWallet.getOfferWalletObjects()).setBuyerBillingAddress(maskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(maskedWallet.getBuyerShippingAddress());
    }

    public static Builder zzAJ() {
        MaskedWallet maskedWallet = new MaskedWallet();
        maskedWallet.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public Address getBillingAddress() {
        return this.zzaQq;
    }

    public UserAddress getBuyerBillingAddress() {
        return this.zzaQt;
    }

    public UserAddress getBuyerShippingAddress() {
        return this.zzaQu;
    }

    public String getEmail() {
        return this.zzaQp;
    }

    public String getGoogleTransactionId() {
        return this.zzaQm;
    }

    public InstrumentInfo[] getInstrumentInfos() {
        return this.zzaQv;
    }

    public LoyaltyWalletObject[] getLoyaltyWalletObjects() {
        return this.zzaRf;
    }

    public String getMerchantTransactionId() {
        return this.zzaQn;
    }

    public OfferWalletObject[] getOfferWalletObjects() {
        return this.zzaRg;
    }

    public String[] getPaymentDescriptions() {
        return this.zzaQs;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.zzaQr;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
