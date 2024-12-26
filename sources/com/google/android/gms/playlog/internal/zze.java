package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<PlayLoggerContext> {
    static void zza(PlayLoggerContext playLoggerContext, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, playLoggerContext.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, playLoggerContext.packageName, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, playLoggerContext.zzaGP);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, playLoggerContext.zzaGQ);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, playLoggerContext.zzaGR, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, playLoggerContext.zzaGS, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, playLoggerContext.zzaGT);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, playLoggerContext.zzaGU, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, playLoggerContext.zzaGV);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzfH, reason: merged with bridge method [inline-methods] */
    public PlayLoggerContext createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        boolean z2 = true;
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
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa);
                    break;
                case 8:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 9:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new PlayLoggerContext(i, str, i2, i3, str2, str3, z2, str4, z);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zziw, reason: merged with bridge method [inline-methods] */
    public PlayLoggerContext[] newArray(int i) {
        return new PlayLoggerContext[i];
    }
}
