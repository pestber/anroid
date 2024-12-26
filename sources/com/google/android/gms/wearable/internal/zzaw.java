package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzaw implements Parcelable.Creator<MessageEventParcelable> {
    static void zza(MessageEventParcelable messageEventParcelable, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, messageEventParcelable.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, messageEventParcelable.getRequestId());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, messageEventParcelable.getPath(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, messageEventParcelable.getData(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, messageEventParcelable.getSourceNodeId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzhi, reason: merged with bridge method [inline-methods] */
    public MessageEventParcelable createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        byte[] bArr = null;
        String str2 = null;
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
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    bArr = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, zzaa);
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
            return new MessageEventParcelable(i, i2, str, bArr, str2);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzkq, reason: merged with bridge method [inline-methods] */
    public MessageEventParcelable[] newArray(int i) {
        return new MessageEventParcelable[i];
    }
}
