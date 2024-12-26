package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<PersonEntity.OrganizationsEntity> {
    static void zza(PersonEntity.OrganizationsEntity organizationsEntity, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        Set<Integer> set = organizationsEntity.zzaHQ;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, organizationsEntity.zzCY);
        }
        if (set.contains(2)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, organizationsEntity.zzaJs, true);
        }
        if (set.contains(3)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, organizationsEntity.zzakM, true);
        }
        if (set.contains(4)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, organizationsEntity.zzaIn, true);
        }
        if (set.contains(5)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, organizationsEntity.zzaJt, true);
        }
        if (set.contains(6)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, organizationsEntity.mName, true);
        }
        if (set.contains(7)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, organizationsEntity.zzaJu);
        }
        if (set.contains(8)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, organizationsEntity.zzaID, true);
        }
        if (set.contains(9)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, organizationsEntity.zzadv, true);
        }
        if (set.contains(10)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 10, organizationsEntity.zzSq);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzfT, reason: merged with bridge method [inline-methods] */
    public PersonEntity.OrganizationsEntity createFromParcel(Parcel parcel) {
        int i;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        HashSet hashSet = new HashSet();
        boolean z = false;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    i = 1;
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 2;
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 3;
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 4;
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 5;
                    break;
                case 6:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 6;
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa);
                    i = 7;
                    break;
                case 8:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 8;
                    break;
                case 9:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 9;
                    break;
                case 10:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    i = 10;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    continue;
            }
            hashSet.add(Integer.valueOf(i));
        }
        if (parcel.dataPosition() == zzab) {
            return new PersonEntity.OrganizationsEntity(hashSet, i3, str, str2, str3, str4, str5, z, str6, str7, i2);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zziJ, reason: merged with bridge method [inline-methods] */
    public PersonEntity.OrganizationsEntity[] newArray(int i) {
        return new PersonEntity.OrganizationsEntity[i];
    }
}
