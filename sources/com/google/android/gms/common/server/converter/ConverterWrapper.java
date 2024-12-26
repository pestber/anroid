package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* loaded from: classes.dex */
public class ConverterWrapper implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final int zzCY;
    private final StringToIntConverter zzabA;

    ConverterWrapper(int i, StringToIntConverter stringToIntConverter) {
        this.zzCY = i;
        this.zzabA = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.zzCY = 1;
        this.zzabA = stringToIntConverter;
    }

    public static ConverterWrapper zza(FastJsonResponse.zza<?, ?> zzaVar) {
        if (zzaVar instanceof StringToIntConverter) {
            return new ConverterWrapper((StringToIntConverter) zzaVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    StringToIntConverter zzoh() {
        return this.zzabA;
    }

    public FastJsonResponse.zza<?, ?> zzoi() {
        if (this.zzabA != null) {
            return this.zzabA;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
}
