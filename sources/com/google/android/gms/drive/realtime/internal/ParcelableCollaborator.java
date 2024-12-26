package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ParcelableCollaborator implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableCollaborator> CREATOR = new zzp();
    final int zzCY;
    final String zzEO;
    final String zzFE;
    final String zzadI;
    final boolean zzais;
    final boolean zzait;
    final String zzaiu;
    final String zzaiv;

    ParcelableCollaborator(int i, boolean z, boolean z2, String str, String str2, String str3, String str4, String str5) {
        this.zzCY = i;
        this.zzais = z;
        this.zzait = z2;
        this.zzFE = str;
        this.zzEO = str2;
        this.zzadI = str3;
        this.zzaiu = str4;
        this.zzaiv = str5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ParcelableCollaborator) {
            return this.zzFE.equals(((ParcelableCollaborator) obj).zzFE);
        }
        return false;
    }

    public int hashCode() {
        return this.zzFE.hashCode();
    }

    public String toString() {
        return "Collaborator [isMe=" + this.zzais + ", isAnonymous=" + this.zzait + ", sessionId=" + this.zzFE + ", userId=" + this.zzEO + ", displayName=" + this.zzadI + ", color=" + this.zzaiu + ", photoUrl=" + this.zzaiv + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
