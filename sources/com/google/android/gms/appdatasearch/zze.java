package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<Feature> {
    static void zza(Feature feature, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, feature.id);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, feature.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, feature.zzNi, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzaf, reason: merged with bridge method [inline-methods] */
    public Feature[] newArray(int i) {
        return new Feature[i];
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzu, reason: merged with bridge method [inline-methods] */
    public Feature createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzaa);
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
            return new Feature(i, i2, bundle);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }
}
