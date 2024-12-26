package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<GroundOverlayOptionsParcelable> {
    static void zza(GroundOverlayOptionsParcelable groundOverlayOptionsParcelable, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, groundOverlayOptionsParcelable.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) groundOverlayOptionsParcelable.zzvM(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzfc, reason: merged with bridge method [inline-methods] */
    public GroundOverlayOptionsParcelable createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        BitmapDescriptorParcelable bitmapDescriptorParcelable = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    bitmapDescriptorParcelable = (BitmapDescriptorParcelable) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, BitmapDescriptorParcelable.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GroundOverlayOptionsParcelable(i, bitmapDescriptorParcelable);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzhC, reason: merged with bridge method [inline-methods] */
    public GroundOverlayOptionsParcelable[] newArray(int i) {
        return new GroundOverlayOptionsParcelable[i];
    }
}
