package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.internal.zzr;
import com.google.android.gms.drive.query.Query;
import java.util.List;

/* loaded from: classes.dex */
public class zzq implements DriveApi {

    static class zza implements Releasable, DriveApi.DriveContentsResult {
        private final Status zzOt;
        private final DriveContents zzacW;

        public zza(Status status, DriveContents driveContents) {
            this.zzOt = status;
            this.zzacW = driveContents;
        }

        @Override // com.google.android.gms.drive.DriveApi.DriveContentsResult
        public DriveContents getDriveContents() {
            return this.zzacW;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.zzacW != null) {
                this.zzacW.zzpf();
            }
        }
    }

    static abstract class zzb extends zzr<DriveApi.DriveContentsResult> {
        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzu, reason: merged with bridge method [inline-methods] */
        public DriveApi.DriveContentsResult createFailedResult(Status status) {
            return new zza(status, null);
        }
    }

    static class zzc extends com.google.android.gms.drive.internal.zzd {
        private final zza.zzb<DriveApi.DriveIdResult> zzOs;

        public zzc(zza.zzb<DriveApi.DriveIdResult> zzbVar) {
            this.zzOs = zzbVar;
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzal
        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzOs.zzm(new zzd(Status.zzXP, onDriveIdResponse.getDriveId()));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzal
        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzOs.zzm(new zzd(Status.zzXP, new zzn(onMetadataResponse.zzpS()).getDriveId()));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzal
        public void zzt(Status status) throws RemoteException {
            this.zzOs.zzm(new zzd(status, null));
        }
    }

    private static class zzd implements DriveApi.DriveIdResult {
        private final Status zzOt;
        private final DriveId zzacT;

        public zzd(Status status, DriveId driveId) {
            this.zzOt = status;
            this.zzacT = driveId;
        }

        @Override // com.google.android.gms.drive.DriveApi.DriveIdResult
        public DriveId getDriveId() {
            return this.zzacT;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    static abstract class zze extends zzr<DriveApi.DriveIdResult> {
        zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzv, reason: merged with bridge method [inline-methods] */
        public DriveApi.DriveIdResult createFailedResult(Status status) {
            return new zzd(status, null);
        }
    }

    static class zzf implements DriveApi.MetadataBufferResult {
        private final Status zzOt;
        private final MetadataBuffer zzaeK;
        private final boolean zzaeL;

        public zzf(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.zzOt = status;
            this.zzaeK = metadataBuffer;
            this.zzaeL = z;
        }

        @Override // com.google.android.gms.drive.DriveApi.MetadataBufferResult
        public MetadataBuffer getMetadataBuffer() {
            return this.zzaeK;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.zzaeK != null) {
                this.zzaeK.release();
            }
        }
    }

    static abstract class zzg extends zzr<DriveApi.MetadataBufferResult> {
        zzg(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzw, reason: merged with bridge method [inline-methods] */
        public DriveApi.MetadataBufferResult createFailedResult(Status status) {
            return new zzf(status, null, false);
        }
    }

    private static class zzh extends com.google.android.gms.drive.internal.zzd {
        private final zza.zzb<DriveApi.DriveContentsResult> zzOs;

        public zzh(zza.zzb<DriveApi.DriveContentsResult> zzbVar) {
            this.zzOs = zzbVar;
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzal
        public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
            this.zzOs.zzm(new zza(Status.zzXP, new zzt(onContentsResponse.zzpJ())));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzal
        public void zzt(Status status) throws RemoteException {
            this.zzOs.zzm(new zza(status, null));
        }
    }

    private static class zzi extends com.google.android.gms.drive.internal.zzd {
        private final zza.zzb<DriveApi.MetadataBufferResult> zzOs;

        public zzi(zza.zzb<DriveApi.MetadataBufferResult> zzbVar) {
            this.zzOs = zzbVar;
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzal
        public void zza(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.zzOs.zzm(new zzf(Status.zzXP, new MetadataBuffer(onListEntriesResponse.zzpP()), onListEntriesResponse.zzpQ()));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzal
        public void zzt(Status status) throws RemoteException {
            this.zzOs.zzm(new zzf(status, null, false));
        }
    }

    static class zzj extends zzr.zza {
        zzj(GoogleApiClient googleApiClient, Status status) {
            super(googleApiClient);
            setResult(status);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
        public void zza(zzs zzsVar) {
        }
    }

    @Override // com.google.android.gms.drive.DriveApi
    public PendingResult<Status> cancelPendingActions(GoogleApiClient googleApiClient, List<String> list) {
        return ((zzs) googleApiClient.zza(Drive.zzNX)).cancelPendingActions(googleApiClient, list);
    }

    @Override // com.google.android.gms.drive.DriveApi
    public PendingResult<DriveApi.DriveIdResult> fetchDriveId(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza((GoogleApiClient) new zze(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzq.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzs zzsVar) throws RemoteException {
                zzsVar.zzpB().zza(new GetMetadataRequest(DriveId.zzcs(str), false), new zzc(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveApi
    public DriveFolder getAppFolder(GoogleApiClient googleApiClient) {
        if (!googleApiClient.isConnected()) {
            throw new IllegalStateException("Client must be connected");
        }
        DriveId zzpD = ((zzs) googleApiClient.zza(Drive.zzNX)).zzpD();
        if (zzpD != null) {
            return new zzw(zzpD);
        }
        return null;
    }

    @Override // com.google.android.gms.drive.DriveApi
    public DriveFile getFile(GoogleApiClient googleApiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        }
        if (googleApiClient.isConnected()) {
            return new zzu(driveId);
        }
        throw new IllegalStateException("Client must be connected");
    }

    @Override // com.google.android.gms.drive.DriveApi
    public DriveFolder getFolder(GoogleApiClient googleApiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        }
        if (googleApiClient.isConnected()) {
            return new zzw(driveId);
        }
        throw new IllegalStateException("Client must be connected");
    }

    @Override // com.google.android.gms.drive.DriveApi
    public DriveFolder getRootFolder(GoogleApiClient googleApiClient) {
        if (googleApiClient.isConnected()) {
            return new zzw(((zzs) googleApiClient.zza(Drive.zzNX)).zzpC());
        }
        throw new IllegalStateException("Client must be connected");
    }

    @Override // com.google.android.gms.drive.DriveApi
    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    @Override // com.google.android.gms.drive.DriveApi
    public PendingResult<DriveApi.DriveContentsResult> newDriveContents(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, DriveFile.MODE_WRITE_ONLY);
    }

    @Override // com.google.android.gms.drive.DriveApi
    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    @Override // com.google.android.gms.drive.DriveApi
    public PendingResult<DriveApi.MetadataBufferResult> query(GoogleApiClient googleApiClient, final Query query) {
        if (query != null) {
            return googleApiClient.zza((GoogleApiClient) new zzg(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzq.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
                public void zza(zzs zzsVar) throws RemoteException {
                    zzsVar.zzpB().zza(new QueryRequest(query), new zzi(this));
                }
            });
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    @Override // com.google.android.gms.drive.DriveApi
    public PendingResult<Status> requestSync(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzr.zza(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzq.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzs zzsVar) throws RemoteException {
                zzsVar.zzpB().zza(new zzbq(this));
            }
        });
    }

    public PendingResult<DriveApi.DriveContentsResult> zza(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza((GoogleApiClient) new zzb(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzq.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzs zzsVar) throws RemoteException {
                zzsVar.zzpB().zza(new CreateContentsRequest(i), new zzh(this));
            }
        });
    }
}
