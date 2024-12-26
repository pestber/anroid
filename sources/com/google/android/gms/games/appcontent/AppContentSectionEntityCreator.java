package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AppContentSectionEntityCreator implements Parcelable.Creator<AppContentSectionEntity> {
    static void zza(AppContentSectionEntity appContentSectionEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, appContentSectionEntity.getActions(), false);
        zzb.zzc(parcel, 1000, appContentSectionEntity.getVersionCode());
        zzb.zzc(parcel, 3, appContentSectionEntity.zzsj(), false);
        zzb.zza(parcel, 4, appContentSectionEntity.zzrP(), false);
        zzb.zza(parcel, 5, appContentSectionEntity.getExtras(), false);
        zzb.zza(parcel, 6, appContentSectionEntity.zzsb(), false);
        zzb.zza(parcel, 7, appContentSectionEntity.getTitle(), false);
        zzb.zza(parcel, 8, appContentSectionEntity.getType(), false);
        zzb.zza(parcel, 9, appContentSectionEntity.getId(), false);
        zzb.zza(parcel, 10, appContentSectionEntity.zzsk(), false);
        zzb.zzc(parcel, 14, appContentSectionEntity.zzrZ(), false);
        zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzdA, reason: merged with bridge method [inline-methods] */
    public AppContentSectionEntity createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        String str = null;
        Bundle bundle = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList3 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzaa, AppContentActionEntity.CREATOR);
                    break;
                case 3:
                    arrayList2 = zza.zzc(parcel, zzaa, AppContentCardEntity.CREATOR);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    bundle = zza.zzq(parcel, zzaa);
                    break;
                case 6:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 9:
                    str5 = zza.zzo(parcel, zzaa);
                    break;
                case 10:
                    str6 = zza.zzo(parcel, zzaa);
                    break;
                case 14:
                    arrayList3 = zza.zzc(parcel, zzaa, AppContentAnnotationEntity.CREATOR);
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
            return new AppContentSectionEntity(i, arrayList, arrayList2, str, bundle, str2, str3, str4, str5, str6, arrayList3);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzfw, reason: merged with bridge method [inline-methods] */
    public AppContentSectionEntity[] newArray(int i) {
        return new AppContentSectionEntity[i];
    }
}
