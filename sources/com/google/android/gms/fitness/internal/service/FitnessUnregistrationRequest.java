package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

/* loaded from: classes.dex */
public class FitnessUnregistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<FitnessUnregistrationRequest> CREATOR = new zzb();
    private final int zzCY;
    private final DataSource zzajG;

    FitnessUnregistrationRequest(int i, DataSource dataSource) {
        this.zzCY = i;
        this.zzajG = dataSource;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DataSource getDataSource() {
        return this.zzajG;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        return String.format("ApplicationUnregistrationRequest{%s}", this.zzajG);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
