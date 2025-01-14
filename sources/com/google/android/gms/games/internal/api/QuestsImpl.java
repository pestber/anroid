package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;

/* loaded from: classes.dex */
public final class QuestsImpl implements Quests {

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl$5, reason: invalid class name */
    class AnonymousClass5 extends LoadsImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ int zzaqV;
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ int[] zzarI;
        final /* synthetic */ String zzarK;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaqA, this.zzarK, this.zzarI, this.zzaqV, this.zzaqy);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl$6, reason: invalid class name */
    class AnonymousClass6 extends LoadsImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ String[] zzarJ;
        final /* synthetic */ String zzarK;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaqA, this.zzarK, this.zzaqy, this.zzarJ);
        }
    }

    private static abstract class AcceptImpl extends Games.BaseGamesApiMethodImpl<Quests.AcceptQuestResult> {
        private AcceptImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzan, reason: merged with bridge method [inline-methods] */
        public Quests.AcceptQuestResult createFailedResult(final Status status) {
            return new Quests.AcceptQuestResult() { // from class: com.google.android.gms.games.internal.api.QuestsImpl.AcceptImpl.1
                @Override // com.google.android.gms.games.quest.Quests.AcceptQuestResult
                public Quest getQuest() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class ClaimImpl extends Games.BaseGamesApiMethodImpl<Quests.ClaimMilestoneResult> {
        private ClaimImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzao, reason: merged with bridge method [inline-methods] */
        public Quests.ClaimMilestoneResult createFailedResult(final Status status) {
            return new Quests.ClaimMilestoneResult() { // from class: com.google.android.gms.games.internal.api.QuestsImpl.ClaimImpl.1
                @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
                public Milestone getMilestone() {
                    return null;
                }

                @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
                public Quest getQuest() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadsImpl extends Games.BaseGamesApiMethodImpl<Quests.LoadQuestsResult> {
        private LoadsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzap, reason: merged with bridge method [inline-methods] */
        public Quests.LoadQuestsResult createFailedResult(final Status status) {
            return new Quests.LoadQuestsResult() { // from class: com.google.android.gms.games.internal.api.QuestsImpl.LoadsImpl.1
                @Override // com.google.android.gms.games.quest.Quests.LoadQuestsResult
                public QuestBuffer getQuests() {
                    return new QuestBuffer(DataHolder.zzbi(status.getStatusCode()));
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

    @Override // com.google.android.gms.games.quest.Quests
    public PendingResult<Quests.AcceptQuestResult> accept(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new AcceptImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.QuestsImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzh(this, str);
            }
        });
    }

    @Override // com.google.android.gms.games.quest.Quests
    public PendingResult<Quests.ClaimMilestoneResult> claim(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new ClaimImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.QuestsImpl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(this, str, str2);
            }
        });
    }

    @Override // com.google.android.gms.games.quest.Quests
    public Intent getQuestIntent(GoogleApiClient googleApiClient, String str) {
        return Games.zzd(googleApiClient).zzcO(str);
    }

    @Override // com.google.android.gms.games.quest.Quests
    public Intent getQuestsIntent(GoogleApiClient googleApiClient, int[] iArr) {
        return Games.zzd(googleApiClient).zzb(iArr);
    }

    @Override // com.google.android.gms.games.quest.Quests
    public PendingResult<Quests.LoadQuestsResult> load(GoogleApiClient googleApiClient, final int[] iArr, final int i, final boolean z) {
        return googleApiClient.zza((GoogleApiClient) new LoadsImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.QuestsImpl.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, iArr, i, z);
            }
        });
    }

    @Override // com.google.android.gms.games.quest.Quests
    public PendingResult<Quests.LoadQuestsResult> loadByIds(GoogleApiClient googleApiClient, final boolean z, final String... strArr) {
        return googleApiClient.zza((GoogleApiClient) new LoadsImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.QuestsImpl.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(this, z, strArr);
            }
        });
    }

    @Override // com.google.android.gms.games.quest.Quests
    public void registerQuestUpdateListener(GoogleApiClient googleApiClient, QuestUpdateListener questUpdateListener) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzc(googleApiClient.zzo(questUpdateListener));
        }
    }

    @Override // com.google.android.gms.games.quest.Quests
    public void showStateChangedPopup(GoogleApiClient googleApiClient, String str) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzcP(str);
        }
    }

    @Override // com.google.android.gms.games.quest.Quests
    public void unregisterQuestUpdateListener(GoogleApiClient googleApiClient) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzsF();
        }
    }
}
