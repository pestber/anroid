package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class LabelValue implements SafeParcelable {
    public static final Parcelable.Creator<LabelValue> CREATOR = new zzb();
    String label;
    String value;
    private final int zzCY;

    LabelValue() {
        this.zzCY = 1;
    }

    LabelValue(int i, String str, String str2) {
        this.zzCY = i;
        this.label = str;
        this.value = str2;
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
        zzb.zza(this, parcel, i);
    }
}
