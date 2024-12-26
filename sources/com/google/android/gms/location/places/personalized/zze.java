package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.personalized.internal.TestDataImpl;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<PlaceUserData> {
    static void zza(PlaceUserData placeUserData, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, placeUserData.zzvb(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, placeUserData.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, placeUserData.getPlaceId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, placeUserData.zzve(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, placeUserData.zzvc(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, placeUserData.zzvd(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzeG, reason: merged with bridge method [inline-methods] */
    public PlaceUserData createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, TestDataImpl.CREATOR);
                    break;
                case 6:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, PlaceAlias.CREATOR);
                    break;
                case 7:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, HereContent.CREATOR);
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
            return new PlaceUserData(i, str, str2, arrayList, arrayList2, arrayList3);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzhg, reason: merged with bridge method [inline-methods] */
    public PlaceUserData[] newArray(int i) {
        return new PlaceUserData[i];
    }
}
