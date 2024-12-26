package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<StreetViewPanoramaOptions> {
    static void zza(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, streetViewPanoramaOptions.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) streetViewPanoramaOptions.getStreetViewPanoramaCamera(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, streetViewPanoramaOptions.getPanoramaId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) streetViewPanoramaOptions.getPosition(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, streetViewPanoramaOptions.getRadius(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, streetViewPanoramaOptions.zzvy());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, streetViewPanoramaOptions.zzvo());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, streetViewPanoramaOptions.zzvz());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, streetViewPanoramaOptions.zzvA());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, streetViewPanoramaOptions.zzvk());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzeJ, reason: merged with bridge method [inline-methods] */
    public StreetViewPanoramaOptions createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        byte b = 0;
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        String str = null;
        LatLng latLng = null;
        Integer num = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, LatLng.CREATOR);
                    break;
                case 5:
                    num = com.google.android.gms.common.internal.safeparcel.zza.zzh(parcel, zzaa);
                    break;
                case 6:
                    b = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                case 7:
                    b2 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                case 8:
                    b3 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                case 9:
                    b4 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                case 10:
                    b5 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b, b2, b3, b4, b5);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzhj, reason: merged with bridge method [inline-methods] */
    public StreetViewPanoramaOptions[] newArray(int i) {
        return new StreetViewPanoramaOptions[i];
    }
}
