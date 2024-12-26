package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class AccountChangeEventsRequest implements SafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();
    final int mVersion;
    Account zzMY;

    @Deprecated
    String zzOx;
    int zzOz;

    public AccountChangeEventsRequest() {
        this.mVersion = 1;
    }

    AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.mVersion = i;
        this.zzOz = i2;
        this.zzOx = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.zzMY = account;
        } else {
            this.zzMY = new Account(str, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzMY;
    }

    public String getAccountName() {
        return this.zzOx;
    }

    public int getEventIndex() {
        return this.zzOz;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.zzMY = account;
        return this;
    }

    public AccountChangeEventsRequest setAccountName(String str) {
        this.zzOx = str;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int i) {
        this.zzOz = i;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
