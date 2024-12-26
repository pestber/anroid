package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzk implements Parcelable.Creator<ChannelEventParcelable> {
    static void zza(ChannelEventParcelable channelEventParcelable, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, channelEventParcelable.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) channelEventParcelable.zzaTP, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, channelEventParcelable.type);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, channelEventParcelable.zzaTN);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, channelEventParcelable.zzaTO);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzgO, reason: merged with bridge method [inline-methods] */
    public ChannelEventParcelable createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        ChannelImpl channelImpl = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    channelImpl = (ChannelImpl) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ChannelImpl.CREATOR);
                    break;
                case 3:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ChannelEventParcelable(i, channelImpl, i2, i3, i4);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzjV, reason: merged with bridge method [inline-methods] */
    public ChannelEventParcelable[] newArray(int i) {
        return new ChannelEventParcelable[i];
    }
}
