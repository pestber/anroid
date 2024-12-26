package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<DocumentId> {
    static void zza(DocumentId documentId, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, documentId.zzMZ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, documentId.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, documentId.zzNa, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, documentId.zzNb, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzad, reason: merged with bridge method [inline-methods] */
    public DocumentId[] newArray(int i) {
        return new DocumentId[i];
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzs, reason: merged with bridge method [inline-methods] */
    public DocumentId createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
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
            return new DocumentId(i, str, str2, str3);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }
}
