package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<ItemScopeEntity> {
    static void zza(ItemScopeEntity itemScopeEntity, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        Set<Integer> set = itemScopeEntity.zzaHQ;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, itemScopeEntity.zzCY);
        }
        if (set.contains(2)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) itemScopeEntity.zzaHR, i, true);
        }
        if (set.contains(3)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 3, itemScopeEntity.zzaHS, true);
        }
        if (set.contains(4)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) itemScopeEntity.zzaHT, i, true);
        }
        if (set.contains(5)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, itemScopeEntity.zzaHU, true);
        }
        if (set.contains(6)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, itemScopeEntity.zzaHV, true);
        }
        if (set.contains(7)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, itemScopeEntity.zzaHW, true);
        }
        if (set.contains(8)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 8, itemScopeEntity.zzaHX, true);
        }
        if (set.contains(9)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 9, itemScopeEntity.zzaHY);
        }
        if (set.contains(10)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 10, itemScopeEntity.zzaHZ, true);
        }
        if (set.contains(11)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, (Parcelable) itemScopeEntity.zzaIa, i, true);
        }
        if (set.contains(12)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 12, itemScopeEntity.zzaIb, true);
        }
        if (set.contains(13)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, itemScopeEntity.zzaIc, true);
        }
        if (set.contains(14)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, itemScopeEntity.zzaId, true);
        }
        if (set.contains(15)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, (Parcelable) itemScopeEntity.zzaIe, i, true);
        }
        if (set.contains(17)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 17, itemScopeEntity.zzaIg, true);
        }
        if (set.contains(16)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 16, itemScopeEntity.zzaIf, true);
        }
        if (set.contains(19)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 19, itemScopeEntity.zzaIh, true);
        }
        if (set.contains(18)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 18, itemScopeEntity.zzsB, true);
        }
        if (set.contains(21)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 21, itemScopeEntity.zzaIj, true);
        }
        if (set.contains(20)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 20, itemScopeEntity.zzaIi, true);
        }
        if (set.contains(23)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 23, itemScopeEntity.zzakM, true);
        }
        if (set.contains(22)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 22, itemScopeEntity.zzaIk, true);
        }
        if (set.contains(25)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 25, itemScopeEntity.zzaIm, true);
        }
        if (set.contains(24)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 24, itemScopeEntity.zzaIl, true);
        }
        if (set.contains(27)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 27, itemScopeEntity.zzaIo, true);
        }
        if (set.contains(26)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 26, itemScopeEntity.zzaIn, true);
        }
        if (set.contains(29)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 29, (Parcelable) itemScopeEntity.zzaIq, i, true);
        }
        if (set.contains(28)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 28, itemScopeEntity.zzaIp, true);
        }
        if (set.contains(31)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 31, itemScopeEntity.zzaIs, true);
        }
        if (set.contains(30)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 30, itemScopeEntity.zzaIr, true);
        }
        if (set.contains(34)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 34, (Parcelable) itemScopeEntity.zzaIu, i, true);
        }
        if (set.contains(32)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 32, itemScopeEntity.zzKI, true);
        }
        if (set.contains(33)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 33, itemScopeEntity.zzaIt, true);
        }
        if (set.contains(38)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 38, itemScopeEntity.zzaxC);
        }
        if (set.contains(39)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 39, itemScopeEntity.mName, true);
        }
        if (set.contains(36)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 36, itemScopeEntity.zzaxB);
        }
        if (set.contains(37)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 37, (Parcelable) itemScopeEntity.zzaIv, i, true);
        }
        if (set.contains(42)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 42, itemScopeEntity.zzaIy, true);
        }
        if (set.contains(43)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 43, itemScopeEntity.zzaIz, true);
        }
        if (set.contains(40)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 40, (Parcelable) itemScopeEntity.zzaIw, i, true);
        }
        if (set.contains(41)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 41, itemScopeEntity.zzaIx, true);
        }
        if (set.contains(46)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 46, (Parcelable) itemScopeEntity.zzaIC, i, true);
        }
        if (set.contains(47)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 47, itemScopeEntity.zzaID, true);
        }
        if (set.contains(44)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 44, itemScopeEntity.zzaIA, true);
        }
        if (set.contains(45)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 45, itemScopeEntity.zzaIB, true);
        }
        if (set.contains(51)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 51, itemScopeEntity.zzaIH, true);
        }
        if (set.contains(50)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 50, (Parcelable) itemScopeEntity.zzaIG, i, true);
        }
        if (set.contains(49)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 49, itemScopeEntity.zzaIF, true);
        }
        if (set.contains(48)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 48, itemScopeEntity.zzaIE, true);
        }
        if (set.contains(55)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 55, itemScopeEntity.zzaIJ, true);
        }
        if (set.contains(54)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 54, itemScopeEntity.zzF, true);
        }
        if (set.contains(53)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 53, itemScopeEntity.zzEl, true);
        }
        if (set.contains(52)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 52, itemScopeEntity.zzaII, true);
        }
        if (set.contains(56)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 56, itemScopeEntity.zzaIK, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzfK, reason: merged with bridge method [inline-methods] */
    public ItemScopeEntity createFromParcel(Parcel parcel) {
        int i;
        ArrayList arrayList;
        int i2;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        HashSet hashSet = new HashSet();
        int i3 = 0;
        ItemScopeEntity itemScopeEntity = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        ItemScopeEntity itemScopeEntity2 = null;
        ArrayList arrayList4 = null;
        String str4 = null;
        String str5 = null;
        ItemScopeEntity itemScopeEntity3 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        ArrayList arrayList5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        ItemScopeEntity itemScopeEntity4 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        ItemScopeEntity itemScopeEntity5 = null;
        ItemScopeEntity itemScopeEntity6 = null;
        String str22 = null;
        ItemScopeEntity itemScopeEntity7 = null;
        ArrayList arrayList6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        ItemScopeEntity itemScopeEntity8 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        ItemScopeEntity itemScopeEntity9 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        double d = 0.0d;
        double d2 = 0.0d;
        ItemScopeEntity itemScopeEntity10 = null;
        ArrayList<String> arrayList7 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    i = 1;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 2:
                    itemScopeEntity10 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ItemScopeEntity.CREATOR);
                    i = 2;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 3:
                    arrayList7 = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, zzaa);
                    i = 3;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 4:
                    itemScopeEntity = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ItemScopeEntity.CREATOR);
                    i = 4;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 5;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 6;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 7:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 7;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 8:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, ItemScopeEntity.CREATOR);
                    i = 8;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 9:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    i = 9;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 10:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, ItemScopeEntity.CREATOR);
                    i = 10;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 11:
                    itemScopeEntity2 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ItemScopeEntity.CREATOR);
                    i = 11;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 12:
                    arrayList4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, ItemScopeEntity.CREATOR);
                    i = 12;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 13:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 13;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 14:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 14;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 15:
                    arrayList = arrayList4;
                    itemScopeEntity3 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ItemScopeEntity.CREATOR);
                    i2 = 15;
                    hashSet.add(Integer.valueOf(i2));
                    arrayList4 = arrayList;
                    break;
                case 16:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 16;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 17:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 17;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 18:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 18;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 19:
                    arrayList = arrayList4;
                    arrayList5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, ItemScopeEntity.CREATOR);
                    i2 = 19;
                    hashSet.add(Integer.valueOf(i2));
                    arrayList4 = arrayList;
                    break;
                case 20:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 20;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 21:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 21;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 22:
                    str11 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 22;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 23:
                    str12 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 23;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 24:
                    str13 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 24;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 25:
                    str14 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 25;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 26:
                    str15 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 26;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 27:
                    str16 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 27;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 28:
                    str17 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 28;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 29:
                    arrayList = arrayList4;
                    itemScopeEntity4 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ItemScopeEntity.CREATOR);
                    i2 = 29;
                    hashSet.add(Integer.valueOf(i2));
                    arrayList4 = arrayList;
                    break;
                case 30:
                    str18 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 30;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 31:
                    str19 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 31;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 32:
                    str20 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 32;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 33:
                    str21 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 33;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 34:
                    arrayList = arrayList4;
                    itemScopeEntity5 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ItemScopeEntity.CREATOR);
                    i2 = 34;
                    hashSet.add(Integer.valueOf(i2));
                    arrayList4 = arrayList;
                    break;
                case 35:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
                case 36:
                    d = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, zzaa);
                    i = 36;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 37:
                    arrayList = arrayList4;
                    itemScopeEntity6 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ItemScopeEntity.CREATOR);
                    i2 = 37;
                    hashSet.add(Integer.valueOf(i2));
                    arrayList4 = arrayList;
                    break;
                case 38:
                    d2 = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, zzaa);
                    i = 38;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 39:
                    str22 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 39;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 40:
                    arrayList = arrayList4;
                    itemScopeEntity7 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ItemScopeEntity.CREATOR);
                    i2 = 40;
                    hashSet.add(Integer.valueOf(i2));
                    arrayList4 = arrayList;
                    break;
                case 41:
                    arrayList = arrayList4;
                    arrayList6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, ItemScopeEntity.CREATOR);
                    i2 = 41;
                    hashSet.add(Integer.valueOf(i2));
                    arrayList4 = arrayList;
                    break;
                case 42:
                    str23 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 42;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 43:
                    str24 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 43;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 44:
                    str25 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 44;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 45:
                    str26 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 45;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 46:
                    arrayList = arrayList4;
                    itemScopeEntity8 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ItemScopeEntity.CREATOR);
                    i2 = 46;
                    hashSet.add(Integer.valueOf(i2));
                    arrayList4 = arrayList;
                    break;
                case 47:
                    str27 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 47;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 48:
                    str28 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 48;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 49:
                    str29 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 49;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 50:
                    arrayList = arrayList4;
                    itemScopeEntity9 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ItemScopeEntity.CREATOR);
                    i2 = 50;
                    hashSet.add(Integer.valueOf(i2));
                    arrayList4 = arrayList;
                    break;
                case 51:
                    str30 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 51;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 52:
                    str31 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 52;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 53:
                    str32 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 53;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 54:
                    str33 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 54;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 55:
                    str34 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 55;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 56:
                    str35 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    i = 56;
                    hashSet.add(Integer.valueOf(i));
                    break;
            }
        }
        ArrayList arrayList8 = arrayList4;
        if (parcel.dataPosition() == zzab) {
            return new ItemScopeEntity(hashSet, i4, itemScopeEntity10, arrayList7, itemScopeEntity, str, str2, str3, arrayList2, i3, arrayList3, itemScopeEntity2, arrayList8, str4, str5, itemScopeEntity3, str6, str7, str8, arrayList5, str9, str10, str11, str12, str13, str14, str15, str16, str17, itemScopeEntity4, str18, str19, str20, str21, itemScopeEntity5, d, itemScopeEntity6, d2, str22, itemScopeEntity7, arrayList6, str23, str24, str25, str26, itemScopeEntity8, str27, str28, str29, itemScopeEntity9, str30, str31, str32, str33, str34, str35);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zziA, reason: merged with bridge method [inline-methods] */
    public ItemScopeEntity[] newArray(int i) {
        return new ItemScopeEntity[i];
    }
}
