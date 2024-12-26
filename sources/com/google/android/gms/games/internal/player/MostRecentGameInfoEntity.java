package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
    public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
    private final int zzCY;
    private final String zzasP;
    private final String zzasQ;
    private final long zzasR;
    private final Uri zzasS;
    private final Uri zzasT;
    private final Uri zzasU;

    MostRecentGameInfoEntity(int i, String str, String str2, long j, Uri uri, Uri uri2, Uri uri3) {
        this.zzCY = i;
        this.zzasP = str;
        this.zzasQ = str2;
        this.zzasR = j;
        this.zzasS = uri;
        this.zzasT = uri2;
        this.zzasU = uri3;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo mostRecentGameInfo) {
        this.zzCY = 2;
        this.zzasP = mostRecentGameInfo.zztu();
        this.zzasQ = mostRecentGameInfo.zztv();
        this.zzasR = mostRecentGameInfo.zztw();
        this.zzasS = mostRecentGameInfo.zztx();
        this.zzasT = mostRecentGameInfo.zzty();
        this.zzasU = mostRecentGameInfo.zztz();
    }

    static int zza(MostRecentGameInfo mostRecentGameInfo) {
        return zzt.hashCode(mostRecentGameInfo.zztu(), mostRecentGameInfo.zztv(), Long.valueOf(mostRecentGameInfo.zztw()), mostRecentGameInfo.zztx(), mostRecentGameInfo.zzty(), mostRecentGameInfo.zztz());
    }

    static boolean zza(MostRecentGameInfo mostRecentGameInfo, Object obj) {
        if (!(obj instanceof MostRecentGameInfo)) {
            return false;
        }
        if (mostRecentGameInfo == obj) {
            return true;
        }
        MostRecentGameInfo mostRecentGameInfo2 = (MostRecentGameInfo) obj;
        return zzt.equal(mostRecentGameInfo2.zztu(), mostRecentGameInfo.zztu()) && zzt.equal(mostRecentGameInfo2.zztv(), mostRecentGameInfo.zztv()) && zzt.equal(Long.valueOf(mostRecentGameInfo2.zztw()), Long.valueOf(mostRecentGameInfo.zztw())) && zzt.equal(mostRecentGameInfo2.zztx(), mostRecentGameInfo.zztx()) && zzt.equal(mostRecentGameInfo2.zzty(), mostRecentGameInfo.zzty()) && zzt.equal(mostRecentGameInfo2.zztz(), mostRecentGameInfo.zztz());
    }

    static String zzb(MostRecentGameInfo mostRecentGameInfo) {
        return zzt.zzt(mostRecentGameInfo).zzg("GameId", mostRecentGameInfo.zztu()).zzg("GameName", mostRecentGameInfo.zztv()).zzg("ActivityTimestampMillis", Long.valueOf(mostRecentGameInfo.zztw())).zzg("GameIconUri", mostRecentGameInfo.zztx()).zzg("GameHiResUri", mostRecentGameInfo.zzty()).zzg("GameFeaturedUri", mostRecentGameInfo.zztz()).toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        MostRecentGameInfoEntityCreator.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zztA, reason: merged with bridge method [inline-methods] */
    public MostRecentGameInfo freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public String zztu() {
        return this.zzasP;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public String zztv() {
        return this.zzasQ;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public long zztw() {
        return this.zzasR;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public Uri zztx() {
        return this.zzasS;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public Uri zzty() {
        return this.zzasT;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public Uri zztz() {
        return this.zzasU;
    }
}
