package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.List;

/* loaded from: classes.dex */
public final class AppMetadata implements SafeParcelable {
    public static final Parcelable.Creator<AppMetadata> CREATOR = new zzb();
    private final int zzCY;
    private final List<AppIdentifier> zzaFn;

    AppMetadata(int i, List<AppIdentifier> list) {
        this.zzCY = i;
        this.zzaFn = (List) zzu.zzb(list, "Must specify application identifiers");
        zzu.zza(list.size(), "Application identifiers cannot be empty");
    }

    public AppMetadata(List<AppIdentifier> list) {
        this(1, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<AppIdentifier> getAppIdentifiers() {
        return this.zzaFn;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
