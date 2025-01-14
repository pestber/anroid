package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TurnBasedMatchEntityCreator implements Parcelable.Creator<TurnBasedMatchEntity> {
    static void zza(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) turnBasedMatchEntity.getGame(), i, false);
        zzb.zza(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        zzb.zza(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        zzb.zza(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        zzb.zza(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        zzb.zza(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        zzb.zza(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        zzb.zzc(parcel, 8, turnBasedMatchEntity.getStatus());
        zzb.zzc(parcel, 10, turnBasedMatchEntity.getVariant());
        zzb.zzc(parcel, 11, turnBasedMatchEntity.getVersion());
        zzb.zza(parcel, 12, turnBasedMatchEntity.getData(), false);
        zzb.zzc(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        zzb.zza(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        zzb.zza(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        zzb.zza(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        zzb.zzc(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        zzb.zzc(parcel, 1000, turnBasedMatchEntity.getVersionCode());
        zzb.zza(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        zzb.zzc(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        zzb.zza(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        zzb.zza(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzdN, reason: merged with bridge method [inline-methods] */
    public TurnBasedMatchEntity createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        Bundle bundle = null;
        String str6 = null;
        String str7 = null;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    gameEntity = (GameEntity) zza.zza(parcel, zzaa, GameEntity.CREATOR);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 7:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 10:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 11:
                    i4 = zza.zzg(parcel, zzaa);
                    break;
                case 12:
                    bArr = zza.zzr(parcel, zzaa);
                    break;
                case 13:
                    arrayList = zza.zzc(parcel, zzaa, ParticipantEntity.CREATOR);
                    break;
                case 14:
                    str5 = zza.zzo(parcel, zzaa);
                    break;
                case 15:
                    bArr2 = zza.zzr(parcel, zzaa);
                    break;
                case 16:
                    i5 = zza.zzg(parcel, zzaa);
                    break;
                case 17:
                    bundle = zza.zzq(parcel, zzaa);
                    break;
                case 18:
                    i6 = zza.zzg(parcel, zzaa);
                    break;
                case 19:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 20:
                    str6 = zza.zzo(parcel, zzaa);
                    break;
                case 21:
                    str7 = zza.zzo(parcel, zzaa);
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
            return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzfW, reason: merged with bridge method [inline-methods] */
    public TurnBasedMatchEntity[] newArray(int i) {
        return new TurnBasedMatchEntity[i];
    }
}
