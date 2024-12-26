package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public class OnResourceIdSetResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnResourceIdSetResponse> CREATOR = new zzbf();
    private final int zzCY;
    private final List<String> zzaep;

    OnResourceIdSetResponse(int i, List<String> list) {
        this.zzCY = i;
        this.zzaep = list;
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
        zzbf.zza(this, parcel, i);
    }

    public List<String> zzpA() {
        return this.zzaep;
    }
}
