package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;

/* loaded from: classes.dex */
public final class SnapshotsImpl implements Snapshots {

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl$6, reason: invalid class name */
    class AnonymousClass6 extends LoadImpl {
        final /* synthetic */ String zzTE;
        final /* synthetic */ String zzaqA;
        final /* synthetic */ boolean zzaqy;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc(this, this.zzTE, this.zzaqA, this.zzaqy);
        }
    }

    private static abstract class CommitImpl extends Games.BaseGamesApiMethodImpl<Snapshots.CommitSnapshotResult> {
        private CommitImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzau, reason: merged with bridge method [inline-methods] */
        public Snapshots.CommitSnapshotResult createFailedResult(final Status status) {
            return new Snapshots.CommitSnapshotResult() { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.CommitImpl.1
                @Override // com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult
                public SnapshotMetadata getSnapshotMetadata() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class DeleteImpl extends Games.BaseGamesApiMethodImpl<Snapshots.DeleteSnapshotResult> {
        private DeleteImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzav, reason: merged with bridge method [inline-methods] */
        public Snapshots.DeleteSnapshotResult createFailedResult(final Status status) {
            return new Snapshots.DeleteSnapshotResult() { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.DeleteImpl.1
                @Override // com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult
                public String getSnapshotId() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadImpl extends Games.BaseGamesApiMethodImpl<Snapshots.LoadSnapshotsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzaw, reason: merged with bridge method [inline-methods] */
        public Snapshots.LoadSnapshotsResult createFailedResult(final Status status) {
            return new Snapshots.LoadSnapshotsResult() { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.LoadImpl.1
                @Override // com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult
                public SnapshotMetadataBuffer getSnapshots() {
                    return new SnapshotMetadataBuffer(DataHolder.zzbi(14));
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

    private static abstract class OpenImpl extends Games.BaseGamesApiMethodImpl<Snapshots.OpenSnapshotResult> {
        private OpenImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzax, reason: merged with bridge method [inline-methods] */
        public Snapshots.OpenSnapshotResult createFailedResult(final Status status) {
            return new Snapshots.OpenSnapshotResult() { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.OpenImpl.1
                @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
                public String getConflictId() {
                    return null;
                }

                @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
                public Snapshot getConflictingSnapshot() {
                    return null;
                }

                @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
                public SnapshotContents getResolutionSnapshotContents() {
                    return null;
                }

                @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
                public Snapshot getSnapshot() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public PendingResult<Snapshots.CommitSnapshotResult> commitAndClose(GoogleApiClient googleApiClient, final Snapshot snapshot, final SnapshotMetadataChange snapshotMetadataChange) {
        return googleApiClient.zzb(new CommitImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, snapshot, snapshotMetadataChange);
            }
        });
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public PendingResult<Snapshots.DeleteSnapshotResult> delete(GoogleApiClient googleApiClient, final SnapshotMetadata snapshotMetadata) {
        return googleApiClient.zzb(new DeleteImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzi(this, snapshotMetadata.getSnapshotId());
            }
        });
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public void discardAndClose(GoogleApiClient googleApiClient, Snapshot snapshot) {
        Games.zzd(googleApiClient).zza(snapshot);
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public int getMaxCoverImageSize(GoogleApiClient googleApiClient) {
        return Games.zzd(googleApiClient).zzsQ();
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public int getMaxDataSize(GoogleApiClient googleApiClient) {
        return Games.zzd(googleApiClient).zzsP();
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public Intent getSelectSnapshotIntent(GoogleApiClient googleApiClient, String str, boolean z, boolean z2, int i) {
        return Games.zzd(googleApiClient).zza(str, z, z2, i);
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public SnapshotMetadata getSnapshotFromBundle(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(Snapshots.EXTRA_SNAPSHOT_METADATA)) {
            return null;
        }
        return (SnapshotMetadata) bundle.getParcelable(Snapshots.EXTRA_SNAPSHOT_METADATA);
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public PendingResult<Snapshots.LoadSnapshotsResult> load(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza((GoogleApiClient) new LoadImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zze(this, z);
            }
        });
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
        return open(googleApiClient, snapshotMetadata.getUniqueName(), false);
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata, int i) {
        return open(googleApiClient, snapshotMetadata.getUniqueName(), false, i);
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient googleApiClient, String str, boolean z) {
        return open(googleApiClient, str, z, -1);
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient googleApiClient, final String str, final boolean z, final int i) {
        return googleApiClient.zzb(new OpenImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, str, z, i);
            }
        });
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(GoogleApiClient googleApiClient, String str, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        return resolveConflict(googleApiClient, str, metadata.getSnapshotId(), new SnapshotMetadataChange.Builder().fromMetadata(metadata).build(), snapshot.getSnapshotContents());
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(GoogleApiClient googleApiClient, final String str, final String str2, final SnapshotMetadataChange snapshotMetadataChange, final SnapshotContents snapshotContents) {
        return googleApiClient.zzb(new OpenImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, str, str2, snapshotMetadataChange, snapshotContents);
            }
        });
    }
}
