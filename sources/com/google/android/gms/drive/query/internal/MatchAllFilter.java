package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

/* loaded from: classes.dex */
public class MatchAllFilter extends AbstractFilter {
    public static final zzl CREATOR = new zzl();
    final int zzCY;

    public MatchAllFilter() {
        this(1);
    }

    MatchAllFilter(int i) {
        this.zzCY = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F zza(zzf<F> zzfVar) {
        return zzfVar.zzqf();
    }
}
