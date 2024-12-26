package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<GetServiceRequest> {
    static void zza(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, getServiceRequest.version);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, getServiceRequest.zzaad);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, getServiceRequest.zzaae);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, getServiceRequest.zzaaf, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, getServiceRequest.zzaag, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable[]) getServiceRequest.zzaah, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, getServiceRequest.zzaai, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, (Parcelable) getServiceRequest.zzaaj, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzW, reason: merged with bridge method [inline-methods] */
    public GetServiceRequest createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
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
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzaa);
                    break;
                case 6:
                    scopeArr = (Scope[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa, Scope.CREATOR);
                    break;
                case 7:
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzaa);
                    break;
                case 8:
                    account = (Account) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, Account.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetServiceRequest(i, i2, i3, str, iBinder, scopeArr, bundle, account);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzbr, reason: merged with bridge method [inline-methods] */
    public GetServiceRequest[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
