package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class OnDeviceUsagePreferenceResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnDeviceUsagePreferenceResponse> CREATOR = new zzav();
    final int zzCY;
    final FileUploadPreferencesImpl zzagf;

    OnDeviceUsagePreferenceResponse(int i, FileUploadPreferencesImpl fileUploadPreferencesImpl) {
        this.zzCY = i;
        this.zzagf = fileUploadPreferencesImpl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzav.zza(this, parcel, i);
    }

    public FileUploadPreferencesImpl zzpL() {
        return this.zzagf;
    }
}
