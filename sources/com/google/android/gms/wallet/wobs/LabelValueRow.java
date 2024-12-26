package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzkx;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class LabelValueRow implements SafeParcelable {
    public static final Parcelable.Creator<LabelValueRow> CREATOR = new zzc();
    private final int zzCY;
    String zzaSx;
    String zzaSy;
    ArrayList<LabelValue> zzaSz;

    LabelValueRow() {
        this.zzCY = 1;
        this.zzaSz = zzkx.zzoP();
    }

    LabelValueRow(int i, String str, String str2, ArrayList<LabelValue> arrayList) {
        this.zzCY = i;
        this.zzaSx = str;
        this.zzaSy = str2;
        this.zzaSz = arrayList;
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
        zzc.zza(this, parcel, i);
    }
}
