package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<BleDevice> {
    static void zza(BleDevice bleDevice, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, bleDevice.getAddress(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, bleDevice.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, bleDevice.getName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 3, bleDevice.getSupportedProfiles(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, bleDevice.getDataTypes(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzcj, reason: merged with bridge method [inline-methods] */
    public BleDevice createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
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
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, zzaa);
                    break;
                case 4:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, DataType.CREATOR);
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
            return new BleDevice(i, str, str2, arrayList, arrayList2);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzea, reason: merged with bridge method [inline-methods] */
    public BleDevice[] newArray(int i) {
        return new BleDevice[i];
    }
}
