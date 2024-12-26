package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class MaskedWalletRequest implements SafeParcelable {
    public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new zzl();
    private final int zzCY;
    String zzaQg;
    String zzaQn;
    Cart zzaQx;
    boolean zzaRi;
    boolean zzaRj;
    boolean zzaRk;
    String zzaRl;
    String zzaRm;
    boolean zzaRn;
    boolean zzaRo;
    CountrySpecification[] zzaRp;
    boolean zzaRq;
    boolean zzaRr;
    ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> zzaRs;
    PaymentMethodTokenizationParameters zzaRt;
    ArrayList<Integer> zzaRu;

    public final class Builder {
        private Builder() {
        }

        public Builder addAllowedCardNetwork(int i) {
            if (MaskedWalletRequest.this.zzaRu == null) {
                MaskedWalletRequest.this.zzaRu = new ArrayList<>();
            }
            MaskedWalletRequest.this.zzaRu.add(Integer.valueOf(i));
            return this;
        }

        public Builder addAllowedCardNetworks(Collection<Integer> collection) {
            if (collection != null) {
                if (MaskedWalletRequest.this.zzaRu == null) {
                    MaskedWalletRequest.this.zzaRu = new ArrayList<>();
                }
                MaskedWalletRequest.this.zzaRu.addAll(collection);
            }
            return this;
        }

        public Builder addAllowedCountrySpecificationForShipping(com.google.android.gms.identity.intents.model.CountrySpecification countrySpecification) {
            if (MaskedWalletRequest.this.zzaRs == null) {
                MaskedWalletRequest.this.zzaRs = new ArrayList<>();
            }
            MaskedWalletRequest.this.zzaRs.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecificationsForShipping(Collection<com.google.android.gms.identity.intents.model.CountrySpecification> collection) {
            if (collection != null) {
                if (MaskedWalletRequest.this.zzaRs == null) {
                    MaskedWalletRequest.this.zzaRs = new ArrayList<>();
                }
                MaskedWalletRequest.this.zzaRs.addAll(collection);
            }
            return this;
        }

        public MaskedWalletRequest build() {
            return MaskedWalletRequest.this;
        }

        public Builder setAllowDebitCard(boolean z) {
            MaskedWalletRequest.this.zzaRr = z;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean z) {
            MaskedWalletRequest.this.zzaRq = z;
            return this;
        }

        public Builder setCart(Cart cart) {
            MaskedWalletRequest.this.zzaQx = cart;
            return this;
        }

        public Builder setCurrencyCode(String str) {
            MaskedWalletRequest.this.zzaQg = str;
            return this;
        }

        public Builder setEstimatedTotalPrice(String str) {
            MaskedWalletRequest.this.zzaRl = str;
            return this;
        }

        public Builder setIsBillingAgreement(boolean z) {
            MaskedWalletRequest.this.zzaRo = z;
            return this;
        }

        public Builder setMerchantName(String str) {
            MaskedWalletRequest.this.zzaRm = str;
            return this;
        }

        public Builder setMerchantTransactionId(String str) {
            MaskedWalletRequest.this.zzaQn = str;
            return this;
        }

        public Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paymentMethodTokenizationParameters) {
            MaskedWalletRequest.this.zzaRt = paymentMethodTokenizationParameters;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean z) {
            MaskedWalletRequest.this.zzaRi = z;
            return this;
        }

        public Builder setShippingAddressRequired(boolean z) {
            MaskedWalletRequest.this.zzaRj = z;
            return this;
        }

        public Builder setShouldRetrieveWalletObjects(boolean z) {
            MaskedWalletRequest.this.zzaRn = z;
            return this;
        }

        public Builder setUseMinimalBillingAddress(boolean z) {
            MaskedWalletRequest.this.zzaRk = z;
            return this;
        }
    }

    MaskedWalletRequest() {
        this.zzCY = 3;
        this.zzaRq = true;
        this.zzaRr = true;
    }

    MaskedWalletRequest(int i, String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4, Cart cart, boolean z4, boolean z5, CountrySpecification[] countrySpecificationArr, boolean z6, boolean z7, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> arrayList, PaymentMethodTokenizationParameters paymentMethodTokenizationParameters, ArrayList<Integer> arrayList2) {
        this.zzCY = i;
        this.zzaQn = str;
        this.zzaRi = z;
        this.zzaRj = z2;
        this.zzaRk = z3;
        this.zzaRl = str2;
        this.zzaQg = str3;
        this.zzaRm = str4;
        this.zzaQx = cart;
        this.zzaRn = z4;
        this.zzaRo = z5;
        this.zzaRp = countrySpecificationArr;
        this.zzaRq = z6;
        this.zzaRr = z7;
        this.zzaRs = arrayList;
        this.zzaRt = paymentMethodTokenizationParameters;
        this.zzaRu = arrayList2;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder();
    }

    public boolean allowDebitCard() {
        return this.zzaRr;
    }

    public boolean allowPrepaidCard() {
        return this.zzaRq;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<Integer> getAllowedCardNetworks() {
        return this.zzaRu;
    }

    public ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.zzaRs;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.zzaRp;
    }

    public Cart getCart() {
        return this.zzaQx;
    }

    public String getCurrencyCode() {
        return this.zzaQg;
    }

    public String getEstimatedTotalPrice() {
        return this.zzaRl;
    }

    public String getMerchantName() {
        return this.zzaRm;
    }

    public String getMerchantTransactionId() {
        return this.zzaQn;
    }

    public PaymentMethodTokenizationParameters getPaymentMethodTokenizationParameters() {
        return this.zzaRt;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public boolean isBillingAgreement() {
        return this.zzaRo;
    }

    public boolean isPhoneNumberRequired() {
        return this.zzaRi;
    }

    public boolean isShippingAddressRequired() {
        return this.zzaRj;
    }

    public boolean shouldRetrieveWalletObjects() {
        return this.zzaRn;
    }

    public boolean useMinimalBillingAddress() {
        return this.zzaRk;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }
}
