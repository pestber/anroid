package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<AddListenerRequest> {
    static void zza(AddListenerRequest addListenerRequest, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, addListenerRequest.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, addListenerRequest.zzAT(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable[]) addListenerRequest.zzaTr, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, addListenerRequest.zzaTs, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, addListenerRequest.zzaTt, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzgK, reason: merged with bridge method [inline-methods] */
    public AddListenerRequest createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        IBinder iBinder = null;
        IntentFilter[] intentFilterArr = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzaa);
                    break;
                case 3:
                    intentFilterArr = (IntentFilter[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa, IntentFilter.CREATOR);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new AddListenerRequest(i, iBinder, intentFilterArr, str, str2);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzjP, reason: merged with bridge method [inline-methods] */
    public AddListenerRequest[] newArray(int i) {
        return new AddListenerRequest[i];
    }
}
