package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class CopresenceApiOptions implements SafeParcelable {
    public static final Parcelable.Creator<CopresenceApiOptions> CREATOR = new zza();
    public static final CopresenceApiOptions zzayn = new CopresenceApiOptions(true, null);
    final int zzCY;
    public final boolean zzayo;
    public final String zzayp;

    CopresenceApiOptions(int i, boolean z, String str) {
        this.zzCY = i;
        this.zzayo = z;
        this.zzayp = str;
    }

    public CopresenceApiOptions(boolean z, String str) {
        this(1, z, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
