package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* loaded from: classes.dex */
public class AppContentAnnotationEntityCreator implements Parcelable.Creator<AppContentAnnotationEntity> {
    static void zza(AppContentAnnotationEntity appContentAnnotationEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, appContentAnnotationEntity.getDescription(), false);
        zzb.zzc(parcel, 1000, appContentAnnotationEntity.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) appContentAnnotationEntity.zzrU(), i, false);
        zzb.zza(parcel, 3, appContentAnnotationEntity.getTitle(), false);
        zzb.zza(parcel, 5, appContentAnnotationEntity.getId(), false);
        zzb.zza(parcel, 6, appContentAnnotationEntity.zzrX(), false);
        zzb.zza(parcel, 7, appContentAnnotationEntity.zzrS(), false);
        zzb.zzc(parcel, 8, appContentAnnotationEntity.zzrT());
        zzb.zzc(parcel, 9, appContentAnnotationEntity.zzrW());
        zzb.zza(parcel, 10, appContentAnnotationEntity.zzrV(), false);
        zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzdx, reason: merged with bridge method [inline-methods] */
    public AppContentAnnotationEntity createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        String str = null;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    uri = (Uri) zza.zza(parcel, zzaa, Uri.CREATOR);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    str5 = zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 9:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 10:
                    bundle = zza.zzq(parcel, zzaa);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new AppContentAnnotationEntity(i, str, uri, str2, str3, str4, str5, i2, i3, bundle);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzft, reason: merged with bridge method [inline-methods] */
    public AppContentAnnotationEntity[] newArray(int i) {
        return new AppContentAnnotationEntity[i];
    }
}
