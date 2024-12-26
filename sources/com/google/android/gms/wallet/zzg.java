package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<GiftCardWalletObject> {
    static void zza(GiftCardWalletObject giftCardWalletObject, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, giftCardWalletObject.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) giftCardWalletObject.zzaQz, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, giftCardWalletObject.zzaQA, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, giftCardWalletObject.pin, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, giftCardWalletObject.zzaQB, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, giftCardWalletObject.zzaQC);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, giftCardWalletObject.zzaQD, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, giftCardWalletObject.zzaQE);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, giftCardWalletObject.zzaQF, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzgg, reason: merged with bridge method [inline-methods] */
    public GiftCardWalletObject createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        CommonWalletObject commonWalletObject = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    commonWalletObject = (CommonWalletObject) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, CommonWalletObject.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzaa);
                    break;
                case 7:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzaa);
                    break;
                case 9:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GiftCardWalletObject(i, commonWalletObject, str, str2, str3, j, str4, j2, str5);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzji, reason: merged with bridge method [inline-methods] */
    public GiftCardWalletObject[] newArray(int i) {
        return new GiftCardWalletObject[i];
    }
}
