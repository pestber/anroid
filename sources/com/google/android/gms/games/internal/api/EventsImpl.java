package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;

/* loaded from: classes.dex */
public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends Games.BaseGamesApiMethodImpl<Events.LoadEventsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzW, reason: merged with bridge method [inline-methods] */
        public Events.LoadEventsResult createFailedResult(final Status status) {
            return new Events.LoadEventsResult() { // from class: com.google.android.gms.games.internal.api.EventsImpl.LoadImpl.1
                @Override // com.google.android.gms.games.event.Events.LoadEventsResult
                public EventBuffer getEvents() {
                    return new EventBuffer(DataHolder.zzbi(14));
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

    private static abstract class UpdateImpl extends Games.BaseGamesApiMethodImpl<Result> {
        private UpdateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        public Result createFailedResult(final Status status) {
            return new Result() { // from class: com.google.android.gms.games.internal.api.EventsImpl.UpdateImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Override // com.google.android.gms.games.event.Events
    public void increment(GoogleApiClient googleApiClient, final String str, final int i) {
        GamesClientImpl zzc = Games.zzc(googleApiClient, false);
        if (zzc == null) {
            return;
        }
        if (zzc.isConnected()) {
            zzc.zzp(str, i);
        } else {
            googleApiClient.zzb(new UpdateImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.EventsImpl.3
                @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
                public void zza(GamesClientImpl gamesClientImpl) {
                    gamesClientImpl.zzp(str, i);
                }
            });
        }
    }

    @Override // com.google.android.gms.games.event.Events
    public PendingResult<Events.LoadEventsResult> load(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza((GoogleApiClient) new LoadImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.EventsImpl.2
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzd(this, z);
            }
        });
    }

    @Override // com.google.android.gms.games.event.Events
    public PendingResult<Events.LoadEventsResult> loadByIds(GoogleApiClient googleApiClient, final boolean z, final String... strArr) {
        return googleApiClient.zza((GoogleApiClient) new LoadImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.EventsImpl.1
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, z, strArr);
            }
        });
    }
}
