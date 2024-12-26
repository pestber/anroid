package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;

/* loaded from: classes.dex */
public final class PlayerLevel implements SafeParcelable {
    public static final Parcelable.Creator<PlayerLevel> CREATOR = new PlayerLevelCreator();
    private final int zzCY;
    private final int zzanQ;
    private final long zzanR;
    private final long zzanS;

    PlayerLevel(int i, int i2, long j, long j2) {
        zzu.zza(j >= 0, "Min XP must be positive!");
        zzu.zza(j2 > j, "Max XP must be more than min XP!");
        this.zzCY = i;
        this.zzanQ = i2;
        this.zzanR = j;
        this.zzanS = j2;
    }

    public PlayerLevel(int i, long j, long j2) {
        this(1, i, j, j2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlayerLevel playerLevel = (PlayerLevel) obj;
        return zzt.equal(Integer.valueOf(playerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber())) && zzt.equal(Long.valueOf(playerLevel.getMinXp()), Long.valueOf(getMinXp())) && zzt.equal(Long.valueOf(playerLevel.getMaxXp()), Long.valueOf(getMaxXp()));
    }

    public int getLevelNumber() {
        return this.zzanQ;
    }

    public long getMaxXp() {
        return this.zzanS;
    }

    public long getMinXp() {
        return this.zzanR;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.zzanQ), Long.valueOf(this.zzanR), Long.valueOf(this.zzanS));
    }

    public String toString() {
        return zzt.zzt(this).zzg("LevelNumber", Integer.valueOf(getLevelNumber())).zzg("MinXp", Long.valueOf(getMinXp())).zzg("MaxXp", Long.valueOf(getMaxXp())).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        PlayerLevelCreator.zza(this, parcel, i);
    }
}
