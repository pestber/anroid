package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<DeviceStatus> {
    static void zza(DeviceStatus deviceStatus, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, deviceStatus.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, deviceStatus.zzlO());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, deviceStatus.zzlX());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, deviceStatus.zzlP());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable) deviceStatus.getApplicationMetadata(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, deviceStatus.zzlQ());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzN, reason: merged with bridge method [inline-methods] */
    public DeviceStatus createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        double d = 0.0d;
        ApplicationMetadata applicationMetadata = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    d = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, zzaa);
                    break;
                case 3:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    applicationMetadata = (ApplicationMetadata) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ApplicationMetadata.CREATOR);
                    break;
                case 6:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new DeviceStatus(i, d, z, i2, applicationMetadata, i3);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzaQ, reason: merged with bridge method [inline-methods] */
    public DeviceStatus[] newArray(int i) {
        return new DeviceStatus[i];
    }
}
