package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.api.zzi;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.IGamesService;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.signin.internal.zzh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class GamesClientImpl extends zzi<IGamesService> {
    EventIncrementManager zzaoQ;
    private final String zzaoR;
    private PlayerEntity zzaoS;
    private GameEntity zzaoT;
    private final PopupManager zzaoU;
    private boolean zzaoV;
    private final Binder zzaoW;
    private final long zzaoX;
    private final Games.GamesOptions zzaoY;

    private static abstract class AbstractPeerStatusNotifier extends AbstractRoomStatusNotifier {
        private final ArrayList<String> zzapa;

        AbstractPeerStatusNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder);
            this.zzapa = new ArrayList<>();
            for (String str : strArr) {
                this.zzapa.add(str);
            }
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomStatusNotifier
        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            zza(roomStatusUpdateListener, room, this.zzapa);
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    private static abstract class AbstractRoomNotifier extends zzb<RoomUpdateListener> {
        AbstractRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zzb
        public void zza(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            zza(roomUpdateListener, GamesClientImpl.zzU(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void zza(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    private static abstract class AbstractRoomStatusNotifier extends zzb<RoomStatusUpdateListener> {
        AbstractRoomStatusNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zzb
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            zza(roomStatusUpdateListener, GamesClientImpl.zzU(dataHolder));
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    private static final class AcceptQuestResultImpl extends GamesDataHolderResult implements Quests.AcceptQuestResult {
        private final Quest zzapb;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzapb = new QuestEntity(questBuffer.get(0));
                } else {
                    this.zzapb = null;
                }
            } finally {
                questBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.quest.Quests.AcceptQuestResult
        public Quest getQuest() {
            return this.zzapb;
        }
    }

    private static final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Achievements.UpdateAchievementResult> zzOs;

        AchievementUpdatedBinderCallback(zza.zzb<Achievements.UpdateAchievementResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzf(int i, String str) {
            this.zzOs.zzm(new UpdateAchievementResultImpl(i, str));
        }
    }

    private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Achievements.LoadAchievementsResult> zzOs;

        AchievementsLoadedBinderCallback(zza.zzb<Achievements.LoadAchievementsResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzf(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<AppContents.LoadAppContentResult> zzapc;

        public AppContentLoadedBinderCallbacks(zza.zzb<AppContents.LoadAppContentResult> zzbVar) {
            this.zzapc = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zza(DataHolder[] dataHolderArr) {
            this.zzapc.zzm(new LoadAppContentsResultImpl(dataHolderArr));
        }
    }

    private static final class CancelMatchResultImpl implements TurnBasedMultiplayer.CancelMatchResult {
        private final Status zzOt;
        private final String zzapd;

        CancelMatchResultImpl(Status status, String str) {
            this.zzOt = status;
            this.zzapd = str;
        }

        @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult
        public String getMatchId() {
            return this.zzapd;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class ClaimMilestoneResultImpl extends GamesDataHolderResult implements Quests.ClaimMilestoneResult {
        private final Quest zzapb;
        private final Milestone zzape;

        ClaimMilestoneResultImpl(DataHolder dataHolder, String str) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzapb = new QuestEntity(questBuffer.get(0));
                    List<Milestone> zztN = this.zzapb.zztN();
                    int size = zztN.size();
                    for (int i = 0; i < size; i++) {
                        if (zztN.get(i).getMilestoneId().equals(str)) {
                            this.zzape = zztN.get(i);
                            return;
                        }
                    }
                    this.zzape = null;
                } else {
                    this.zzape = null;
                    this.zzapb = null;
                }
            } finally {
                questBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
        public Milestone getMilestone() {
            return this.zzape;
        }

        @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
        public Quest getQuest() {
            return this.zzapb;
        }
    }

    private static final class CommitSnapshotResultImpl extends GamesDataHolderResult implements Snapshots.CommitSnapshotResult {
        private final SnapshotMetadata zzapf;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.zzapf = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.zzapf = null;
                }
            } finally {
                snapshotMetadataBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult
        public SnapshotMetadata getSnapshotMetadata() {
            return this.zzapf;
        }
    }

    private static final class ConnectedToRoomNotifier extends AbstractRoomStatusNotifier {
        ConnectedToRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomStatusNotifier
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    private static final class ContactSettingLoadResultImpl extends GamesDataHolderResult implements Notifications.ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Notifications.ContactSettingLoadResult> zzOs;

        ContactSettingsLoadedBinderCallback(zza.zzb<Notifications.ContactSettingLoadResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzG(DataHolder dataHolder) {
            this.zzOs.zzm(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzOs;

        ContactSettingsUpdatedBinderCallback(zza.zzb<Status> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzfz(int i) {
            this.zzOs.zzm(GamesStatusCodes.zzfn(i));
        }
    }

    private static final class DeleteSnapshotResultImpl implements Snapshots.DeleteSnapshotResult {
        private final Status zzOt;
        private final String zzapg;

        DeleteSnapshotResultImpl(int i, String str) {
            this.zzOt = GamesStatusCodes.zzfn(i);
            this.zzapg = str;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult
        public String getSnapshotId() {
            return this.zzapg;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class DisconnectedFromRoomNotifier extends AbstractRoomStatusNotifier {
        DisconnectedFromRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomStatusNotifier
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    private static final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Events.LoadEventsResult> zzOs;

        EventsLoadedBinderCallback(zza.zzb<Events.LoadEventsResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzg(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadEventResultImpl(dataHolder));
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        public GameClientEventIncrementCache() {
            super(GamesClientImpl.this.getContext().getMainLooper(), 1000);
        }

        @Override // com.google.android.gms.games.internal.events.EventIncrementCache
        protected void zzs(String str, int i) {
            try {
                if (GamesClientImpl.this.isConnected()) {
                    GamesClientImpl.this.zznM().zzp(str, i);
                } else {
                    GamesLog.zzv("GamesClientImpl", "Unable to increment event " + str + " by " + i + " because the games client is no longer connected");
                }
            } catch (RemoteException e) {
                GamesClientImpl.this.zzb(e);
            }
        }
    }

    private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GamesMetadata.LoadGameInstancesResult> zzOs;

        GameInstancesLoadedBinderCallback(zza.zzb<GamesMetadata.LoadGameInstancesResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzn(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements Notifications.GameMuteStatusChangeResult {
        private final Status zzOt;
        private final String zzaph;
        private final boolean zzapi;

        public GameMuteStatusChangeResultImpl(int i, String str, boolean z) {
            this.zzOt = GamesStatusCodes.zzfn(i);
            this.zzaph = str;
            this.zzapi = z;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Notifications.GameMuteStatusChangeResult> zzOs;

        GameMuteStatusChangedBinderCallback(zza.zzb<Notifications.GameMuteStatusChangeResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zza(int i, String str, boolean z) {
            this.zzOs.zzm(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements Notifications.GameMuteStatusLoadResult {
        private final Status zzOt;
        private final String zzaph;
        private final boolean zzapi;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.zzOt = GamesStatusCodes.zzfn(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.zzaph = dataHolder.zzd("external_game_id", 0, 0);
                    this.zzapi = dataHolder.zze("muted", 0, 0);
                } else {
                    this.zzaph = null;
                    this.zzapi = false;
                }
            } finally {
                dataHolder.close();
            }
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Notifications.GameMuteStatusLoadResult> zzOs;

        GameMuteStatusLoadedBinderCallback(zza.zzb<Notifications.GameMuteStatusLoadResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzE(DataHolder dataHolder) {
            this.zzOs.zzm(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GamesMetadata.LoadGameSearchSuggestionsResult> zzOs;

        GameSearchSuggestionsLoadedBinderCallback(zza.zzb<GamesMetadata.LoadGameSearchSuggestionsResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzo(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    private static abstract class GamesDataHolderResult extends zzc {
        protected GamesDataHolderResult(DataHolder dataHolder) {
            super(dataHolder, GamesStatusCodes.zzfn(dataHolder.getStatusCode()));
        }
    }

    private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GamesMetadata.LoadGamesResult> zzOs;

        GamesLoadedBinderCallback(zza.zzb<GamesMetadata.LoadGamesResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzl(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadGamesResultImpl(dataHolder));
        }
    }

    private static final class InboxCountResultImpl implements Notifications.InboxCountResult {
        private final Status zzOt;
        private final Bundle zzapj;

        InboxCountResultImpl(Status status, Bundle bundle) {
            this.zzOt = status;
            this.zzapj = bundle;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Notifications.InboxCountResult> zzOs;

        InboxCountsLoadedBinderCallback(zza.zzb<Notifications.InboxCountResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzg(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzOs.zzm(new InboxCountResultImpl(GamesStatusCodes.zzfn(i), bundle));
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        private final com.google.android.gms.common.api.zzi<OnInvitationReceivedListener> zzafi;

        InvitationReceivedBinderCallback(com.google.android.gms.common.api.zzi<OnInvitationReceivedListener> zziVar) {
            this.zzafi = zziVar;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void onInvitationRemoved(String str) {
            this.zzafi.zza(new InvitationRemovedNotifier(str));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzq(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            try {
                Invitation freeze = invitationBuffer.getCount() > 0 ? invitationBuffer.get(0).freeze() : null;
                if (freeze != null) {
                    this.zzafi.zza(new InvitationReceivedNotifier(freeze));
                }
            } finally {
                invitationBuffer.release();
            }
        }
    }

    private static final class InvitationReceivedNotifier implements zzi.zzb<OnInvitationReceivedListener> {
        private final Invitation zzapk;

        InvitationReceivedNotifier(Invitation invitation) {
            this.zzapk = invitation;
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzn(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.zzapk);
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        public void zzmw() {
        }
    }

    private static final class InvitationRemovedNotifier implements zzi.zzb<OnInvitationReceivedListener> {
        private final String zzapl;

        InvitationRemovedNotifier(String str) {
            this.zzapl = str;
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzn(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.zzapl);
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        public void zzmw() {
        }
    }

    private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Invitations.LoadInvitationsResult> zzOs;

        InvitationsLoadedBinderCallback(zza.zzb<Invitations.LoadInvitationsResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzp(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    private static final class JoinedRoomNotifier extends AbstractRoomNotifier {
        public JoinedRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomNotifier
        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    private static final class LeaderboardMetadataResultImpl extends GamesDataHolderResult implements Leaderboards.LeaderboardMetadataResult {
        private final LeaderboardBuffer zzapm;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzapm = new LeaderboardBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult
        public LeaderboardBuffer getLeaderboards() {
            return this.zzapm;
        }
    }

    private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Leaderboards.LoadScoresResult> zzOs;

        LeaderboardScoresLoadedBinderCallback(zza.zzb<Leaderboards.LoadScoresResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zza(DataHolder dataHolder, DataHolder dataHolder2) {
            this.zzOs.zzm(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Leaderboards.LeaderboardMetadataResult> zzOs;

        LeaderboardsLoadedBinderCallback(zza.zzb<Leaderboards.LeaderboardMetadataResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzh(DataHolder dataHolder) {
            this.zzOs.zzm(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LeftRoomNotifier implements zzi.zzb<RoomUpdateListener> {
        private final int zzTS;
        private final String zzapn;

        LeftRoomNotifier(int i, String str) {
            this.zzTS = i;
            this.zzapn = str;
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzn(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.zzTS, this.zzapn);
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        public void zzmw() {
        }
    }

    private static final class LoadAchievementsResultImpl extends GamesDataHolderResult implements Achievements.LoadAchievementsResult {
        private final AchievementBuffer zzapo;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzapo = new AchievementBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult
        public AchievementBuffer getAchievements() {
            return this.zzapo;
        }
    }

    private static final class LoadAclResultImpl extends GamesDataHolderResult implements Acls.LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadAppContentsResultImpl extends GamesDataHolderResult implements AppContents.LoadAppContentResult {
        private final ArrayList<DataHolder> zzapp;

        LoadAppContentsResultImpl(DataHolder[] dataHolderArr) {
            super(dataHolderArr[0]);
            this.zzapp = new ArrayList<>(Arrays.asList(dataHolderArr));
        }
    }

    private static final class LoadEventResultImpl extends GamesDataHolderResult implements Events.LoadEventsResult {
        private final EventBuffer zzapq;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzapq = new EventBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.event.Events.LoadEventsResult
        public EventBuffer getEvents() {
            return this.zzapq;
        }
    }

    private static final class LoadGameInstancesResultImpl extends GamesDataHolderResult implements GamesMetadata.LoadGameInstancesResult {
        private final GameInstanceBuffer zzapr;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzapr = new GameInstanceBuffer(dataHolder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends GamesDataHolderResult implements GamesMetadata.LoadGameSearchSuggestionsResult {
        private final GameSearchSuggestionBuffer zzaps;

        LoadGameSearchSuggestionsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaps = new GameSearchSuggestionBuffer(dataHolder);
        }
    }

    private static final class LoadGamesResultImpl extends GamesDataHolderResult implements GamesMetadata.LoadGamesResult {
        private final GameBuffer zzapt;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzapt = new GameBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.GamesMetadata.LoadGamesResult
        public GameBuffer getGames() {
            return this.zzapt;
        }
    }

    private static final class LoadInvitationsResultImpl extends GamesDataHolderResult implements Invitations.LoadInvitationsResult {
        private final InvitationBuffer zzapu;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzapu = new InvitationBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult
        public InvitationBuffer getInvitations() {
            return this.zzapu;
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadMatchesResultImpl implements TurnBasedMultiplayer.LoadMatchesResult {
        private final Status zzOt;
        private final LoadMatchesResponse zzapv;

        LoadMatchesResultImpl(Status status, Bundle bundle) {
            this.zzOt = status;
            this.zzapv = new LoadMatchesResponse(bundle);
        }

        @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult
        public LoadMatchesResponse getMatches() {
            return this.zzapv;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            this.zzapv.release();
        }
    }

    private static final class LoadPlayerScoreResultImpl extends GamesDataHolderResult implements Leaderboards.LoadPlayerScoreResult {
        private final LeaderboardScoreEntity zzapw;

        LoadPlayerScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.zzapw = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.zzapw = null;
                }
            } finally {
                leaderboardScoreBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult
        public LeaderboardScore getScore() {
            return this.zzapw;
        }
    }

    private static final class LoadPlayersResultImpl extends GamesDataHolderResult implements Players.LoadPlayersResult {
        private final PlayerBuffer zzapx;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzapx = new PlayerBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.Players.LoadPlayersResult
        public PlayerBuffer getPlayers() {
            return this.zzapx;
        }
    }

    private static final class LoadProfileSettingsResultImpl extends GamesDataHolderResult implements Players.LoadProfileSettingsResult {
        private final boolean zzaoN;
        private final boolean zzapy;

        LoadProfileSettingsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                if (dataHolder.getCount() > 0) {
                    int zzbh = dataHolder.zzbh(0);
                    this.zzaoN = dataHolder.zze("profile_visible", 0, zzbh);
                    this.zzapy = dataHolder.zze("profile_visibility_explicitly_set", 0, zzbh);
                } else {
                    this.zzaoN = true;
                    this.zzapy = false;
                }
            } finally {
                dataHolder.close();
            }
        }

        @Override // com.google.android.gms.common.api.zzc, com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }

        @Override // com.google.android.gms.games.Players.LoadProfileSettingsResult
        public boolean isProfileVisible() {
            return this.zzaoN;
        }

        @Override // com.google.android.gms.games.Players.LoadProfileSettingsResult
        public boolean isVisibilityExplicitlySet() {
            return this.zzapy;
        }
    }

    private static final class LoadQuestsResultImpl extends GamesDataHolderResult implements Quests.LoadQuestsResult {
        private final DataHolder zzWu;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzWu = dataHolder;
        }

        @Override // com.google.android.gms.games.quest.Quests.LoadQuestsResult
        public QuestBuffer getQuests() {
            return new QuestBuffer(this.zzWu);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends GamesDataHolderResult implements Requests.LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadRequestsResultImpl implements Requests.LoadRequestsResult {
        private final Status zzOt;
        private final Bundle zzapz;

        LoadRequestsResultImpl(Status status, Bundle bundle) {
            this.zzOt = status;
            this.zzapz = bundle;
        }

        @Override // com.google.android.gms.games.request.Requests.LoadRequestsResult
        public GameRequestBuffer getRequests(int i) {
            String zzfG = RequestType.zzfG(i);
            if (this.zzapz.containsKey(zzfG)) {
                return new GameRequestBuffer((DataHolder) this.zzapz.get(zzfG));
            }
            return null;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            Iterator<String> it = this.zzapz.keySet().iterator();
            while (it.hasNext()) {
                DataHolder dataHolder = (DataHolder) this.zzapz.getParcelable(it.next());
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class LoadScoresResultImpl extends GamesDataHolderResult implements Leaderboards.LoadScoresResult {
        private final LeaderboardEntity zzapA;
        private final LeaderboardScoreBuffer zzapB;

        LoadScoresResultImpl(DataHolder dataHolder, DataHolder dataHolder2) {
            super(dataHolder2);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.zzapA = (LeaderboardEntity) leaderboardBuffer.get(0).freeze();
                } else {
                    this.zzapA = null;
                }
                leaderboardBuffer.release();
                this.zzapB = new LeaderboardScoreBuffer(dataHolder2);
            } catch (Throwable th) {
                leaderboardBuffer.release();
                throw th;
            }
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
        public Leaderboard getLeaderboard() {
            return this.zzapA;
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
        public LeaderboardScoreBuffer getScores() {
            return this.zzapB;
        }
    }

    private static final class LoadSnapshotsResultImpl extends GamesDataHolderResult implements Snapshots.LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult
        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.zzWu);
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements Players.LoadXpForGameCategoriesResult {
        private final Status zzOt;
        private final List<String> zzapC;
        private final Bundle zzapD;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle bundle) {
            this.zzOt = status;
            this.zzapC = bundle.getStringArrayList("game_category_list");
            this.zzapD = bundle;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class LoadXpStreamResultImpl extends GamesDataHolderResult implements Players.LoadXpStreamResult {
        private final ExperienceEventBuffer zzapE;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzapE = new ExperienceEventBuffer(dataHolder);
        }
    }

    private static final class MatchRemovedNotifier implements zzi.zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final String zzapF;

        MatchRemovedNotifier(String str) {
            this.zzapF = str;
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzn(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.zzapF);
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        public void zzmw() {
        }
    }

    private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        private final com.google.android.gms.common.api.zzi<OnTurnBasedMatchUpdateReceivedListener> zzafi;

        MatchUpdateReceivedBinderCallback(com.google.android.gms.common.api.zzi<OnTurnBasedMatchUpdateReceivedListener> zziVar) {
            this.zzafi = zziVar;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void onTurnBasedMatchRemoved(String str) {
            this.zzafi.zza(new MatchRemovedNotifier(str));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzw(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                TurnBasedMatch freeze = turnBasedMatchBuffer.getCount() > 0 ? turnBasedMatchBuffer.get(0).freeze() : null;
                if (freeze != null) {
                    this.zzafi.zza(new MatchUpdateReceivedNotifier(freeze));
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }
    }

    private static final class MatchUpdateReceivedNotifier implements zzi.zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final TurnBasedMatch zzapG;

        MatchUpdateReceivedNotifier(TurnBasedMatch turnBasedMatch) {
            this.zzapG = turnBasedMatch;
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzn(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.zzapG);
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        public void zzmw() {
        }
    }

    private static final class MessageReceivedNotifier implements zzi.zzb<RealTimeMessageReceivedListener> {
        private final RealTimeMessage zzapH;

        MessageReceivedNotifier(RealTimeMessage realTimeMessage) {
            this.zzapH = realTimeMessage;
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzn(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            realTimeMessageReceivedListener.onRealTimeMessageReceived(this.zzapH);
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        public void zzmw() {
        }
    }

    private static final class NearbyPlayerDetectedNotifier implements zzi.zzb<OnNearbyPlayerDetectedListener> {
        private final Player zzapI;

        @Override // com.google.android.gms.common.api.zzi.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzn(OnNearbyPlayerDetectedListener onNearbyPlayerDetectedListener) {
            onNearbyPlayerDetectedListener.zza(this.zzapI);
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        public void zzmw() {
        }
    }

    private static final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Acls.LoadAclResult> zzOs;

        NotifyAclLoadedBinderCallback(zza.zzb<Acls.LoadAclResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzF(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadAclResultImpl(dataHolder));
        }
    }

    private static final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzOs;

        NotifyAclUpdatedBinderCallback(zza.zzb<Status> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzfy(int i) {
            this.zzOs.zzm(GamesStatusCodes.zzfn(i));
        }
    }

    private static final class OpenSnapshotResultImpl extends GamesDataHolderResult implements Snapshots.OpenSnapshotResult {
        private final Snapshot zzapJ;
        private final String zzapK;
        private final Snapshot zzapL;
        private final Contents zzapM;
        private final SnapshotContents zzapN;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents contents) {
            this(dataHolder, null, contents, null, null);
        }

        OpenSnapshotResultImpl(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                SnapshotEntity snapshotEntity = null;
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.zzapJ = null;
                } else {
                    boolean z = true;
                    if (snapshotMetadataBuffer.getCount() == 1) {
                        if (dataHolder.getStatusCode() == 4004) {
                            z = false;
                        }
                        com.google.android.gms.common.internal.zzb.zzU(z);
                        this.zzapJ = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                    } else {
                        this.zzapJ = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                        snapshotEntity = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(contents2));
                    }
                }
                this.zzapL = snapshotEntity;
                snapshotMetadataBuffer.release();
                this.zzapK = str;
                this.zzapM = contents3;
                this.zzapN = new SnapshotContentsEntity(contents3);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
                throw th;
            }
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public String getConflictId() {
            return this.zzapK;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public Snapshot getConflictingSnapshot() {
            return this.zzapL;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzapN;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public Snapshot getSnapshot() {
            return this.zzapJ;
        }
    }

    private static final class P2PConnectedNotifier implements zzi.zzb<RoomStatusUpdateListener> {
        private final String zzapO;

        P2PConnectedNotifier(String str) {
            this.zzapO = str;
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzn(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PConnected(this.zzapO);
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        public void zzmw() {
        }
    }

    private static final class P2PDisconnectedNotifier implements zzi.zzb<RoomStatusUpdateListener> {
        private final String zzapO;

        P2PDisconnectedNotifier(String str) {
            this.zzapO = str;
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzn(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PDisconnected(this.zzapO);
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        public void zzmw() {
        }
    }

    private static final class PeerConnectedNotifier extends AbstractPeerStatusNotifier {
        PeerConnectedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    private static final class PeerDeclinedNotifier extends AbstractPeerStatusNotifier {
        PeerDeclinedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    private static final class PeerDisconnectedNotifier extends AbstractPeerStatusNotifier {
        PeerDisconnectedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    private static final class PeerInvitedToRoomNotifier extends AbstractPeerStatusNotifier {
        PeerInvitedToRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    private static final class PeerJoinedRoomNotifier extends AbstractPeerStatusNotifier {
        PeerJoinedRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    private static final class PeerLeftRoomNotifier extends AbstractPeerStatusNotifier {
        PeerLeftRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    private static final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Leaderboards.LoadPlayerScoreResult> zzOs;

        PlayerLeaderboardScoreLoadedBinderCallback(zza.zzb<Leaderboards.LoadPlayerScoreResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzH(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Players.LoadXpForGameCategoriesResult> zzOs;

        PlayerXpForGameCategoriesLoadedBinderCallback(zza.zzb<Players.LoadXpForGameCategoriesResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzf(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzOs.zzm(new LoadXpForGameCategoriesResultImpl(GamesStatusCodes.zzfn(i), bundle));
        }
    }

    static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Players.LoadXpStreamResult> zzOs;

        PlayerXpStreamLoadedBinderCallback(zza.zzb<Players.LoadXpStreamResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzS(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Players.LoadPlayersResult> zzOs;

        PlayersLoadedBinderCallback(zza.zzb<Players.LoadPlayersResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzj(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadPlayersResultImpl(dataHolder));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzk(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadPlayersResultImpl(dataHolder));
        }
    }

    private static final class PopupLocationInfoBinderCallbacks extends AbstractGamesClient {
        private final PopupManager zzaoU;

        public PopupLocationInfoBinderCallbacks(PopupManager popupManager) {
            this.zzaoU = popupManager;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesClient, com.google.android.gms.games.internal.IGamesClient
        public PopupLocationInfoParcelable zzsq() {
            return new PopupLocationInfoParcelable(this.zzaoU.zztg());
        }
    }

    static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Players.LoadProfileSettingsResult> zzOs;

        ProfileSettingsLoadedBinderCallback(zza.zzb<Players.LoadProfileSettingsResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzT(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadProfileSettingsResultImpl(dataHolder));
        }
    }

    private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzOs;

        ProfileSettingsUpdatedBinderCallback(zza.zzb<Status> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzfA(int i) {
            this.zzOs.zzm(GamesStatusCodes.zzfn(i));
        }
    }

    private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Quests.AcceptQuestResult> zzapP;

        public QuestAcceptedBinderCallbacks(zza.zzb<Quests.AcceptQuestResult> zzbVar) {
            this.zzapP = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzO(DataHolder dataHolder) {
            this.zzapP.zzm(new AcceptQuestResultImpl(dataHolder));
        }
    }

    private static final class QuestCompletedNotifier implements zzi.zzb<QuestUpdateListener> {
        private final Quest zzapb;

        QuestCompletedNotifier(Quest quest) {
            this.zzapb = quest;
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzn(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.zzapb);
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        public void zzmw() {
        }
    }

    private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Quests.ClaimMilestoneResult> zzapQ;
        private final String zzapR;

        public QuestMilestoneClaimBinderCallbacks(zza.zzb<Quests.ClaimMilestoneResult> zzbVar, String str) {
            this.zzapQ = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
            this.zzapR = (String) zzu.zzb(str, "MilestoneId must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzN(DataHolder dataHolder) {
            this.zzapQ.zzm(new ClaimMilestoneResultImpl(dataHolder, this.zzapR));
        }
    }

    private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        private final com.google.android.gms.common.api.zzi<QuestUpdateListener> zzafi;

        QuestUpdateBinderCallback(com.google.android.gms.common.api.zzi<QuestUpdateListener> zziVar) {
            this.zzafi = zziVar;
        }

        private Quest zzW(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                return questBuffer.getCount() > 0 ? questBuffer.get(0).freeze() : null;
            } finally {
                questBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzP(DataHolder dataHolder) {
            Quest zzW = zzW(dataHolder);
            if (zzW != null) {
                this.zzafi.zza(new QuestCompletedNotifier(zzW));
            }
        }
    }

    private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Quests.LoadQuestsResult> zzapS;

        public QuestsLoadedBinderCallbacks(zza.zzb<Quests.LoadQuestsResult> zzbVar) {
            this.zzapS = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzR(DataHolder dataHolder) {
            this.zzapS.zzm(new LoadQuestsResultImpl(dataHolder));
        }
    }

    private static final class RealTimeMessageSentNotifier implements zzi.zzb<RealTimeMultiplayer.ReliableMessageSentCallback> {
        private final int zzTS;
        private final String zzapT;
        private final int zzapU;

        RealTimeMessageSentNotifier(int i, int i2, String str) {
            this.zzTS = i;
            this.zzapU = i2;
            this.zzapT = str;
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzn(RealTimeMultiplayer.ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.zzTS, this.zzapU, this.zzapT);
            }
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        public void zzmw() {
        }
    }

    private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final com.google.android.gms.common.api.zzi<RealTimeMultiplayer.ReliableMessageSentCallback> zzapV;

        public RealTimeReliableMessageBinderCallbacks(com.google.android.gms.common.api.zzi<RealTimeMultiplayer.ReliableMessageSentCallback> zziVar) {
            this.zzapV = zziVar;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzb(int i, int i2, String str) {
            if (this.zzapV != null) {
                this.zzapV.zza(new RealTimeMessageSentNotifier(i, i2, str));
            }
        }
    }

    private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        private final com.google.android.gms.common.api.zzi<OnRequestReceivedListener> zzafi;

        RequestReceivedBinderCallback(com.google.android.gms.common.api.zzi<OnRequestReceivedListener> zziVar) {
            this.zzafi = zziVar;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void onRequestRemoved(String str) {
            this.zzafi.zza(new RequestRemovedNotifier(str));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzr(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                GameRequest freeze = gameRequestBuffer.getCount() > 0 ? gameRequestBuffer.get(0).freeze() : null;
                if (freeze != null) {
                    this.zzafi.zza(new RequestReceivedNotifier(freeze));
                }
            } finally {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class RequestReceivedNotifier implements zzi.zzb<OnRequestReceivedListener> {
        private final GameRequest zzapW;

        RequestReceivedNotifier(GameRequest gameRequest) {
            this.zzapW = gameRequest;
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzn(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.zzapW);
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        public void zzmw() {
        }
    }

    private static final class RequestRemovedNotifier implements zzi.zzb<OnRequestReceivedListener> {
        private final String zzDK;

        RequestRemovedNotifier(String str) {
            this.zzDK = str;
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzn(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.zzDK);
        }

        @Override // com.google.android.gms.common.api.zzi.zzb
        public void zzmw() {
        }
    }

    private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Requests.SendRequestResult> zzapX;

        public RequestSentBinderCallbacks(zza.zzb<Requests.SendRequestResult> zzbVar) {
            this.zzapX = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzJ(DataHolder dataHolder) {
            this.zzapX.zzm(new SendRequestResultImpl(dataHolder));
        }
    }

    private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Requests.LoadRequestSummariesResult> zzapY;

        public RequestSummariesLoadedBinderCallbacks(zza.zzb<Requests.LoadRequestSummariesResult> zzbVar) {
            this.zzapY = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzK(DataHolder dataHolder) {
            this.zzapY.zzm(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Requests.LoadRequestsResult> zzapZ;

        public RequestsLoadedBinderCallbacks(zza.zzb<Requests.LoadRequestsResult> zzbVar) {
            this.zzapZ = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzd(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzapZ.zzm(new LoadRequestsResultImpl(GamesStatusCodes.zzfn(i), bundle));
        }
    }

    private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Requests.UpdateRequestsResult> zzaqa;

        public RequestsUpdatedBinderCallbacks(zza.zzb<Requests.UpdateRequestsResult> zzbVar) {
            this.zzaqa = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzI(DataHolder dataHolder) {
            this.zzaqa.zzm(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    private static final class RoomAutoMatchingNotifier extends AbstractRoomStatusNotifier {
        RoomAutoMatchingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomStatusNotifier
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    private static final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        private final com.google.android.gms.common.api.zzi<? extends RoomUpdateListener> zzaqb;
        private final com.google.android.gms.common.api.zzi<? extends RoomStatusUpdateListener> zzaqc;
        private final com.google.android.gms.common.api.zzi<RealTimeMessageReceivedListener> zzaqd;

        public RoomBinderCallbacks(com.google.android.gms.common.api.zzi<RoomUpdateListener> zziVar) {
            this.zzaqb = (com.google.android.gms.common.api.zzi) zzu.zzb(zziVar, "Callbacks must not be null");
            this.zzaqc = null;
            this.zzaqd = null;
        }

        public RoomBinderCallbacks(com.google.android.gms.common.api.zzi<? extends RoomUpdateListener> zziVar, com.google.android.gms.common.api.zzi<? extends RoomStatusUpdateListener> zziVar2, com.google.android.gms.common.api.zzi<RealTimeMessageReceivedListener> zziVar3) {
            this.zzaqb = (com.google.android.gms.common.api.zzi) zzu.zzb(zziVar, "Callbacks must not be null");
            this.zzaqc = zziVar2;
            this.zzaqd = zziVar3;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void onLeftRoom(int i, String str) {
            this.zzaqb.zza(new LeftRoomNotifier(i, str));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void onP2PConnected(String str) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new P2PConnectedNotifier(str));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void onP2PDisconnected(String str) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new P2PDisconnectedNotifier(str));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {
            if (this.zzaqd != null) {
                this.zzaqd.zza(new MessageReceivedNotifier(realTimeMessage));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzA(DataHolder dataHolder) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new RoomAutoMatchingNotifier(dataHolder));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzB(DataHolder dataHolder) {
            this.zzaqb.zza(new RoomConnectedNotifier(dataHolder));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzC(DataHolder dataHolder) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new ConnectedToRoomNotifier(dataHolder));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzD(DataHolder dataHolder) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new DisconnectedFromRoomNotifier(dataHolder));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zza(DataHolder dataHolder, String[] strArr) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new PeerInvitedToRoomNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzb(DataHolder dataHolder, String[] strArr) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new PeerJoinedRoomNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzc(DataHolder dataHolder, String[] strArr) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new PeerLeftRoomNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzd(DataHolder dataHolder, String[] strArr) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new PeerDeclinedNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zze(DataHolder dataHolder, String[] strArr) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new PeerConnectedNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzf(DataHolder dataHolder, String[] strArr) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new PeerDisconnectedNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzx(DataHolder dataHolder) {
            this.zzaqb.zza(new RoomCreatedNotifier(dataHolder));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzy(DataHolder dataHolder) {
            this.zzaqb.zza(new JoinedRoomNotifier(dataHolder));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzz(DataHolder dataHolder) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new RoomConnectingNotifier(dataHolder));
            }
        }
    }

    private static final class RoomConnectedNotifier extends AbstractRoomNotifier {
        RoomConnectedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomNotifier
        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    private static final class RoomConnectingNotifier extends AbstractRoomStatusNotifier {
        RoomConnectingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomStatusNotifier
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    private static final class RoomCreatedNotifier extends AbstractRoomNotifier {
        public RoomCreatedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomNotifier
        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    private static final class SendRequestResultImpl extends GamesDataHolderResult implements Requests.SendRequestResult {
        private final GameRequest zzapW;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.zzapW = gameRequestBuffer.get(0).freeze();
                } else {
                    this.zzapW = null;
                }
            } finally {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzOs;

        public SignOutCompleteBinderCallbacks(zza.zzb<Status> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzkU() {
            this.zzOs.zzm(GamesStatusCodes.zzfn(0));
        }
    }

    private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Snapshots.CommitSnapshotResult> zzaqe;

        public SnapshotCommittedBinderCallbacks(zza.zzb<Snapshots.CommitSnapshotResult> zzbVar) {
            this.zzaqe = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzM(DataHolder dataHolder) {
            this.zzaqe.zzm(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Snapshots.DeleteSnapshotResult> zzOs;

        public SnapshotDeletedBinderCallbacks(zza.zzb<Snapshots.DeleteSnapshotResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzh(int i, String str) {
            this.zzOs.zzm(new DeleteSnapshotResultImpl(i, str));
        }
    }

    private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Snapshots.OpenSnapshotResult> zzaqf;

        public SnapshotOpenedBinderCallbacks(zza.zzb<Snapshots.OpenSnapshotResult> zzbVar) {
            this.zzaqf = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zza(DataHolder dataHolder, Contents contents) {
            this.zzaqf.zzm(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.zzaqf.zzm(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Snapshots.LoadSnapshotsResult> zzaqg;

        public SnapshotsLoadedBinderCallbacks(zza.zzb<Snapshots.LoadSnapshotsResult> zzbVar) {
            this.zzaqg = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzL(DataHolder dataHolder) {
            this.zzaqg.zzm(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Leaderboards.SubmitScoreResult> zzOs;

        public SubmitScoreBinderCallbacks(zza.zzb<Leaderboards.SubmitScoreResult> zzbVar) {
            this.zzOs = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzi(DataHolder dataHolder) {
            this.zzOs.zzm(new SubmitScoreResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreResultImpl extends GamesDataHolderResult implements Leaderboards.SubmitScoreResult {
        private final ScoreSubmissionData zzaqh;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.zzaqh = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult
        public ScoreSubmissionData getScoreData() {
            return this.zzaqh;
        }
    }

    private static final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.CancelMatchResult> zzaqi;

        public TurnBasedMatchCanceledBinderCallbacks(zza.zzb<TurnBasedMultiplayer.CancelMatchResult> zzbVar) {
            this.zzaqi = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzg(int i, String str) {
            this.zzaqi.zzm(new CancelMatchResultImpl(GamesStatusCodes.zzfn(i), str));
        }
    }

    private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzaqj;

        public TurnBasedMatchInitiatedBinderCallbacks(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzbVar) {
            this.zzaqj = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzt(DataHolder dataHolder) {
            this.zzaqj.zzm(new InitiateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.LeaveMatchResult> zzaqk;

        public TurnBasedMatchLeftBinderCallbacks(zza.zzb<TurnBasedMultiplayer.LeaveMatchResult> zzbVar) {
            this.zzaqk = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzv(DataHolder dataHolder) {
            this.zzaqk.zzm(new LeaveMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.LoadMatchResult> zzaql;

        public TurnBasedMatchLoadedBinderCallbacks(zza.zzb<TurnBasedMultiplayer.LoadMatchResult> zzbVar) {
            this.zzaql = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzs(DataHolder dataHolder) {
            this.zzaql.zzm(new LoadMatchResultImpl(dataHolder));
        }
    }

    private static abstract class TurnBasedMatchResult extends GamesDataHolderResult {
        final TurnBasedMatch zzapG;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.zzapG = turnBasedMatchBuffer.get(0).freeze();
                } else {
                    this.zzapG = null;
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.zzapG;
        }
    }

    private static final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.UpdateMatchResult> zzaqm;

        public TurnBasedMatchUpdatedBinderCallbacks(zza.zzb<TurnBasedMultiplayer.UpdateMatchResult> zzbVar) {
            this.zzaqm = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzu(DataHolder dataHolder) {
            this.zzaqm.zzm(new UpdateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.LoadMatchesResult> zzaqn;

        public TurnBasedMatchesLoadedBinderCallbacks(zza.zzb<TurnBasedMultiplayer.LoadMatchesResult> zzbVar) {
            this.zzaqn = (zza.zzb) zzu.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzc(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaqn.zzm(new LoadMatchesResultImpl(GamesStatusCodes.zzfn(i), bundle));
        }
    }

    private static final class UpdateAchievementResultImpl implements Achievements.UpdateAchievementResult {
        private final Status zzOt;
        private final String zzanZ;

        UpdateAchievementResultImpl(int i, String str) {
            this.zzOt = GamesStatusCodes.zzfn(i);
            this.zzanZ = str;
        }

        @Override // com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult
        public String getAchievementId() {
            return this.zzanZ;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class UpdateRequestsResultImpl extends GamesDataHolderResult implements Requests.UpdateRequestsResult {
        private final RequestUpdateOutcomes zzaqo;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaqo = RequestUpdateOutcomes.zzX(dataHolder);
        }

        @Override // com.google.android.gms.games.request.Requests.UpdateRequestsResult
        public Set<String> getRequestIds() {
            return this.zzaqo.getRequestIds();
        }

        @Override // com.google.android.gms.games.request.Requests.UpdateRequestsResult
        public int getRequestOutcome(String str) {
            return this.zzaqo.getRequestOutcome(str);
        }
    }

    public GamesClientImpl(Context context, Looper looper, zze zzeVar, Games.GamesOptions gamesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 1, connectionCallbacks, onConnectionFailedListener, zzeVar);
        this.zzaoQ = new EventIncrementManager() { // from class: com.google.android.gms.games.internal.GamesClientImpl.1
            @Override // com.google.android.gms.games.internal.events.EventIncrementManager
            public EventIncrementCache zzsS() {
                return GamesClientImpl.this.new GameClientEventIncrementCache();
            }
        };
        this.zzaoV = false;
        this.zzaoR = zzeVar.zzny();
        this.zzaoW = new Binder();
        this.zzaoU = PopupManager.zza(this, zzeVar.zznu());
        zzn(zzeVar.zznA());
        this.zzaoX = hashCode();
        this.zzaoY = gamesOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Room zzU(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        try {
            return roomBuffer.getCount() > 0 ? roomBuffer.get(0).freeze() : null;
        } finally {
            roomBuffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(RemoteException remoteException) {
        GamesLog.zzb("GamesClientImpl", "service died", remoteException);
    }

    private void zzst() {
        this.zzaoS = null;
        this.zzaoT = null;
    }

    @Override // com.google.android.gms.common.internal.zzi, com.google.android.gms.common.api.Api.Client
    public void connect(GoogleApiClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        zzst();
        super.connect(connectionProgressReportCallbacks);
    }

    @Override // com.google.android.gms.common.internal.zzi, com.google.android.gms.common.api.Api.Client
    public void disconnect() {
        this.zzaoV = false;
        if (isConnected()) {
            try {
                IGamesService zznM = zznM();
                zznM.zzsR();
                this.zzaoQ.flush();
                zznM.zzE(this.zzaoX);
            } catch (RemoteException e) {
                GamesLog.zzu("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.zzi
    protected String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    @Override // com.google.android.gms.common.internal.zzi
    protected String getStartServiceAction() {
        return "com.google.android.gms.games.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzi
    public void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzaoV = false;
    }

    @Override // com.google.android.gms.common.internal.zzi, com.google.android.gms.common.api.Api.Client
    public boolean requiresSignIn() {
        return true;
    }

    public int zza(com.google.android.gms.common.api.zzi<RealTimeMultiplayer.ReliableMessageSentCallback> zziVar, byte[] bArr, String str, String str2) {
        try {
            return zznM().zza(new RealTimeReliableMessageBinderCallbacks(zziVar), bArr, str, str2);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zza(byte[] bArr, String str, String[] strArr) {
        zzu.zzb(strArr, "Participant IDs must not be null");
        try {
            return zznM().zzb(bArr, str, strArr);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public Intent zza(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent zza = zznM().zza(i, bArr, i2, str);
            zzu.zzb(bitmap, "Must provide a non null icon");
            zza.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return zza;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(PlayerEntity playerEntity) {
        try {
            return zznM().zza(playerEntity);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(Room room, int i) {
        try {
            return zznM().zza((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(String str, boolean z, boolean z2, int i) {
        try {
            return zznM().zza(str, z, z2, i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    @Override // com.google.android.gms.common.internal.zzi
    protected Set<Scope> zza(Set<Scope> set) {
        Scope scope = new Scope(Scopes.GAMES);
        Scope scope2 = new Scope("https://www.googleapis.com/auth/games.firstparty");
        boolean z = false;
        boolean z2 = false;
        for (Scope scope3 : set) {
            if (scope3.equals(scope)) {
                z2 = true;
            } else if (scope3.equals(scope2)) {
                z = true;
            }
        }
        if (z) {
            zzu.zza(!z2, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
        } else {
            zzu.zza(z2, "Games APIs requires %s to function.", Scopes.GAMES);
        }
        return set;
    }

    @Override // com.google.android.gms.common.internal.zzi
    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(GamesClientImpl.class.getClassLoader());
            this.zzaoV = bundle.getBoolean("show_welcome_popup");
            this.zzaoS = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.zzaoT = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                zznM().zza(iBinder, bundle);
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }

    public void zza(zza.zzb<Requests.LoadRequestsResult> zzbVar, int i, int i2, int i3) throws RemoteException {
        zznM().zza(new RequestsLoadedBinderCallbacks(zzbVar), i, i2, i3);
    }

    public void zza(zza.zzb<AppContents.LoadAppContentResult> zzbVar, int i, String str, String[] strArr, boolean z) throws RemoteException {
        zznM().zza(new AppContentLoadedBinderCallbacks(zzbVar), i, str, strArr, z);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzbVar, int i, boolean z, boolean z2) throws RemoteException {
        zznM().zza(new PlayersLoadedBinderCallback(zzbVar), i, z, z2);
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.LoadMatchesResult> zzbVar, int i, int[] iArr) throws RemoteException {
        zznM().zza(new TurnBasedMatchesLoadedBinderCallbacks(zzbVar), i, iArr);
    }

    public void zza(zza.zzb<Leaderboards.LoadScoresResult> zzbVar, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        zznM().zza(new LeaderboardScoresLoadedBinderCallback(zzbVar), leaderboardScoreBuffer.zztF().asBundle(), i, i2);
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzbVar, TurnBasedMatchConfig turnBasedMatchConfig) throws RemoteException {
        zznM().zza(new TurnBasedMatchInitiatedBinderCallbacks(zzbVar), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.zztL(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
    }

    public void zza(zza.zzb<Snapshots.CommitSnapshotResult> zzbVar, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzu.zza(!snapshotContents.isClosed(), "Snapshot already closed");
        BitmapTeleporter zztQ = snapshotMetadataChange.zztQ();
        if (zztQ != null) {
            zztQ.zzc(getContext().getCacheDir());
        }
        Contents zzpe = snapshotContents.zzpe();
        snapshotContents.close();
        zznM().zza(new SnapshotCommittedBinderCallbacks(zzbVar), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzpe);
    }

    public void zza(zza.zzb<Achievements.UpdateAchievementResult> zzbVar, String str) throws RemoteException {
        zznM().zza(zzbVar == null ? null : new AchievementUpdatedBinderCallback(zzbVar), str, this.zzaoU.zztf(), this.zzaoU.zzte());
    }

    public void zza(zza.zzb<Achievements.UpdateAchievementResult> zzbVar, String str, int i) throws RemoteException {
        zznM().zza(zzbVar == null ? null : new AchievementUpdatedBinderCallback(zzbVar), str, i, this.zzaoU.zztf(), this.zzaoU.zzte());
    }

    public void zza(zza.zzb<Leaderboards.LoadScoresResult> zzbVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        zznM().zza(new LeaderboardScoresLoadedBinderCallback(zzbVar), str, i, i2, i3, z);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzbVar, String str, int i, boolean z, boolean z2) throws RemoteException {
        char c;
        switch (str.hashCode()) {
            case 156408498:
                if (str.equals("played_with")) {
                    c = 0;
                    break;
                }
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                zznM().zzd(new PlayersLoadedBinderCallback(zzbVar), str, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.LoadMatchesResult> zzbVar, String str, int i, int[] iArr) throws RemoteException {
        zznM().zza(new TurnBasedMatchesLoadedBinderCallbacks(zzbVar), str, i, iArr);
    }

    public void zza(zza.zzb<Leaderboards.SubmitScoreResult> zzbVar, String str, long j, String str2) throws RemoteException {
        zznM().zza(zzbVar == null ? null : new SubmitScoreBinderCallbacks(zzbVar), str, j, str2);
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.LeaveMatchResult> zzbVar, String str, String str2) throws RemoteException {
        zznM().zzc(new TurnBasedMatchLeftBinderCallbacks(zzbVar), str, str2);
    }

    public void zza(zza.zzb<Leaderboards.LoadPlayerScoreResult> zzbVar, String str, String str2, int i, int i2) throws RemoteException {
        zznM().zza(new PlayerLeaderboardScoreLoadedBinderCallback(zzbVar), str, str2, i, i2);
    }

    public void zza(zza.zzb<Requests.LoadRequestsResult> zzbVar, String str, String str2, int i, int i2, int i3) throws RemoteException {
        zznM().zza(new RequestsLoadedBinderCallbacks(zzbVar), str, str2, i, i2, i3);
    }

    public void zza(zza.zzb<Leaderboards.LoadScoresResult> zzbVar, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        zznM().zza(new LeaderboardScoresLoadedBinderCallback(zzbVar), str, str2, i, i2, i3, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void zza(zza.zzb<Players.LoadPlayersResult> zzbVar, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        char c;
        switch (str.hashCode()) {
            case -1049482625:
                if (str.equals("nearby")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 156408498:
                if (str.equals("played_with")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 782949780:
                if (str.equals("circled")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                zznM().zza(new PlayersLoadedBinderCallback(zzbVar), str, str2, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zza.zzb<Snapshots.OpenSnapshotResult> zzbVar, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        zzu.zza(!snapshotContents.isClosed(), "SnapshotContents already closed");
        BitmapTeleporter zztQ = snapshotMetadataChange.zztQ();
        if (zztQ != null) {
            zztQ.zzc(getContext().getCacheDir());
        }
        Contents zzpe = snapshotContents.zzpe();
        snapshotContents.close();
        zznM().zza(new SnapshotOpenedBinderCallbacks(zzbVar), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzpe);
    }

    public void zza(zza.zzb<Leaderboards.LeaderboardMetadataResult> zzbVar, String str, String str2, boolean z) throws RemoteException {
        zznM().zzb(new LeaderboardsLoadedBinderCallback(zzbVar), str, str2, z);
    }

    public void zza(zza.zzb<Quests.LoadQuestsResult> zzbVar, String str, String str2, boolean z, String[] strArr) throws RemoteException {
        this.zzaoQ.flush();
        zznM().zza(new QuestsLoadedBinderCallbacks(zzbVar), str, str2, strArr, z);
    }

    public void zza(zza.zzb<Quests.LoadQuestsResult> zzbVar, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzaoQ.flush();
        zznM().zza(new QuestsLoadedBinderCallbacks(zzbVar), str, str2, iArr, i, z);
    }

    public void zza(zza.zzb<Requests.UpdateRequestsResult> zzbVar, String str, String str2, String[] strArr) throws RemoteException {
        zznM().zza(new RequestsUpdatedBinderCallbacks(zzbVar), str, str2, strArr);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzbVar, String str, boolean z) throws RemoteException {
        zznM().zzf(new PlayersLoadedBinderCallback(zzbVar), str, z);
    }

    public void zza(zza.zzb<Snapshots.OpenSnapshotResult> zzbVar, String str, boolean z, int i) throws RemoteException {
        zznM().zza(new SnapshotOpenedBinderCallbacks(zzbVar), str, z, i);
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.UpdateMatchResult> zzbVar, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        zznM().zza(new TurnBasedMatchUpdatedBinderCallbacks(zzbVar), str, bArr, str2, participantResultArr);
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.UpdateMatchResult> zzbVar, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        zznM().zza(new TurnBasedMatchUpdatedBinderCallbacks(zzbVar), str, bArr, participantResultArr);
    }

    public void zza(zza.zzb<Requests.SendRequestResult> zzbVar, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException {
        zznM().zza(new RequestSentBinderCallbacks(zzbVar), str, strArr, i, bArr, i2);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzbVar, boolean z) throws RemoteException {
        zznM().zzc(new PlayersLoadedBinderCallback(zzbVar), z);
    }

    public void zza(zza.zzb<Status> zzbVar, boolean z, Bundle bundle) throws RemoteException {
        zznM().zza(new ContactSettingsUpdatedBinderCallback(zzbVar), z, bundle);
    }

    public void zza(zza.zzb<Events.LoadEventsResult> zzbVar, boolean z, String... strArr) throws RemoteException {
        this.zzaoQ.flush();
        zznM().zza(new EventsLoadedBinderCallback(zzbVar), z, strArr);
    }

    public void zza(zza.zzb<Quests.LoadQuestsResult> zzbVar, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzaoQ.flush();
        zznM().zza(new QuestsLoadedBinderCallbacks(zzbVar), iArr, i, z);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzbVar, String[] strArr) throws RemoteException {
        zznM().zzc(new PlayersLoadedBinderCallback(zzbVar), strArr);
    }

    public void zza(com.google.android.gms.common.api.zzi<OnInvitationReceivedListener> zziVar) {
        try {
            zznM().zza(new InvitationReceivedBinderCallback(zziVar), this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(com.google.android.gms.common.api.zzi<RoomUpdateListener> zziVar, com.google.android.gms.common.api.zzi<RoomStatusUpdateListener> zziVar2, com.google.android.gms.common.api.zzi<RealTimeMessageReceivedListener> zziVar3, RoomConfig roomConfig) {
        try {
            zznM().zza((IGamesCallbacks) new RoomBinderCallbacks(zziVar, zziVar2, zziVar3), (IBinder) this.zzaoW, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), false, this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(com.google.android.gms.common.api.zzi<RoomUpdateListener> zziVar, String str) {
        try {
            zznM().zzc(new RoomBinderCallbacks(zziVar), str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(Snapshot snapshot) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzu.zza(!snapshotContents.isClosed(), "Snapshot already closed");
        Contents zzpe = snapshotContents.zzpe();
        snapshotContents.close();
        try {
            zznM().zza(zzpe);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzb(int i, int i2, boolean z) {
        try {
            return zznM().zzb(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzb(int[] iArr) {
        try {
            return zznM().zzb(iArr);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzb(zza.zzb<Status> zzbVar) throws RemoteException {
        this.zzaoQ.flush();
        zznM().zza(new SignOutCompleteBinderCallbacks(zzbVar));
    }

    public void zzb(zza.zzb<Players.LoadPlayersResult> zzbVar, int i, boolean z, boolean z2) throws RemoteException {
        zznM().zzb(new PlayersLoadedBinderCallback(zzbVar), i, z, z2);
    }

    public void zzb(zza.zzb<Achievements.UpdateAchievementResult> zzbVar, String str) throws RemoteException {
        zznM().zzb(zzbVar == null ? null : new AchievementUpdatedBinderCallback(zzbVar), str, this.zzaoU.zztf(), this.zzaoU.zzte());
    }

    public void zzb(zza.zzb<Achievements.UpdateAchievementResult> zzbVar, String str, int i) throws RemoteException {
        zznM().zzb(zzbVar == null ? null : new AchievementUpdatedBinderCallback(zzbVar), str, i, this.zzaoU.zztf(), this.zzaoU.zzte());
    }

    public void zzb(zza.zzb<Leaderboards.LoadScoresResult> zzbVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        zznM().zzb(new LeaderboardScoresLoadedBinderCallback(zzbVar), str, i, i2, i3, z);
    }

    public void zzb(zza.zzb<Players.LoadPlayersResult> zzbVar, String str, int i, boolean z, boolean z2) throws RemoteException {
        zznM().zzb(new PlayersLoadedBinderCallback(zzbVar), str, i, z, z2);
    }

    public void zzb(zza.zzb<Quests.ClaimMilestoneResult> zzbVar, String str, String str2) throws RemoteException {
        this.zzaoQ.flush();
        zznM().zzf(new QuestMilestoneClaimBinderCallbacks(zzbVar, str2), str, str2);
    }

    public void zzb(zza.zzb<Leaderboards.LoadScoresResult> zzbVar, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        zznM().zzb(new LeaderboardScoresLoadedBinderCallback(zzbVar), str, str2, i, i2, i3, z);
    }

    public void zzb(zza.zzb<Players.LoadPlayersResult> zzbVar, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        zznM().zzb(new PlayersLoadedBinderCallback(zzbVar), str, str2, i, z, z2);
    }

    public void zzb(zza.zzb<Achievements.LoadAchievementsResult> zzbVar, String str, String str2, boolean z) throws RemoteException {
        zznM().zza(new AchievementsLoadedBinderCallback(zzbVar), str, str2, z);
    }

    public void zzb(zza.zzb<Leaderboards.LeaderboardMetadataResult> zzbVar, String str, boolean z) throws RemoteException {
        zznM().zzc(new LeaderboardsLoadedBinderCallback(zzbVar), str, z);
    }

    public void zzb(zza.zzb<Leaderboards.LeaderboardMetadataResult> zzbVar, boolean z) throws RemoteException {
        zznM().zzb(new LeaderboardsLoadedBinderCallback(zzbVar), z);
    }

    public void zzb(zza.zzb<Quests.LoadQuestsResult> zzbVar, boolean z, String[] strArr) throws RemoteException {
        this.zzaoQ.flush();
        zznM().zza(new QuestsLoadedBinderCallbacks(zzbVar), strArr, z);
    }

    public void zzb(zza.zzb<Requests.UpdateRequestsResult> zzbVar, String[] strArr) throws RemoteException {
        zznM().zza(new RequestsUpdatedBinderCallbacks(zzbVar), strArr);
    }

    public void zzb(com.google.android.gms.common.api.zzi<OnTurnBasedMatchUpdateReceivedListener> zziVar) {
        try {
            zznM().zzb(new MatchUpdateReceivedBinderCallback(zziVar), this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzb(com.google.android.gms.common.api.zzi<RoomUpdateListener> zziVar, com.google.android.gms.common.api.zzi<RoomStatusUpdateListener> zziVar2, com.google.android.gms.common.api.zzi<RealTimeMessageReceivedListener> zziVar3, RoomConfig roomConfig) {
        try {
            zznM().zza((IGamesCallbacks) new RoomBinderCallbacks(zziVar, zziVar2, zziVar3), (IBinder) this.zzaoW, roomConfig.getInvitationId(), false, this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    /* renamed from: zzbJ, reason: merged with bridge method [inline-methods] */
    public IGamesService zzT(IBinder iBinder) {
        return IGamesService.Stub.zzbM(iBinder);
    }

    public Intent zzc(int i, int i2, boolean z) {
        try {
            return zznM().zzc(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzc(zza.zzb<Invitations.LoadInvitationsResult> zzbVar, int i) throws RemoteException {
        zznM().zza((IGamesCallbacks) new InvitationsLoadedBinderCallback(zzbVar), i);
    }

    public void zzc(zza.zzb<Players.LoadPlayersResult> zzbVar, int i, boolean z, boolean z2) throws RemoteException {
        zznM().zzc(new PlayersLoadedBinderCallback(zzbVar), i, z, z2);
    }

    public void zzc(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzbVar, String str) throws RemoteException {
        zznM().zzl(new TurnBasedMatchInitiatedBinderCallbacks(zzbVar), str);
    }

    public void zzc(zza.zzb<Players.LoadXpStreamResult> zzbVar, String str, int i) throws RemoteException {
        zznM().zzb(new PlayerXpStreamLoadedBinderCallback(zzbVar), str, i);
    }

    public void zzc(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzbVar, String str, String str2) throws RemoteException {
        zznM().zzd(new TurnBasedMatchInitiatedBinderCallbacks(zzbVar), str, str2);
    }

    public void zzc(zza.zzb<Snapshots.LoadSnapshotsResult> zzbVar, String str, String str2, boolean z) throws RemoteException {
        zznM().zzc(new SnapshotsLoadedBinderCallbacks(zzbVar), str, str2, z);
    }

    public void zzc(zza.zzb<Leaderboards.LeaderboardMetadataResult> zzbVar, String str, boolean z) throws RemoteException {
        zznM().zzd(new LeaderboardsLoadedBinderCallback(zzbVar), str, z);
    }

    public void zzc(zza.zzb<Achievements.LoadAchievementsResult> zzbVar, boolean z) throws RemoteException {
        zznM().zza(new AchievementsLoadedBinderCallback(zzbVar), z);
    }

    public void zzc(zza.zzb<Requests.UpdateRequestsResult> zzbVar, String[] strArr) throws RemoteException {
        zznM().zzb(new RequestsUpdatedBinderCallbacks(zzbVar), strArr);
    }

    public void zzc(com.google.android.gms.common.api.zzi<QuestUpdateListener> zziVar) {
        try {
            zznM().zzd(new QuestUpdateBinderCallback(zziVar), this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzcN(String str) {
        try {
            zznM().zzcV(str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzcO(String str) {
        try {
            return zznM().zzcO(str);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzcP(String str) {
        try {
            zznM().zza(str, this.zzaoU.zztf(), this.zzaoU.zzte());
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public int zzd(byte[] bArr, String str) {
        try {
            return zznM().zzb(bArr, str, (String[]) null);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public void zzd(zza.zzb<Players.LoadPlayersResult> zzbVar, int i, boolean z, boolean z2) throws RemoteException {
        zznM().zze(new PlayersLoadedBinderCallback(zzbVar), i, z, z2);
    }

    public void zzd(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzbVar, String str) throws RemoteException {
        zznM().zzm(new TurnBasedMatchInitiatedBinderCallbacks(zzbVar), str);
    }

    public void zzd(zza.zzb<Players.LoadXpStreamResult> zzbVar, String str, int i) throws RemoteException {
        zznM().zzc(new PlayerXpStreamLoadedBinderCallback(zzbVar), str, i);
    }

    public void zzd(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzbVar, String str, String str2) throws RemoteException {
        zznM().zze(new TurnBasedMatchInitiatedBinderCallbacks(zzbVar), str, str2);
    }

    public void zzd(zza.zzb<Notifications.GameMuteStatusChangeResult> zzbVar, String str, boolean z) throws RemoteException {
        zznM().zza(new GameMuteStatusChangedBinderCallback(zzbVar), str, z);
    }

    public void zzd(zza.zzb<Events.LoadEventsResult> zzbVar, boolean z) throws RemoteException {
        this.zzaoQ.flush();
        zznM().zzf(new EventsLoadedBinderCallback(zzbVar), z);
    }

    public void zzd(com.google.android.gms.common.api.zzi<OnRequestReceivedListener> zziVar) {
        try {
            zznM().zzc(new RequestReceivedBinderCallback(zziVar), this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zze(zza.zzb<TurnBasedMultiplayer.LeaveMatchResult> zzbVar, String str) throws RemoteException {
        zznM().zzo(new TurnBasedMatchLeftBinderCallbacks(zzbVar), str);
    }

    public void zze(zza.zzb<Invitations.LoadInvitationsResult> zzbVar, String str, int i) throws RemoteException {
        zznM().zzb((IGamesCallbacks) new InvitationsLoadedBinderCallback(zzbVar), str, i, false);
    }

    public void zze(zza.zzb<Snapshots.LoadSnapshotsResult> zzbVar, boolean z) throws RemoteException {
        zznM().zzd(new SnapshotsLoadedBinderCallbacks(zzbVar), z);
    }

    public void zzf(zza.zzb<GamesMetadata.LoadGamesResult> zzbVar) throws RemoteException {
        zznM().zzd(new GamesLoadedBinderCallback(zzbVar));
    }

    public void zzf(zza.zzb<TurnBasedMultiplayer.CancelMatchResult> zzbVar, String str) throws RemoteException {
        zznM().zzn(new TurnBasedMatchCanceledBinderCallbacks(zzbVar), str);
    }

    public void zzf(zza.zzb<Requests.LoadRequestSummariesResult> zzbVar, String str, int i) throws RemoteException {
        zznM().zza((IGamesCallbacks) new RequestSummariesLoadedBinderCallbacks(zzbVar), str, i);
    }

    public void zzf(zza.zzb<Players.LoadProfileSettingsResult> zzbVar, boolean z) throws RemoteException {
        zznM().zzg(new ProfileSettingsLoadedBinderCallback(zzbVar), z);
    }

    public void zzfC(int i) {
        this.zzaoU.setGravity(i);
    }

    public void zzfD(int i) {
        try {
            zznM().zzfD(i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzg(zza.zzb<Acls.LoadAclResult> zzbVar) throws RemoteException {
        zznM().zzh(new NotifyAclLoadedBinderCallback(zzbVar));
    }

    public void zzg(zza.zzb<TurnBasedMultiplayer.LoadMatchResult> zzbVar, String str) throws RemoteException {
        zznM().zzp(new TurnBasedMatchLoadedBinderCallbacks(zzbVar), str);
    }

    public void zzg(zza.zzb<Status> zzbVar, boolean z) throws RemoteException {
        zznM().zzh(new ProfileSettingsUpdatedBinderCallback(zzbVar), z);
    }

    public void zzh(zza.zzb<Notifications.InboxCountResult> zzbVar) throws RemoteException {
        zznM().zzt(new InboxCountsLoadedBinderCallback(zzbVar), (String) null);
    }

    public void zzh(zza.zzb<Quests.AcceptQuestResult> zzbVar, String str) throws RemoteException {
        this.zzaoQ.flush();
        zznM().zzu(new QuestAcceptedBinderCallbacks(zzbVar), str);
    }

    public void zzh(zza.zzb<Notifications.ContactSettingLoadResult> zzbVar, boolean z) throws RemoteException {
        zznM().zze(new ContactSettingsLoadedBinderCallback(zzbVar), z);
    }

    public void zzi(zza.zzb<Snapshots.DeleteSnapshotResult> zzbVar, String str) throws RemoteException {
        zznM().zzr(new SnapshotDeletedBinderCallbacks(zzbVar), str);
    }

    public void zzj(zza.zzb<GamesMetadata.LoadGameInstancesResult> zzbVar, String str) throws RemoteException {
        zznM().zzf(new GameInstancesLoadedBinderCallback(zzbVar), str);
    }

    public void zzk(zza.zzb<GamesMetadata.LoadGameSearchSuggestionsResult> zzbVar, String str) throws RemoteException {
        zznM().zzq(new GameSearchSuggestionsLoadedBinderCallback(zzbVar), str);
    }

    @Override // com.google.android.gms.common.internal.zzi
    protected Bundle zzkR() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle zzrI = this.zzaoY.zzrI();
        zzrI.putString("com.google.android.gms.games.key.gamePackageName", this.zzaoR);
        zzrI.putString("com.google.android.gms.games.key.desiredLocale", locale);
        zzrI.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzaoU.zztf()));
        zzrI.putInt("com.google.android.gms.games.key.API_VERSION", 0);
        zze zznK = zznK();
        if (zznK.zznB() != null) {
            zzrI.putBundle("com.google.android.gms.games.key.signInOptions", zzh.zza(zznK.zznB(), zznK.zznC(), Executors.newSingleThreadExecutor()));
        }
        return zzrI;
    }

    public void zzl(zza.zzb<Players.LoadXpForGameCategoriesResult> zzbVar, String str) throws RemoteException {
        zznM().zzs(new PlayerXpForGameCategoriesLoadedBinderCallback(zzbVar), str);
    }

    @Override // com.google.android.gms.common.internal.zzi, com.google.android.gms.common.internal.zzj.zza
    public Bundle zzlM() {
        try {
            Bundle zzlM = zznM().zzlM();
            if (zzlM != null) {
                zzlM.setClassLoader(GamesClientImpl.class.getClassLoader());
            }
            return zzlM;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzm(zza.zzb<Invitations.LoadInvitationsResult> zzbVar, String str) throws RemoteException {
        zznM().zzk(new InvitationsLoadedBinderCallback(zzbVar), str);
    }

    public void zzn(View view) {
        this.zzaoU.zzo(view);
    }

    public void zzn(zza.zzb<Status> zzbVar, String str) throws RemoteException {
        zznM().zzj(new NotifyAclUpdatedBinderCallback(zzbVar), str);
    }

    @Override // com.google.android.gms.common.internal.zzi
    public void zznG() {
        super.zznG();
        if (this.zzaoV) {
            this.zzaoU.zztd();
            this.zzaoV = false;
        }
        if (this.zzaoY.zzanC) {
            return;
        }
        zzsu();
    }

    public Intent zzo(String str, int i) {
        try {
            return zznM().zzv(str, i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzo(zza.zzb<Notifications.GameMuteStatusLoadResult> zzbVar, String str) throws RemoteException {
        zznM().zzi(new GameMuteStatusLoadedBinderCallback(zzbVar), str);
    }

    public void zzp(String str, int i) {
        this.zzaoQ.zzp(str, i);
    }

    public void zzq(String str, int i) {
        try {
            zznM().zzq(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzr(String str, int i) {
        try {
            zznM().zzr(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzsA() {
        try {
            return zznM().zzsA();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzsB() {
        try {
            return zznM().zzsB();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzsC() {
        try {
            return zznM().zzsC();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzsD() {
        try {
            zznM().zzF(this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzsE() {
        try {
            zznM().zzG(this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzsF() {
        try {
            zznM().zzI(this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzsG() {
        try {
            zznM().zzH(this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzsH() {
        try {
            return zznM().zzsH();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzsI() {
        try {
            return zznM().zzsI();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzsJ() {
        try {
            return zznM().zzsJ();
        } catch (RemoteException e) {
            zzb(e);
            return 4368;
        }
    }

    public String zzsK() {
        try {
            return zznM().zzsK();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzsL() {
        try {
            return zznM().zzsL();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public Intent zzsM() {
        try {
            return zznM().zzsM();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzsN() {
        try {
            return zznM().zzsN();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzsO() {
        try {
            return zznM().zzsO();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzsP() {
        try {
            return zznM().zzsP();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzsQ() {
        try {
            return zznM().zzsQ();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public void zzsR() {
        if (isConnected()) {
            try {
                zznM().zzsR();
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }

    public void zzsu() {
        try {
            zznM().zza(new PopupLocationInfoBinderCallbacks(this.zzaoU), this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public String zzsv() {
        try {
            return zznM().zzsv();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public String zzsw() {
        if (this.zzaoS != null) {
            return this.zzaoS.getPlayerId();
        }
        try {
            return zznM().zzsw();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Player zzsx() {
        zznL();
        synchronized (this) {
            if (this.zzaoS == null) {
                try {
                    PlayerBuffer playerBuffer = new PlayerBuffer(zznM().zzsT());
                    try {
                        if (playerBuffer.getCount() > 0) {
                            this.zzaoS = (PlayerEntity) playerBuffer.get(0).freeze();
                        }
                        playerBuffer.release();
                    } catch (Throwable th) {
                        playerBuffer.release();
                        throw th;
                    }
                } catch (RemoteException e) {
                    zzb(e);
                }
            }
        }
        return this.zzaoS;
    }

    public Game zzsy() {
        zznL();
        synchronized (this) {
            if (this.zzaoT == null) {
                try {
                    GameBuffer gameBuffer = new GameBuffer(zznM().zzsV());
                    try {
                        if (gameBuffer.getCount() > 0) {
                            this.zzaoT = (GameEntity) gameBuffer.get(0).freeze();
                        }
                        gameBuffer.release();
                    } catch (Throwable th) {
                        gameBuffer.release();
                        throw th;
                    }
                } catch (RemoteException e) {
                    zzb(e);
                }
            }
        }
        return this.zzaoT;
    }

    public Intent zzsz() {
        try {
            return zznM().zzsz();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }
}
