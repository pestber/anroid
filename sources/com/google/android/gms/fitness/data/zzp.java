package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzp implements Parcelable.Creator<Session> {
    static void zza(Session session, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, session.zzkt());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, session.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, session.zzqs());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, session.getName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, session.getIdentifier(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, session.getDescription(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, session.zzqq());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, (Parcelable) session.zzqB(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, session.zzqJ(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzcv, reason: merged with bridge method [inline-methods] */
    public Session createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Application application = null;
        Long l = null;
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
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 8:
                    application = (Application) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, Application.CREATOR);
                    break;
                case 9:
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzj(parcel, zzaa);
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
            return new Session(i, j, j2, str, str2, str3, i2, application, l);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzep, reason: merged with bridge method [inline-methods] */
    public Session[] newArray(int i) {
        return new Session[i];
    }
}
