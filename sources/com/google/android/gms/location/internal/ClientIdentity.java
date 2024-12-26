package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public class ClientIdentity implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final String packageName;
    public final int uid;
    private final int zzCY;

    ClientIdentity(int i, int i2, String str) {
        this.zzCY = i;
        this.uid = i2;
        this.packageName = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.uid == this.uid && zzt.equal(clientIdentity.packageName, this.packageName);
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return this.uid;
    }

    public String toString() {
        return String.format("%d:%s", Integer.valueOf(this.uid), this.packageName);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
