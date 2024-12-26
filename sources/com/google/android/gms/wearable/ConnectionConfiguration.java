package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public class ConnectionConfiguration implements SafeParcelable {
    public static final Parcelable.Creator<ConnectionConfiguration> CREATOR = new zze();
    private final String mName;
    final int zzCY;
    private boolean zzMq;
    private final int zzSq;
    private final boolean zzaSQ;
    private String zzaSR;
    private boolean zzaSS;
    private String zzaST;
    private final int zzadD;
    private final String zzajO;

    ConnectionConfiguration(int i, String str, String str2, int i2, int i3, boolean z, boolean z2, String str3, boolean z3, String str4) {
        this.zzCY = i;
        this.mName = str;
        this.zzajO = str2;
        this.zzSq = i2;
        this.zzadD = i3;
        this.zzaSQ = z;
        this.zzMq = z2;
        this.zzaSR = str3;
        this.zzaSS = z3;
        this.zzaST = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionConfiguration)) {
            return false;
        }
        ConnectionConfiguration connectionConfiguration = (ConnectionConfiguration) obj;
        return zzt.equal(Integer.valueOf(this.zzCY), Integer.valueOf(connectionConfiguration.zzCY)) && zzt.equal(this.mName, connectionConfiguration.mName) && zzt.equal(this.zzajO, connectionConfiguration.zzajO) && zzt.equal(Integer.valueOf(this.zzSq), Integer.valueOf(connectionConfiguration.zzSq)) && zzt.equal(Integer.valueOf(this.zzadD), Integer.valueOf(connectionConfiguration.zzadD)) && zzt.equal(Boolean.valueOf(this.zzaSQ), Boolean.valueOf(connectionConfiguration.zzaSQ)) && zzt.equal(Boolean.valueOf(this.zzaSS), Boolean.valueOf(connectionConfiguration.zzaSS));
    }

    public String getAddress() {
        return this.zzajO;
    }

    public String getName() {
        return this.mName;
    }

    public String getNodeId() {
        return this.zzaST;
    }

    public int getRole() {
        return this.zzadD;
    }

    public int getType() {
        return this.zzSq;
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.zzCY), this.mName, this.zzajO, Integer.valueOf(this.zzSq), Integer.valueOf(this.zzadD), Boolean.valueOf(this.zzaSQ), Boolean.valueOf(this.zzaSS));
    }

    public boolean isConnected() {
        return this.zzMq;
    }

    public boolean isEnabled() {
        return this.zzaSQ;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConnectionConfiguration[ ");
        sb.append("mName=" + this.mName);
        sb.append(", mAddress=" + this.zzajO);
        sb.append(", mType=" + this.zzSq);
        sb.append(", mRole=" + this.zzadD);
        sb.append(", mEnabled=" + this.zzaSQ);
        sb.append(", mIsConnected=" + this.zzMq);
        sb.append(", mPeerNodeId=" + this.zzaSR);
        sb.append(", mBtlePriority=" + this.zzaSS);
        sb.append(", mNodeId=" + this.zzaST);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public String zzAP() {
        return this.zzaSR;
    }

    public boolean zzAQ() {
        return this.zzaSS;
    }
}
