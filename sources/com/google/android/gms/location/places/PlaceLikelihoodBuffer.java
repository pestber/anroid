package com.google.android.gms.location.places;

import android.content.Context;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.location.LocationRequest;

/* loaded from: classes.dex */
public class PlaceLikelihoodBuffer extends AbstractDataBuffer<PlaceLikelihood> implements Result {
    private final Context mContext;
    private final Status zzOt;
    private final String zzazB;
    private final int zzazG;

    public static class zza {
        static int zzgO(int i) {
            switch (i) {
                case 100:
                case Quests.SELECT_COMPLETED_UNCLAIMED /* 101 */:
                case 102:
                case Quests.SELECT_RECENTLY_FAILED /* 103 */:
                case LocationRequest.PRIORITY_LOW_POWER /* 104 */:
                case LocationRequest.PRIORITY_NO_POWER /* 105 */:
                    return i;
                default:
                    throw new IllegalArgumentException("invalid source: " + i);
            }
        }
    }

    public PlaceLikelihoodBuffer(DataHolder dataHolder, int i, Context context) {
        super(dataHolder);
        this.mContext = context;
        this.zzOt = PlacesStatusCodes.zzgU(dataHolder.getStatusCode());
        this.zzazG = zza.zzgO(i);
        this.zzazB = (dataHolder == null || dataHolder.zznb() == null) ? null : dataHolder.zznb().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public PlaceLikelihood get(int i) {
        return new com.google.android.gms.location.places.internal.zzm(this.zzWu, i, this.mContext);
    }

    public CharSequence getAttributions() {
        return this.zzazB;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzOt;
    }

    public String toString() {
        return zzt.zzt(this).zzg("status", getStatus()).zzg("attributions", this.zzazB).toString();
    }
}
