package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

/* loaded from: classes.dex */
public final class AppIdentifier implements SafeParcelable {
    public static final Parcelable.Creator<AppIdentifier> CREATOR = new zza();
    private final int zzCY;
    private final String zzakL;

    AppIdentifier(int i, String str) {
        this.zzCY = i;
        this.zzakL = zzu.zzh(str, "Missing application identifier value");
    }

    public AppIdentifier(String str) {
        this(1, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getIdentifier() {
        return this.zzakL;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
