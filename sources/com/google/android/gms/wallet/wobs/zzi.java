package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzi implements Parcelable.Creator<WalletObjectMessage> {
    static void zza(WalletObjectMessage walletObjectMessage, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, walletObjectMessage.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, walletObjectMessage.zzaSG, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, walletObjectMessage.zzCI, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) walletObjectMessage.zzaSJ, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable) walletObjectMessage.zzaSK, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) walletObjectMessage.zzaSL, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzgG, reason: merged with bridge method [inline-methods] */
    public WalletObjectMessage createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        TimeInterval timeInterval = null;
        UriData uriData = null;
        UriData uriData2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    timeInterval = (TimeInterval) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, TimeInterval.CREATOR);
                    break;
                case 5:
                    uriData = (UriData) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, UriData.CREATOR);
                    break;
                case 6:
                    uriData2 = (UriData) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, UriData.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new WalletObjectMessage(i, str, str2, timeInterval, uriData, uriData2);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzjL, reason: merged with bridge method [inline-methods] */
    public WalletObjectMessage[] newArray(int i) {
        return new WalletObjectMessage[i];
    }
}
