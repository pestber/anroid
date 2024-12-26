package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<GroundOverlayOptions> {
    static void zza(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, groundOverlayOptions.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, groundOverlayOptions.zzvI(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) groundOverlayOptions.getLocation(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, groundOverlayOptions.getWidth());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, groundOverlayOptions.getHeight());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) groundOverlayOptions.getBounds(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, groundOverlayOptions.getBearing());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, groundOverlayOptions.getZIndex());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, groundOverlayOptions.isVisible());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, groundOverlayOptions.getTransparency());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, groundOverlayOptions.getAnchorU());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, groundOverlayOptions.getAnchorV());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzeN, reason: merged with bridge method [inline-methods] */
    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        boolean z = false;
        IBinder iBinder = null;
        LatLng latLng = null;
        LatLngBounds latLngBounds = null;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzaa);
                    break;
                case 3:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, LatLng.CREATOR);
                    break;
                case 4:
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzaa);
                    break;
                case 5:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzaa);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzaa);
                    break;
                case 8:
                    f4 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzaa);
                    break;
                case 9:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa);
                    break;
                case 10:
                    f5 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzaa);
                    break;
                case 11:
                    f6 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzaa);
                    break;
                case 12:
                    f7 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzhn, reason: merged with bridge method [inline-methods] */
    public GroundOverlayOptions[] newArray(int i) {
        return new GroundOverlayOptions[i];
    }
}
