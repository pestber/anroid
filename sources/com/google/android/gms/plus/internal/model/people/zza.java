package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<PersonEntity> {
    static void zza(PersonEntity personEntity, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        Set<Integer> set = personEntity.zzaHQ;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, personEntity.zzCY);
        }
        if (set.contains(2)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, personEntity.zzaIO, true);
        }
        if (set.contains(3)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) personEntity.zzaIP, i, true);
        }
        if (set.contains(4)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, personEntity.zzaIQ, true);
        }
        if (set.contains(5)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, personEntity.zzaIR, true);
        }
        if (set.contains(6)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, personEntity.zzaIS);
        }
        if (set.contains(7)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, (Parcelable) personEntity.zzaIT, i, true);
        }
        if (set.contains(8)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, personEntity.zzaIU, true);
        }
        if (set.contains(9)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, personEntity.zzadI, true);
        }
        if (set.contains(12)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 12, personEntity.zzsC);
        }
        if (set.contains(14)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, personEntity.zzKI, true);
        }
        if (set.contains(15)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, (Parcelable) personEntity.zzaIV, i, true);
        }
        if (set.contains(16)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 16, personEntity.zzaIW);
        }
        if (set.contains(19)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 19, (Parcelable) personEntity.zzaIX, i, true);
        }
        if (set.contains(18)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 18, personEntity.zzRA, true);
        }
        if (set.contains(21)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 21, personEntity.zzaIZ);
        }
        if (set.contains(20)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 20, personEntity.zzaIY, true);
        }
        if (set.contains(23)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 23, personEntity.zzaJb, true);
        }
        if (set.contains(22)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 22, personEntity.zzaJa, true);
        }
        if (set.contains(25)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 25, personEntity.zzaJd);
        }
        if (set.contains(24)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 24, personEntity.zzaJc);
        }
        if (set.contains(27)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 27, personEntity.zzF, true);
        }
        if (set.contains(26)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 26, personEntity.zzaJe, true);
        }
        if (set.contains(29)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 29, personEntity.zzaJg);
        }
        if (set.contains(28)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 28, personEntity.zzaJf, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzfM, reason: merged with bridge method [inline-methods] */
    public PersonEntity createFromParcel(Parcel parcel) {
        int i;
        PersonEntity.ImageEntity imageEntity;
        int i2;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        HashSet hashSet = new HashSet();
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        boolean z2 = false;
        String str = null;
        PersonEntity.AgeRangeEntity ageRangeEntity = null;
        String str2 = null;
        String str3 = null;
        PersonEntity.CoverEntity coverEntity = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        PersonEntity.ImageEntity imageEntity2 = null;
        String str7 = null;
        PersonEntity.NameEntity nameEntity = null;
        String str8 = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        String str9 = null;
        String str10 = null;
        ArrayList arrayList3 = null;
        int i8 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    i = 1;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 2;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 3:
                    ageRangeEntity = (PersonEntity.AgeRangeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, PersonEntity.AgeRangeEntity.CREATOR);
                    i = 3;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 4;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 5:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 5;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 6:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    i = 6;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 7:
                    coverEntity = (PersonEntity.CoverEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, PersonEntity.CoverEntity.CREATOR);
                    i = 7;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 8:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 8;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 9:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 9;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 10:
                case 11:
                case 13:
                case 17:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
                case 12:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    i = 12;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 14:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 14;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 15:
                    imageEntity2 = (PersonEntity.ImageEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, PersonEntity.ImageEntity.CREATOR);
                    i = 15;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 16:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa);
                    i = 16;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 18:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 18;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 19:
                    imageEntity = imageEntity2;
                    nameEntity = (PersonEntity.NameEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, PersonEntity.NameEntity.CREATOR);
                    i2 = 19;
                    hashSet.add(Integer.valueOf(i2));
                    imageEntity2 = imageEntity;
                    break;
                case 20:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 20;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 21:
                    i5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    i = 21;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 22:
                    imageEntity = imageEntity2;
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, PersonEntity.OrganizationsEntity.CREATOR);
                    i2 = 22;
                    hashSet.add(Integer.valueOf(i2));
                    imageEntity2 = imageEntity;
                    break;
                case 23:
                    imageEntity = imageEntity2;
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, PersonEntity.PlacesLivedEntity.CREATOR);
                    i2 = 23;
                    hashSet.add(Integer.valueOf(i2));
                    imageEntity2 = imageEntity;
                    break;
                case 24:
                    i6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    i = 24;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 25:
                    i7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    i = 25;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 26:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 26;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 27:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 27;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 28:
                    imageEntity = imageEntity2;
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, PersonEntity.UrlsEntity.CREATOR);
                    i2 = 28;
                    hashSet.add(Integer.valueOf(i2));
                    imageEntity2 = imageEntity;
                    break;
                case 29:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa);
                    i = 29;
                    hashSet.add(Integer.valueOf(i));
                    break;
            }
        }
        PersonEntity.ImageEntity imageEntity3 = imageEntity2;
        if (parcel.dataPosition() == zzab) {
            return new PersonEntity(hashSet, i8, str, ageRangeEntity, str2, str3, i3, coverEntity, str4, str5, i4, str6, imageEntity3, z, str7, nameEntity, str8, i5, arrayList, arrayList2, i6, i7, str9, str10, arrayList3, z2);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zziC, reason: merged with bridge method [inline-methods] */
    public PersonEntity[] newArray(int i) {
        return new PersonEntity[i];
    }
}
