package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.internal.zzaq;
import com.google.android.gms.internal.zzrn;

/* loaded from: classes.dex */
public class ChangeSequenceNumber implements SafeParcelable {
    public static final Parcelable.Creator<ChangeSequenceNumber> CREATOR = new zza();
    final int zzCY;
    final long zzacN;
    final long zzacO;
    final long zzacP;
    private volatile String zzacQ = null;

    ChangeSequenceNumber(int i, long j, long j2, long j3) {
        zzu.zzV(j != -1);
        zzu.zzV(j2 != -1);
        zzu.zzV(j3 != -1);
        this.zzCY = i;
        this.zzacN = j;
        this.zzacO = j2;
        this.zzacP = j3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzacQ == null) {
            this.zzacQ = "ChangeSequenceNumber:" + Base64.encodeToString(zzpb(), 10);
        }
        return this.zzacQ;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChangeSequenceNumber)) {
            return false;
        }
        ChangeSequenceNumber changeSequenceNumber = (ChangeSequenceNumber) obj;
        return changeSequenceNumber.zzacO == this.zzacO && changeSequenceNumber.zzacP == this.zzacP && changeSequenceNumber.zzacN == this.zzacN;
    }

    public int hashCode() {
        return (String.valueOf(this.zzacN) + String.valueOf(this.zzacO) + String.valueOf(this.zzacP)).hashCode();
    }

    public String toString() {
        return encodeToString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    final byte[] zzpb() {
        zzaq zzaqVar = new zzaq();
        zzaqVar.versionCode = this.zzCY;
        zzaqVar.zzafU = this.zzacN;
        zzaqVar.zzafV = this.zzacO;
        zzaqVar.zzafW = this.zzacP;
        return zzrn.zzf(zzaqVar);
    }
}
