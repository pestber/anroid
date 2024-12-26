package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzd implements Parcelable.Creator<LoyaltyPointsBalance> {
    static void zza(LoyaltyPointsBalance loyaltyPointsBalance, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, loyaltyPointsBalance.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, loyaltyPointsBalance.zzaSB);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, loyaltyPointsBalance.zzaSC, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, loyaltyPointsBalance.zzaSD);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, loyaltyPointsBalance.zzaQD, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, loyaltyPointsBalance.zzaSE);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, loyaltyPointsBalance.zzaSF);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzgB, reason: merged with bridge method [inline-methods] */
    public LoyaltyPointsBalance createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        double d = 0.0d;
        long j = 0;
        int i3 = -1;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    d = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, zzaa);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzaa);
                    break;
                case 7:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new LoyaltyPointsBalance(i, i2, str, d, str2, j, i3);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzjG, reason: merged with bridge method [inline-methods] */
    public LoyaltyPointsBalance[] newArray(int i) {
        return new LoyaltyPointsBalance[i];
    }
}
