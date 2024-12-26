package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzlc;

/* loaded from: classes.dex */
public final class AchievementEntity implements SafeParcelable, Achievement {
    public static final Parcelable.Creator<AchievementEntity> CREATOR = new AchievementEntityCreator();
    private final String mName;
    private final int mState;
    private final int zzCY;
    private final int zzSq;
    private final String zzakM;
    private final String zzanZ;
    private final Uri zzaoa;
    private final String zzaob;
    private final Uri zzaoc;
    private final String zzaod;
    private final int zzaoe;
    private final String zzaof;
    private final PlayerEntity zzaog;
    private final int zzaoh;
    private final String zzaoi;
    private final long zzaoj;
    private final long zzaok;

    AchievementEntity(int i, String str, int i2, String str2, String str3, Uri uri, String str4, Uri uri2, String str5, int i3, String str6, PlayerEntity playerEntity, int i4, int i5, String str7, long j, long j2) {
        this.zzCY = i;
        this.zzanZ = str;
        this.zzSq = i2;
        this.mName = str2;
        this.zzakM = str3;
        this.zzaoa = uri;
        this.zzaob = str4;
        this.zzaoc = uri2;
        this.zzaod = str5;
        this.zzaoe = i3;
        this.zzaof = str6;
        this.zzaog = playerEntity;
        this.mState = i4;
        this.zzaoh = i5;
        this.zzaoi = str7;
        this.zzaoj = j;
        this.zzaok = j2;
    }

    public AchievementEntity(Achievement achievement) {
        this.zzCY = 1;
        this.zzanZ = achievement.getAchievementId();
        this.zzSq = achievement.getType();
        this.mName = achievement.getName();
        this.zzakM = achievement.getDescription();
        this.zzaoa = achievement.getUnlockedImageUri();
        this.zzaob = achievement.getUnlockedImageUrl();
        this.zzaoc = achievement.getRevealedImageUri();
        this.zzaod = achievement.getRevealedImageUrl();
        this.zzaog = (PlayerEntity) achievement.getPlayer().freeze();
        this.mState = achievement.getState();
        this.zzaoj = achievement.getLastUpdatedTimestamp();
        this.zzaok = achievement.getXpValue();
        if (achievement.getType() == 1) {
            this.zzaoe = achievement.getTotalSteps();
            this.zzaof = achievement.getFormattedTotalSteps();
            this.zzaoh = achievement.getCurrentSteps();
            this.zzaoi = achievement.getFormattedCurrentSteps();
        } else {
            this.zzaoe = 0;
            this.zzaof = null;
            this.zzaoh = 0;
            this.zzaoi = null;
        }
        zzb.zzq(this.zzanZ);
        zzb.zzq(this.zzakM);
    }

    static int zza(Achievement achievement) {
        int i;
        int i2;
        if (achievement.getType() == 1) {
            i = achievement.getCurrentSteps();
            i2 = achievement.getTotalSteps();
        } else {
            i = 0;
            i2 = 0;
        }
        return zzt.hashCode(achievement.getAchievementId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.getPlayer(), Integer.valueOf(i), Integer.valueOf(i2));
    }

    static boolean zza(Achievement achievement, Object obj) {
        boolean z;
        boolean z2;
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        Achievement achievement2 = (Achievement) obj;
        if (achievement.getType() == 1) {
            z = zzt.equal(Integer.valueOf(achievement2.getCurrentSteps()), Integer.valueOf(achievement.getCurrentSteps()));
            z2 = zzt.equal(Integer.valueOf(achievement2.getTotalSteps()), Integer.valueOf(achievement.getTotalSteps()));
        } else {
            z = true;
            z2 = true;
        }
        return zzt.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && zzt.equal(achievement2.getName(), achievement.getName()) && zzt.equal(Integer.valueOf(achievement2.getType()), Integer.valueOf(achievement.getType())) && zzt.equal(achievement2.getDescription(), achievement.getDescription()) && zzt.equal(Long.valueOf(achievement2.getXpValue()), Long.valueOf(achievement.getXpValue())) && zzt.equal(Integer.valueOf(achievement2.getState()), Integer.valueOf(achievement.getState())) && zzt.equal(Long.valueOf(achievement2.getLastUpdatedTimestamp()), Long.valueOf(achievement.getLastUpdatedTimestamp())) && zzt.equal(achievement2.getPlayer(), achievement.getPlayer()) && z && z2;
    }

    static String zzb(Achievement achievement) {
        zzt.zza zzg = zzt.zzt(achievement).zzg("Id", achievement.getAchievementId()).zzg("Type", Integer.valueOf(achievement.getType())).zzg("Name", achievement.getName()).zzg("Description", achievement.getDescription()).zzg("Player", achievement.getPlayer()).zzg("State", Integer.valueOf(achievement.getState()));
        if (achievement.getType() == 1) {
            zzg.zzg("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            zzg.zzg("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return zzg.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public Achievement freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getAchievementId() {
        return this.zzanZ;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int getCurrentSteps() {
        return this.zzaoh;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getDescription() {
        return this.zzakM;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zzlc.zzb(this.zzakM, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getFormattedCurrentSteps() {
        return this.zzaoi;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        zzlc.zzb(this.zzaoi, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getFormattedTotalSteps() {
        return this.zzaof;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        zzlc.zzb(this.zzaof, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public long getLastUpdatedTimestamp() {
        return this.zzaoj;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getName() {
        return this.mName;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public void getName(CharArrayBuffer charArrayBuffer) {
        zzlc.zzb(this.mName, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public Player getPlayer() {
        return this.zzaog;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public Uri getRevealedImageUri() {
        return this.zzaoc;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getRevealedImageUrl() {
        return this.zzaod;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int getState() {
        return this.mState;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int getTotalSteps() {
        return this.zzaoe;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int getType() {
        return this.zzSq;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public Uri getUnlockedImageUri() {
        return this.zzaoa;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getUnlockedImageUrl() {
        return this.zzaob;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public long getXpValue() {
        return this.zzaok;
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
        AchievementEntityCreator.zza(this, parcel, i);
    }
}
