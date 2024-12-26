package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzm implements Parcelable.Creator<RawBucket> {
    static void zza(RawBucket rawBucket, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, rawBucket.zzKT);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, rawBucket.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, rawBucket.zzajH);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) rawBucket.zzajJ, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, rawBucket.zzakG);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, rawBucket.zzajS, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, rawBucket.zzajT);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, rawBucket.zzajU);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzcs, reason: merged with bridge method [inline-methods] */
    public RawBucket createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        long j = 0;
        long j2 = 0;
        Session session = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzaa);
                    break;
                case 2:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    session = (Session) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, Session.CREATOR);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, RawDataSet.CREATOR);
                    break;
                case 6:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa);
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
            return new RawBucket(i, j, j2, session, i2, arrayList, i3, z);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzel, reason: merged with bridge method [inline-methods] */
    public RawBucket[] newArray(int i) {
        return new RawBucket[i];
    }
}