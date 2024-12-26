package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<GetRecentContextCall.Response> {
    static void zza(GetRecentContextCall.Response response, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, response.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) response.zzNn, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, response.zzNo, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, response.zzNp, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzah, reason: merged with bridge method [inline-methods] */
    public GetRecentContextCall.Response[] newArray(int i) {
        return new GetRecentContextCall.Response[i];
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzw, reason: merged with bridge method [inline-methods] */
    public GetRecentContextCall.Response createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        Status status = null;
        ArrayList arrayList = null;
        String[] strArr = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    status = (Status) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, Status.CREATOR);
                    break;
                case 2:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, UsageInfo.CREATOR);
                    break;
                case 3:
                    strArr = com.google.android.gms.common.internal.safeparcel.zza.zzA(parcel, zzaa);
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
            return new GetRecentContextCall.Response(i, status, arrayList, strArr);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }
}