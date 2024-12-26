package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzl implements Parcelable.Creator<PlaceRequest> {
    static void zza(PlaceRequest placeRequest, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, placeRequest.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) placeRequest.zzuG(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, placeRequest.getInterval());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, placeRequest.getPriority());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, placeRequest.getExpirationTime());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzev, reason: merged with bridge method [inline-methods] */
    public PlaceRequest createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        long j = PlaceRequest.zzazM;
        int i = 0;
        PlaceFilter placeFilter = null;
        int i2 = 102;
        long j2 = Long.MAX_VALUE;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 2:
                    placeFilter = (PlaceFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, PlaceFilter.CREATOR);
                    break;
                case 3:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzaa);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzaa);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new PlaceRequest(i, placeFilter, j, i2, j2);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzgT, reason: merged with bridge method [inline-methods] */
    public PlaceRequest[] newArray(int i) {
        return new PlaceRequest[i];
    }
}
