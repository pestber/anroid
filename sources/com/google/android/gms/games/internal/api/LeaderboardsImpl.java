package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

/* loaded from: classes.dex */
public final class LeaderboardsImpl implements Leaderboards {

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$10, reason: invalid class name */
    class AnonymousClass10 extends LoadScoresImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ String zzara;
        final /* synthetic */ int zzarb;
        final /* synthetic */ int zzarc;
        final /* synthetic */ int zzard;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaqA, this.zzara, this.zzarb, this.zzarc, this.zzard, this.zzaqy);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$11, reason: invalid class name */
    class AnonymousClass11 extends LoadScoresImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ String zzara;
        final /* synthetic */ int zzarb;
        final /* synthetic */ int zzarc;
        final /* synthetic */ int zzard;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzaqA, this.zzara, this.zzarb, this.zzarc, this.zzard, this.zzaqy);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$8, reason: invalid class name */
    class AnonymousClass8 extends LoadMetadataImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ boolean zzaqy;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc(this, this.zzaqA, this.zzaqy);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$9, reason: invalid class name */
    class AnonymousClass9 extends LoadMetadataImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ String zzara;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaqA, this.zzara, this.zzaqy);
        }
    }

    private static abstract class LoadMetadataImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.LeaderboardMetadataResult> {
        private LoadMetadataImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzab, reason: merged with bridge method [inline-methods] */
        public Leaderboards.LeaderboardMetadataResult createFailedResult(final Status status) {
            return new Leaderboards.LeaderboardMetadataResult() { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadMetadataImpl.1
                @Override // com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult
                public LeaderboardBuffer getLeaderboards() {
                    return new LeaderboardBuffer(DataHolder.zzbi(14));
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

    private static abstract class LoadPlayerScoreImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.LoadPlayerScoreResult> {
        private LoadPlayerScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzac, reason: merged with bridge method [inline-methods] */
        public Leaderboards.LoadPlayerScoreResult createFailedResult(final Status status) {
            return new Leaderboards.LoadPlayerScoreResult() { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadPlayerScoreImpl.1
                @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult
                public LeaderboardScore getScore() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadScoresImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.LoadScoresResult> {
        private LoadScoresImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzad, reason: merged with bridge method [inline-methods] */
        public Leaderboards.LoadScoresResult createFailedResult(final Status status) {
            return new Leaderboards.LoadScoresResult() { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadScoresImpl.1
                @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
                public Leaderboard getLeaderboard() {
                    return null;
                }

                @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
                public LeaderboardScoreBuffer getScores() {
                    return new LeaderboardScoreBuffer(DataHolder.zzbi(14));
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

    protected static abstract class SubmitScoreImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.SubmitScoreResult> {
        protected SubmitScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzae, reason: merged with bridge method [inline-methods] */
        public Leaderboards.SubmitScoreResult createFailedResult(final Status status) {
            return new Leaderboards.SubmitScoreResult() { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.SubmitScoreImpl.1
                @Override // com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult
                public ScoreSubmissionData getScoreData() {
                    return new ScoreSubmissionData(DataHolder.zzbi(14));
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

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public Intent getAllLeaderboardsIntent(GoogleApiClient googleApiClient) {
        return Games.zzd(googleApiClient).zzsz();
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public Intent getLeaderboardIntent(GoogleApiClient googleApiClient, String str) {
        return getLeaderboardIntent(googleApiClient, str, -1);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public Intent getLeaderboardIntent(GoogleApiClient googleApiClient, String str, int i) {
        return Games.zzd(googleApiClient).zzo(str, i);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient googleApiClient, final String str, final int i, final int i2) {
        return googleApiClient.zza((GoogleApiClient) new LoadPlayerScoreImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, (String) null, str, i, i2);
            }
        });
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient googleApiClient, final String str, final boolean z) {
        return googleApiClient.zza((GoogleApiClient) new LoadMetadataImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(this, str, z);
            }
        });
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza((GoogleApiClient) new LoadMetadataImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(this, z);
            }
        });
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.LoadScoresResult> loadMoreScores(GoogleApiClient googleApiClient, final LeaderboardScoreBuffer leaderboardScoreBuffer, final int i, final int i2) {
        return googleApiClient.zza((GoogleApiClient) new LoadScoresImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, leaderboardScoreBuffer, i, i2);
            }
        });
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3) {
        return loadPlayerCenteredScores(googleApiClient, str, i, i2, i3, false);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient googleApiClient, final String str, final int i, final int i2, final int i3, final boolean z) {
        return googleApiClient.zza((GoogleApiClient) new LoadScoresImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(this, str, i, i2, i3, z);
            }
        });
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3) {
        return loadTopScores(googleApiClient, str, i, i2, i3, false);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient googleApiClient, final String str, final int i, final int i2, final int i3, final boolean z) {
        return googleApiClient.zza((GoogleApiClient) new LoadScoresImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, str, i, i2, i3, z);
            }
        });
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public void submitScore(GoogleApiClient googleApiClient, String str, long j) {
        submitScore(googleApiClient, str, j, null);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public void submitScore(GoogleApiClient googleApiClient, String str, long j, String str2) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            try {
                zzb.zza((zza.zzb<Leaderboards.SubmitScoreResult>) null, str, j, str2);
            } catch (RemoteException e) {
                GamesLog.zzu("LeaderboardsImpl", "service died");
            }
        }
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient googleApiClient, String str, long j) {
        return submitScoreImmediate(googleApiClient, str, j, null);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient googleApiClient, final String str, final long j, final String str2) {
        return googleApiClient.zzb(new SubmitScoreImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, str, j, str2);
            }
        });
    }
}
