package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class GoogleNowAuthState implements SafeParcelable {
    public static final Parcelable.Creator<GoogleNowAuthState> CREATOR = new zza();
    final int zzCY;
    String zzaJE;
    String zzaJF;
    long zzaJG;

    GoogleNowAuthState(int i, String str, String str2, long j) {
        this.zzCY = i;
        this.zzaJE = str;
        this.zzaJF = str2;
        this.zzaJG = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccessToken() {
        return this.zzaJF;
    }

    public String getAuthCode() {
        return this.zzaJE;
    }

    public long getNextAllowedTimeMillis() {
        return this.zzaJG;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
