package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.GamesClientImpl;

/* loaded from: classes.dex */
public final class AchievementsImpl implements Achievements {

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl$10, reason: invalid class name */
    class AnonymousClass10 extends LoadImpl {
        final /* synthetic */ String zzTE;
        final /* synthetic */ String zzaqA;
        final /* synthetic */ boolean zzaqy;

        @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzTE, this.zzaqA, this.zzaqy);
        }
    }

    private static abstract class LoadImpl extends Games.BaseGamesApiMethodImpl<Achievements.LoadAchievementsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzQ, reason: merged with bridge method [inline-methods] */
        public Achievements.LoadAchievementsResult createFailedResult(final Status status) {
            return new Achievements.LoadAchievementsResult() { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.LoadImpl.1
                @Override // com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult
                public AchievementBuffer getAchievements() {
                    return new AchievementBuffer(DataHolder.zzbi(14));
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }

    private static abstract class UpdateImpl extends Games.BaseGamesApiMethodImpl<Achievements.UpdateAchievementResult> {
        private final String zzKI;

        public UpdateImpl(String str, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzKI = str;
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzR, reason: merged with bridge method [inline-methods] */
        public Achievements.UpdateAchievementResult createFailedResult(final Status status) {
            return new Achievements.UpdateAchievementResult() { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.UpdateImpl.1
                @Override // com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult
                public String getAchievementId() {
                    return UpdateImpl.this.zzKI;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public Intent getAchievementsIntent(GoogleApiClient googleApiClient) {
        return Games.zzd(googleApiClient).zzsA();
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public void increment(GoogleApiClient googleApiClient, final String str, final int i) {
        googleApiClient.zzb(new UpdateImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.6
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Achievements.UpdateAchievementResult>) null, str, i);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public PendingResult<Achievements.UpdateAchievementResult> incrementImmediate(GoogleApiClient googleApiClient, final String str, final int i) {
        return googleApiClient.zzb(new UpdateImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.7
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, str, i);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public PendingResult<Achievements.LoadAchievementsResult> load(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza((GoogleApiClient) new LoadImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.1
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc(this, z);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public void reveal(GoogleApiClient googleApiClient, final String str) {
        googleApiClient.zzb(new UpdateImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.2
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Achievements.UpdateAchievementResult>) null, str);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public PendingResult<Achievements.UpdateAchievementResult> revealImmediate(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new UpdateImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.3
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, str);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public void setSteps(GoogleApiClient googleApiClient, final String str, final int i) {
        googleApiClient.zzb(new UpdateImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.8
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zza.zzb<Achievements.UpdateAchievementResult>) null, str, i);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public PendingResult<Achievements.UpdateAchievementResult> setStepsImmediate(GoogleApiClient googleApiClient, final String str, final int i) {
        return googleApiClient.zzb(new UpdateImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.9
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(this, str, i);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public void unlock(GoogleApiClient googleApiClient, final String str) {
        googleApiClient.zzb(new UpdateImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.4
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zza.zzb<Achievements.UpdateAchievementResult>) null, str);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public PendingResult<Achievements.UpdateAchievementResult> unlockImmediate(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new UpdateImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.5
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(this, str);
            }
        });
    }
}
