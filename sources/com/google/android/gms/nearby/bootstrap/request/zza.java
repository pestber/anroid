package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.nearby.bootstrap.Device;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<ConnectRequest> {
    static void zza(ConnectRequest connectRequest, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) connectRequest.zzwM(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, connectRequest.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, connectRequest.getName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, connectRequest.getDescription(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, connectRequest.zzwO(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, connectRequest.zzwP(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, connectRequest.zzqU(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, connectRequest.zzwK());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, connectRequest.zzwN());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, connectRequest.getToken(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzff, reason: merged with bridge method [inline-methods] */
    public ConnectRequest createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        byte b = 0;
        Device device = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        long j = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    device = (Device) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, Device.CREATOR);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzaa);
                    break;
                case 5:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzaa);
                    break;
                case 6:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzaa);
                    break;
                case 7:
                    b = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                case 8:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzaa);
                    break;
                case 9:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
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
            return new ConnectRequest(i, device, str, str2, b, j, str3, iBinder, iBinder2, iBinder3);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzhN, reason: merged with bridge method [inline-methods] */
    public ConnectRequest[] newArray(int i) {
        return new ConnectRequest[i];
    }
}
