package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzav implements Parcelable.Creator<OnDeviceUsagePreferenceResponse> {
    static void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, onDeviceUsagePreferenceResponse.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) onDeviceUsagePreferenceResponse.zzagf, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzba, reason: merged with bridge method [inline-methods] */
    public OnDeviceUsagePreferenceResponse createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        FileUploadPreferencesImpl fileUploadPreferencesImpl = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    fileUploadPreferencesImpl = (FileUploadPreferencesImpl) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, FileUploadPreferencesImpl.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new OnDeviceUsagePreferenceResponse(i, fileUploadPreferencesImpl);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzcP, reason: merged with bridge method [inline-methods] */
    public OnDeviceUsagePreferenceResponse[] newArray(int i) {
        return new OnDeviceUsagePreferenceResponse[i];
    }
}
