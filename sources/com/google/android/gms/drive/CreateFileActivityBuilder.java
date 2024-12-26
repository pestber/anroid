package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.internal.zzt;

/* loaded from: classes.dex */
public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private final com.google.android.gms.drive.internal.zzj zzacV = new com.google.android.gms.drive.internal.zzj(0);
    private DriveContents zzacW;
    private boolean zzacX;

    public IntentSender build(GoogleApiClient googleApiClient) {
        zzu.zzb(Boolean.valueOf(this.zzacX), "Must call setInitialDriveContents to CreateFileActivityBuilder.");
        zzu.zza(googleApiClient.isConnected(), "Client must be connected");
        zzu.zzb(googleApiClient.zza(Drive.SCOPE_FILE) || googleApiClient.zza(Drive.zzacY), "The apiClient must have suitable scope to create files");
        if (this.zzacW != null) {
            this.zzacW.zzpf();
        }
        return this.zzacV.build(googleApiClient);
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId driveId) {
        this.zzacV.zza(driveId);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String str) {
        this.zzacV.zzcv(str);
        return this;
    }

    public CreateFileActivityBuilder setInitialDriveContents(DriveContents driveContents) {
        if (driveContents == null) {
            this.zzacV.zzct(1);
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
            this.zzacV.zzct(driveContents.zzpe().getRequestId());
            this.zzacW = driveContents;
        }
        this.zzacX = true;
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.zzacV.zza(metadataChangeSet);
        return this;
    }
}
