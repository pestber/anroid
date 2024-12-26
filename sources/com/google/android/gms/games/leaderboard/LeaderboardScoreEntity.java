package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzlc;

/* loaded from: classes.dex */
public final class LeaderboardScoreEntity implements LeaderboardScore {
    private final long zzatD;
    private final String zzatE;
    private final String zzatF;
    private final long zzatG;
    private final long zzatH;
    private final String zzatI;
    private final Uri zzatJ;
    private final Uri zzatK;
    private final PlayerEntity zzatL;
    private final String zzatM;
    private final String zzatN;
    private final String zzatO;

    public LeaderboardScoreEntity(LeaderboardScore leaderboardScore) {
        this.zzatD = leaderboardScore.getRank();
        this.zzatE = (String) zzu.zzu(leaderboardScore.getDisplayRank());
        this.zzatF = (String) zzu.zzu(leaderboardScore.getDisplayScore());
        this.zzatG = leaderboardScore.getRawScore();
        this.zzatH = leaderboardScore.getTimestampMillis();
        this.zzatI = leaderboardScore.getScoreHolderDisplayName();
        this.zzatJ = leaderboardScore.getScoreHolderIconImageUri();
        this.zzatK = leaderboardScore.getScoreHolderHiResImageUri();
        Player scoreHolder = leaderboardScore.getScoreHolder();
        this.zzatL = scoreHolder == null ? null : (PlayerEntity) scoreHolder.freeze();
        this.zzatM = leaderboardScore.getScoreTag();
        this.zzatN = leaderboardScore.getScoreHolderIconImageUrl();
        this.zzatO = leaderboardScore.getScoreHolderHiResImageUrl();
    }

    static int zza(LeaderboardScore leaderboardScore) {
        return zzt.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    static boolean zza(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return zzt.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && zzt.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && zzt.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && zzt.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && zzt.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && zzt.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && zzt.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && zzt.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && zzt.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && zzt.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    static String zzb(LeaderboardScore leaderboardScore) {
        return zzt.zzt(leaderboardScore).zzg("Rank", Long.valueOf(leaderboardScore.getRank())).zzg("DisplayRank", leaderboardScore.getDisplayRank()).zzg("Score", Long.valueOf(leaderboardScore.getRawScore())).zzg("DisplayScore", leaderboardScore.getDisplayScore()).zzg("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).zzg("DisplayName", leaderboardScore.getScoreHolderDisplayName()).zzg("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).zzg("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).zzg("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).zzg("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).zzg("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).zzg("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String getDisplayRank() {
        return this.zzatE;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        zzlc.zzb(this.zzatE, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String getDisplayScore() {
        return this.zzatF;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        zzlc.zzb(this.zzatF, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public long getRank() {
        return this.zzatD;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public long getRawScore() {
        return this.zzatG;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public Player getScoreHolder() {
        return this.zzatL;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String getScoreHolderDisplayName() {
        return this.zzatL == null ? this.zzatI : this.zzatL.getDisplayName();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        if (this.zzatL == null) {
            zzlc.zzb(this.zzatI, charArrayBuffer);
        } else {
            this.zzatL.getDisplayName(charArrayBuffer);
        }
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public Uri getScoreHolderHiResImageUri() {
        return this.zzatL == null ? this.zzatK : this.zzatL.getHiResImageUri();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String getScoreHolderHiResImageUrl() {
        return this.zzatL == null ? this.zzatO : this.zzatL.getHiResImageUrl();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public Uri getScoreHolderIconImageUri() {
        return this.zzatL == null ? this.zzatJ : this.zzatL.getIconImageUri();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String getScoreHolderIconImageUrl() {
        return this.zzatL == null ? this.zzatN : this.zzatL.getIconImageUrl();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String getScoreTag() {
        return this.zzatM;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public long getTimestampMillis() {
        return this.zzatH;
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

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zztG, reason: merged with bridge method [inline-methods] */
    public LeaderboardScore freeze() {
        return this;
    }
}
