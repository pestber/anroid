package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public class GetRecentContextCall {

    public static class Request implements SafeParcelable {
        public static final zzf CREATOR = new zzf();
        final int zzCY;
        public final Account zzNj;
        public final boolean zzNk;
        public final boolean zzNl;
        public final boolean zzNm;

        public Request() {
            this(null, false, false, false);
        }

        Request(int i, Account account, boolean z, boolean z2, boolean z3) {
            this.zzCY = i;
            this.zzNj = account;
            this.zzNk = z;
            this.zzNl = z2;
            this.zzNm = z3;
        }

        public Request(Account account, boolean z, boolean z2, boolean z3) {
            this(1, account, z, z2, z3);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzf.zza(this, parcel, i);
        }
    }

    public static class Response implements Result, SafeParcelable {
        public static final zzg CREATOR = new zzg();
        final int zzCY;
        public Status zzNn;
        public List<UsageInfo> zzNo;
        public String[] zzNp;

        public Response() {
            this.zzCY = 1;
        }

        Response(int i, Status status, List<UsageInfo> list, String[] strArr) {
            this.zzCY = i;
            this.zzNn = status;
            this.zzNo = list;
            this.zzNp = strArr;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzNn;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzg.zza(this, parcel, i);
        }
    }
}
