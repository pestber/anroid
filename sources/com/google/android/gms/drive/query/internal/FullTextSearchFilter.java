package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

/* loaded from: classes.dex */
public class FullTextSearchFilter extends AbstractFilter {
    public static final zzh CREATOR = new zzh();
    final String mValue;
    final int zzCY;

    FullTextSearchFilter(int i, String str) {
        this.zzCY = i;
        this.mValue = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F zza(zzf<F> zzfVar) {
        return zzfVar.zzcC(this.mValue);
    }
}
