package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.Subscription;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<ListSubscriptionsResult> {
    static void zza(ListSubscriptionsResult listSubscriptionsResult, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, listSubscriptionsResult.getSubscriptions(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, listSubscriptionsResult.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) listSubscriptionsResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzdl, reason: merged with bridge method [inline-methods] */
    public ListSubscriptionsResult createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        ArrayList arrayList = null;
        Status status = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, Subscription.CREATOR);
                    break;
                case 2:
                    status = (Status) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, Status.CREATOR);
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
            return new ListSubscriptionsResult(i, arrayList, status);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzfg, reason: merged with bridge method [inline-methods] */
    public ListSubscriptionsResult[] newArray(int i) {
        return new ListSubscriptionsResult[i];
    }
}
