package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class UriData implements SafeParcelable {
    public static final Parcelable.Creator<UriData> CREATOR = new zzh();
    String description;
    private final int zzCY;
    String zzaGl;

    UriData() {
        this.zzCY = 1;
    }

    UriData(int i, String str, String str2) {
        this.zzCY = i;
        this.zzaGl = str;
        this.description = str2;
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
        zzh.zza(this, parcel, i);
    }
}
