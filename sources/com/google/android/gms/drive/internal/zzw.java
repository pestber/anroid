package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;

/* loaded from: classes.dex */
public class zzw extends zzz implements DriveFolder {

    private static class zza extends com.google.android.gms.drive.internal.zzd {
        private final zza.zzb<DriveFolder.DriveFileResult> zzOs;

        public zza(zza.zzb<DriveFolder.DriveFileResult> zzbVar) {
            this.zzOs = zzbVar;
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzal
        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzOs.zzm(new zzc(Status.zzXP, new zzu(onDriveIdResponse.getDriveId())));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzal
        public void zzt(Status status) throws RemoteException {
            this.zzOs.zzm(new zzc(status, null));
        }
    }

    private static class zzb extends com.google.android.gms.drive.internal.zzd {
        private final zza.zzb<DriveFolder.DriveFolderResult> zzOs;

        public zzb(zza.zzb<DriveFolder.DriveFolderResult> zzbVar) {
            this.zzOs = zzbVar;
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzal
        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzOs.zzm(new zze(Status.zzXP, new zzw(onDriveIdResponse.getDriveId())));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzal
        public void zzt(Status status) throws RemoteException {
            this.zzOs.zzm(new zze(status, null));
        }
    }

    private static class zzc implements DriveFolder.DriveFileResult {
        private final Status zzOt;
        private final DriveFile zzafr;

        public zzc(Status status, DriveFile driveFile) {
            this.zzOt = status;
            this.zzafr = driveFile;
        }

        @Override // com.google.android.gms.drive.DriveFolder.DriveFileResult
        public DriveFile getDriveFile() {
            return this.zzafr;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    static abstract class zzd extends zzr<DriveFolder.DriveFileResult> {
        zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzx, reason: merged with bridge method [inline-methods] */
        public DriveFolder.DriveFileResult createFailedResult(Status status) {
            return new zzc(status, null);
        }
    }

    private static class zze implements DriveFolder.DriveFolderResult {
        private final Status zzOt;
        private final DriveFolder zzafs;

        public zze(Status status, DriveFolder driveFolder) {
            this.zzOt = status;
            this.zzafs = driveFolder;
        }

        @Override // com.google.android.gms.drive.DriveFolder.DriveFolderResult
        public DriveFolder getDriveFolder() {
            return this.zzafs;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    static abstract class zzf extends zzr<DriveFolder.DriveFolderResult> {
        zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzy, reason: merged with bridge method [inline-methods] */
        public DriveFolder.DriveFolderResult createFailedResult(Status status) {
            return new zze(status, null);
        }
    }

    public zzw(DriveId driveId) {
        super(driveId);
    }

    private PendingResult<DriveFolder.DriveFileResult> zza(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet, final int i, final int i2, final ExecutionOptions executionOptions) {
        ExecutionOptions.zza(googleApiClient, executionOptions);
        return googleApiClient.zzb(new zzd(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzw.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzs zzsVar) throws RemoteException {
                metadataChangeSet.zzpm().setContext(zzsVar.getContext());
                zzsVar.zzpB().zza(new CreateFileRequest(zzw.this.getDriveId(), metadataChangeSet.zzpm(), i, i2, executionOptions), new zza(this));
            }
        });
    }

    private PendingResult<DriveFolder.DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        int i;
        if (driveContents == null) {
            i = 1;
        } else {
            if (!(driveContents instanceof zzt)) {
                throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
            }
            if (driveContents.getDriveId() != null) {
                throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
            }
            if (driveContents.zzpg()) {
                throw new IllegalArgumentException("DriveContents are already closed.");
            }
            i = driveContents.zzpe().getRequestId();
            driveContents.zzpf();
        }
        int i2 = i;
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        if (DriveFolder.MIME_TYPE.equals(metadataChangeSet.getMimeType())) {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
        return zza(googleApiClient, metadataChangeSet, i2, 0, executionOptions);
    }

    private Query zza(Query query) {
        Query.Builder addFilter = new Query.Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return addFilter.build();
    }

    @Override // com.google.android.gms.drive.DriveFolder
    public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents) {
        return createFile(googleApiClient, metadataChangeSet, driveContents, null);
    }

    @Override // com.google.android.gms.drive.DriveFolder
    public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new ExecutionOptions.Builder().build();
        }
        if (executionOptions.zzpk() == 0) {
            return zza(googleApiClient, metadataChangeSet, driveContents, executionOptions);
        }
        throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
    }

    @Override // com.google.android.gms.drive.DriveFolder
    public PendingResult<DriveFolder.DriveFolderResult> createFolder(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        if (metadataChangeSet.getMimeType() == null || metadataChangeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return googleApiClient.zzb(new zzf(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzw.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
                public void zza(zzs zzsVar) throws RemoteException {
                    metadataChangeSet.zzpm().setContext(zzsVar.getContext());
                    zzsVar.zzpB().zza(new CreateFolderRequest(zzw.this.getDriveId(), metadataChangeSet.zzpm()), new zzb(this));
                }
            });
        }
        throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
    }

    @Override // com.google.android.gms.drive.DriveFolder
    public PendingResult<DriveApi.MetadataBufferResult> listChildren(GoogleApiClient googleApiClient) {
        return queryChildren(googleApiClient, null);
    }

    @Override // com.google.android.gms.drive.DriveFolder
    public PendingResult<DriveApi.MetadataBufferResult> queryChildren(GoogleApiClient googleApiClient, Query query) {
        return new zzq().query(googleApiClient, zza(query));
    }
}
