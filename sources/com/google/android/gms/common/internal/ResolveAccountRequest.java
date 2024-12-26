package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ResolveAccountRequest implements SafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new zzv();
    final int zzCY;
    private final Account zzMY;
    private final int zzabc;

    ResolveAccountRequest(int i, Account account, int i2) {
        this.zzCY = i;
        this.zzMY = account;
        this.zzabc = i2;
    }

    public ResolveAccountRequest(Account account, int i) {
        this(1, account, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzMY;
    }

    public int getSessionId() {
        return this.zzabc;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzv.zza(this, parcel, i);
    }
}
