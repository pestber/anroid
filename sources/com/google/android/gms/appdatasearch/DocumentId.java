package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class DocumentId implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int zzCY;
    final String zzMZ;
    final String zzNa;
    final String zzNb;

    DocumentId(int i, String str, String str2, String str3) {
        this.zzCY = i;
        this.zzMZ = str;
        this.zzNa = str2;
        this.zzNb = str3;
    }

    public DocumentId(String str, String str2, String str3) {
        this(1, str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", this.zzMZ, this.zzNa, this.zzNb);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
