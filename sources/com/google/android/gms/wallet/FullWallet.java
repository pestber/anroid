package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

/* loaded from: classes.dex */
public final class FullWallet implements SafeParcelable {
    public static final Parcelable.Creator<FullWallet> CREATOR = new zze();
    private final int zzCY;
    String zzaQm;
    String zzaQn;
    ProxyCard zzaQo;
    String zzaQp;
    Address zzaQq;
    Address zzaQr;
    String[] zzaQs;
    UserAddress zzaQt;
    UserAddress zzaQu;
    InstrumentInfo[] zzaQv;
    PaymentMethodToken zzaQw;

    private FullWallet() {
        this.zzCY = 1;
    }

    FullWallet(int i, String str, String str2, ProxyCard proxyCard, String str3, Address address, Address address2, String[] strArr, UserAddress userAddress, UserAddress userAddress2, InstrumentInfo[] instrumentInfoArr, PaymentMethodToken paymentMethodToken) {
        this.zzCY = i;
        this.zzaQm = str;
        this.zzaQn = str2;
        this.zzaQo = proxyCard;
        this.zzaQp = str3;
        this.zzaQq = address;
        this.zzaQr = address2;
        this.zzaQs = strArr;
        this.zzaQt = userAddress;
        this.zzaQu = userAddress2;
        this.zzaQv = instrumentInfoArr;
        this.zzaQw = paymentMethodToken;
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

    public String getMerchantTransactionId() {
        return this.zzaQn;
    }

    public String[] getPaymentDescriptions() {
        return this.zzaQs;
    }

    public PaymentMethodToken getPaymentMethodToken() {
        return this.zzaQw;
    }

    public ProxyCard getProxyCard() {
        return this.zzaQo;
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
        zze.zza(this, parcel, i);
    }
}
