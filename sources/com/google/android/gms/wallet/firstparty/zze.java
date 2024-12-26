package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<GetInstrumentsResponse> {
    static void zza(GetInstrumentsResponse getInstrumentsResponse, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, getInstrumentsResponse.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, getInstrumentsResponse.zzaRM, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, getInstrumentsResponse.zzaRN, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzgu, reason: merged with bridge method [inline-methods] */
    public GetInstrumentsResponse createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        String[] strArr = null;
        int i = 0;
        byte[][] bArr = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    strArr = com.google.android.gms.common.internal.safeparcel.zza.zzA(parcel, zzaa);
                    break;
                case 3:
                    bArr = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetInstrumentsResponse(i, strArr, bArr);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzjw, reason: merged with bridge method [inline-methods] */
    public GetInstrumentsResponse[] newArray(int i) {
        return new GetInstrumentsResponse[i];
    }
}
