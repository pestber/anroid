package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class TextModuleData implements SafeParcelable {
    public static final Parcelable.Creator<TextModuleData> CREATOR = new zzf();
    String zzCI;
    private final int zzCY;
    String zzaSG;

    TextModuleData() {
        this.zzCY = 1;
    }

    TextModuleData(int i, String str, String str2) {
        this.zzCY = i;
        this.zzaSG = str;
        this.zzCI = str2;
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
        zzf.zza(this, parcel, i);
    }
}
