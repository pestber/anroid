package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ConnectionInfo implements SafeParcelable {
    public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();
    private final int zzCY;
    private final String zzaoO;
    private final int zzaoP;

    public ConnectionInfo(int i, String str, int i2) {
        this.zzCY = i;
        this.zzaoO = str;
        this.zzaoP = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ConnectionInfoCreator.zza(this, parcel, i);
    }

    public String zzsr() {
        return this.zzaoO;
    }

    public int zzss() {
        return this.zzaoP;
    }
}
