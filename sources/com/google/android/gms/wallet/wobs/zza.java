package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<CommonWalletObject> {
    static void zza(CommonWalletObject commonWalletObject, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, commonWalletObject.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, commonWalletObject.zzhI, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, commonWalletObject.zzaQT, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, commonWalletObject.name, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, commonWalletObject.zzaQN, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, commonWalletObject.zzaQP, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, commonWalletObject.zzaQQ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, commonWalletObject.zzaQR, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, commonWalletObject.zzaQS, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 10, commonWalletObject.state);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 11, commonWalletObject.zzaQU, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, (Parcelable) commonWalletObject.zzaQV, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 13, commonWalletObject.zzaQW, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, commonWalletObject.zzaQX, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, commonWalletObject.zzaQY, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 17, commonWalletObject.zzaRa);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 16, commonWalletObject.zzaQZ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 19, commonWalletObject.zzaRc, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 18, commonWalletObject.zzaRb, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 20, commonWalletObject.zzaRd, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzgy, reason: merged with bridge method [inline-methods] */
    public CommonWalletObject createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        ArrayList zzoP = zzkx.zzoP();
        ArrayList zzoP2 = zzkx.zzoP();
        ArrayList zzoP3 = zzkx.zzoP();
        ArrayList arrayList = zzoP;
        ArrayList arrayList2 = zzoP2;
        ArrayList arrayList3 = zzoP3;
        ArrayList zzoP4 = zzkx.zzoP();
        ArrayList zzoP5 = zzkx.zzoP();
        ArrayList zzoP6 = zzkx.zzoP();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        TimeInterval timeInterval = null;
        String str9 = null;
        String str10 = null;
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
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 9:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 10:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 11:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, WalletObjectMessage.CREATOR);
                    break;
                case 12:
                    timeInterval = (TimeInterval) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, TimeInterval.CREATOR);
                    break;
                case 13:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, LatLng.CREATOR);
                    break;
                case 14:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 15:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 16:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, LabelValueRow.CREATOR);
                    break;
                case 17:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa);
                    break;
                case 18:
                    zzoP4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, UriData.CREATOR);
                    break;
                case 19:
                    zzoP5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, TextModuleData.CREATOR);
                    break;
                case 20:
                    zzoP6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, UriData.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new CommonWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, i2, arrayList, timeInterval, arrayList2, str9, str10, arrayList3, z, zzoP4, zzoP5, zzoP6);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzjD, reason: merged with bridge method [inline-methods] */
    public CommonWalletObject[] newArray(int i) {
        return new CommonWalletObject[i];
    }
}
