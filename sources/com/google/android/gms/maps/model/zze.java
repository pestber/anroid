package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<LatLng> {
    static void zza(LatLng latLng, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, latLng.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, latLng.latitude);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, latLng.longitude);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzeP, reason: merged with bridge method [inline-methods] */
    public LatLng createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        double d = 0.0d;
        double d2 = 0.0d;
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
                    d2 = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new LatLng(i, d, d2);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzhp, reason: merged with bridge method [inline-methods] */
    public LatLng[] newArray(int i) {
        return new LatLng[i];
    }
}
