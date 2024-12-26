package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;

/* loaded from: classes.dex */
public class AccountChangeEvent implements SafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();
    final int mVersion;
    final String zzOA;
    final long zzOw;
    final String zzOx;
    final int zzOy;
    final int zzOz;

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.mVersion = i;
        this.zzOw = j;
        this.zzOx = (String) zzu.zzu(str);
        this.zzOy = i2;
        this.zzOz = i3;
        this.zzOA = str2;
    }

    public AccountChangeEvent(long j, String str, int i, int i2, String str2) {
        this.mVersion = 1;
        this.zzOw = j;
        this.zzOx = (String) zzu.zzu(str);
        this.zzOy = i;
        this.zzOz = i2;
        this.zzOA = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.mVersion == accountChangeEvent.mVersion && this.zzOw == accountChangeEvent.zzOw && zzt.equal(this.zzOx, accountChangeEvent.zzOx) && this.zzOy == accountChangeEvent.zzOy && this.zzOz == accountChangeEvent.zzOz && zzt.equal(this.zzOA, accountChangeEvent.zzOA);
    }

    public String getAccountName() {
        return this.zzOx;
    }

    public String getChangeData() {
        return this.zzOA;
    }

    public int getChangeType() {
        return this.zzOy;
    }

    public int getEventIndex() {
        return this.zzOz;
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.mVersion), Long.valueOf(this.zzOw), this.zzOx, Integer.valueOf(this.zzOy), Integer.valueOf(this.zzOz), this.zzOA);
    }

    public String toString() {
        String str;
        switch (this.zzOy) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.zzOx + ", changeType = " + str + ", changeData = " + this.zzOA + ", eventIndex = " + this.zzOz + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
