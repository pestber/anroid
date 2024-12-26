package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;

/* loaded from: classes.dex */
public final class PlayerLevelInfo implements SafeParcelable {
    public static final Parcelable.Creator<PlayerLevelInfo> CREATOR = new PlayerLevelInfoCreator();
    private final int zzCY;
    private final long zzanT;
    private final long zzanU;
    private final PlayerLevel zzanV;
    private final PlayerLevel zzanW;

    PlayerLevelInfo(int i, long j, long j2, PlayerLevel playerLevel, PlayerLevel playerLevel2) {
        zzu.zzU(j != -1);
        zzu.zzu(playerLevel);
        zzu.zzu(playerLevel2);
        this.zzCY = i;
        this.zzanT = j;
        this.zzanU = j2;
        this.zzanV = playerLevel;
        this.zzanW = playerLevel2;
    }

    public PlayerLevelInfo(long j, long j2, PlayerLevel playerLevel, PlayerLevel playerLevel2) {
        this(1, j, j2, playerLevel, playerLevel2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return zzt.equal(Long.valueOf(this.zzanT), Long.valueOf(playerLevelInfo.zzanT)) && zzt.equal(Long.valueOf(this.zzanU), Long.valueOf(playerLevelInfo.zzanU)) && zzt.equal(this.zzanV, playerLevelInfo.zzanV) && zzt.equal(this.zzanW, playerLevelInfo.zzanW);
    }

    public PlayerLevel getCurrentLevel() {
        return this.zzanV;
    }

    public long getCurrentXpTotal() {
        return this.zzanT;
    }

    public long getLastLevelUpTimestamp() {
        return this.zzanU;
    }

    public PlayerLevel getNextLevel() {
        return this.zzanW;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(Long.valueOf(this.zzanT), Long.valueOf(this.zzanU), this.zzanV, this.zzanW);
    }

    public boolean isMaxLevel() {
        return this.zzanV.equals(this.zzanW);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        PlayerLevelInfoCreator.zza(this, parcel, i);
    }
}
