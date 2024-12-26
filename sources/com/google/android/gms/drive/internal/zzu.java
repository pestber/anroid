package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.zzi;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzq;

/* loaded from: classes.dex */
public class zzu extends zzz implements DriveFile {

    private static class zza implements DriveFile.DownloadProgressListener {
        private final com.google.android.gms.common.api.zzi<DriveFile.DownloadProgressListener> zzafi;

        public zza(com.google.android.gms.common.api.zzi<DriveFile.DownloadProgressListener> zziVar) {
            this.zzafi = zziVar;
        }

        @Override // com.google.android.gms.drive.DriveFile.DownloadProgressListener
        public void onProgress(final long j, final long j2) {
            this.zzafi.zza(new zzi.zzb<DriveFile.DownloadProgressListener>() { // from class: com.google.android.gms.drive.internal.zzu.zza.1
                @Override // com.google.android.gms.common.api.zzi.zzb
                /* renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzn(DriveFile.DownloadProgressListener downloadProgressListener) {
                    downloadProgressListener.onProgress(j, j2);
                }

                @Override // com.google.android.gms.common.api.zzi.zzb
                public void zzmw() {
                }
            });
        }
    }

    public zzu(DriveId driveId) {
        super(driveId);
    }

    private static DriveFile.DownloadProgressListener zza(GoogleApiClient googleApiClient, DriveFile.DownloadProgressListener downloadProgressListener) {
        if (downloadProgressListener == null) {
            return null;
        }
        return new zza(googleApiClient.zzo(downloadProgressListener));
    }

    @Override // com.google.android.gms.drive.DriveFile
    public PendingResult<DriveApi.DriveContentsResult> open(GoogleApiClient googleApiClient, final int i, DriveFile.DownloadProgressListener downloadProgressListener) {
        if (i != 268435456 && i != 536870912 && i != 805306368) {
            throw new IllegalArgumentException("Invalid mode provided.");
        }
        final DriveFile.DownloadProgressListener zza2 = zza(googleApiClient, downloadProgressListener);
        return googleApiClient.zza((GoogleApiClient) new zzq.zzb(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzu.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzs zzsVar) throws RemoteException {
                setCancelToken(zzsVar.zzpB().zza(new OpenContentsRequest(zzu.this.getDriveId(), i, 0), new zzbi(this, zza2)).zzpF());
            }
        });
    }
}
