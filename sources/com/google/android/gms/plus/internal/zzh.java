package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<PlusSession> {
    static void zza(PlusSession plusSession, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, plusSession.getAccountName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, plusSession.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, plusSession.zzxx(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, plusSession.zzxy(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, plusSession.zzxz(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, plusSession.zzxA(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, plusSession.zzxB(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, plusSession.zzlB(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, plusSession.zzxC(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, (Parcelable) plusSession.zzxD(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzfJ, reason: merged with bridge method [inline-methods] */
    public PlusSession createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        String str = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        PlusCommonExtras plusCommonExtras = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    strArr = com.google.android.gms.common.internal.safeparcel.zza.zzA(parcel, zzaa);
                    break;
                case 3:
                    strArr2 = com.google.android.gms.common.internal.safeparcel.zza.zzA(parcel, zzaa);
                    break;
                case 4:
                    strArr3 = com.google.android.gms.common.internal.safeparcel.zza.zzA(parcel, zzaa);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 9:
                    plusCommonExtras = (PlusCommonExtras) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, PlusCommonExtras.CREATOR);
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
            return new PlusSession(i, str, strArr, strArr2, strArr3, str2, str3, str4, str5, plusCommonExtras);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zziz, reason: merged with bridge method [inline-methods] */
    public PlusSession[] newArray(int i) {
        return new PlusSession[i];
    }
}
