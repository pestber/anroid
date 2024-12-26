package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

/* loaded from: classes.dex */
public final class AppContentTupleRef extends zzc implements AppContentTuple {
    AppContentTupleRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return AppContentTupleEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentTuple
    public String getName() {
        return getString("tuple_name");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentTuple
    public String getValue() {
        return getString("tuple_value");
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return AppContentTupleEntity.zza(this);
    }

    public String toString() {
        return AppContentTupleEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentTupleEntity) freeze()).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzsp, reason: merged with bridge method [inline-methods] */
    public AppContentTuple freeze() {
        return new AppContentTupleEntity(this);
    }
}
