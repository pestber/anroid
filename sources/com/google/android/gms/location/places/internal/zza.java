package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<AutocompletePredictionEntity> {
    static void zza(AutocompletePredictionEntity autocompletePredictionEntity, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, autocompletePredictionEntity.zzakM, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, autocompletePredictionEntity.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, autocompletePredictionEntity.zzazK, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, autocompletePredictionEntity.zzazo, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, autocompletePredictionEntity.zzaAe, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, autocompletePredictionEntity.zzaAf);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzex, reason: merged with bridge method [inline-methods] */
    public AutocompletePredictionEntity createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        ArrayList<Integer> arrayList = null;
        ArrayList arrayList2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzB(parcel, zzaa);
                    break;
                case 4:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, AutocompletePredictionEntity.SubstringEntity.CREATOR);
                    break;
                case 5:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
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
            return new AutocompletePredictionEntity(i, str, str2, arrayList, arrayList2, i2);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzgW, reason: merged with bridge method [inline-methods] */
    public AutocompletePredictionEntity[] newArray(int i) {
        return new AutocompletePredictionEntity[i];
    }
}
