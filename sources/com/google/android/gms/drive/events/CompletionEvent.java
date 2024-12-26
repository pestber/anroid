package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzan;
import com.google.android.gms.drive.internal.zzx;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzlg;
import com.google.android.gms.internal.zzlo;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class CompletionEvent implements SafeParcelable, ResourceEvent {
    public static final Parcelable.Creator<CompletionEvent> CREATOR = new zze();
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;
    final int zzCY;
    final String zzOx;
    final DriveId zzacT;
    final ParcelFileDescriptor zzadT;
    final ParcelFileDescriptor zzadU;
    final MetadataBundle zzadV;
    final List<String> zzadW;
    final IBinder zzadX;
    private boolean zzadY = false;
    private boolean zzadZ = false;
    private boolean zzaea = false;
    final int zzwS;

    CompletionEvent(int i, DriveId driveId, String str, ParcelFileDescriptor parcelFileDescriptor, ParcelFileDescriptor parcelFileDescriptor2, MetadataBundle metadataBundle, List<String> list, int i2, IBinder iBinder) {
        this.zzCY = i;
        this.zzacT = driveId;
        this.zzOx = str;
        this.zzadT = parcelFileDescriptor;
        this.zzadU = parcelFileDescriptor2;
        this.zzadV = metadataBundle;
        this.zzadW = list;
        this.zzwS = i2;
        this.zzadX = iBinder;
    }

    private void zzpu() {
        if (this.zzaea) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    private void zzv(boolean z) {
        zzpu();
        this.zzaea = true;
        zzlg.zza(this.zzadT);
        zzlg.zza(this.zzadU);
        if (this.zzadV != null && this.zzadV.zzc(zzlo.zzaho)) {
            ((BitmapTeleporter) this.zzadV.zza(zzlo.zzaho)).release();
        }
        if (this.zzadX == null) {
            zzx.zzv("CompletionEvent", "No callback on " + (z ? "snooze" : "dismiss"));
            return;
        }
        try {
            zzan.zza.zzaR(this.zzadX).zzv(z);
        } catch (RemoteException e) {
            zzx.zzv("CompletionEvent", "RemoteException on " + (z ? "snooze" : "dismiss") + ": " + e);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dismiss() {
        zzv(false);
    }

    public String getAccountName() {
        zzpu();
        return this.zzOx;
    }

    public InputStream getBaseContentsInputStream() {
        zzpu();
        if (this.zzadT == null) {
            return null;
        }
        if (this.zzadY) {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzadY = true;
        return new FileInputStream(this.zzadT.getFileDescriptor());
    }

    @Override // com.google.android.gms.drive.events.ResourceEvent
    public DriveId getDriveId() {
        zzpu();
        return this.zzacT;
    }

    public InputStream getModifiedContentsInputStream() {
        zzpu();
        if (this.zzadU == null) {
            return null;
        }
        if (this.zzadZ) {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzadZ = true;
        return new FileInputStream(this.zzadU.getFileDescriptor());
    }

    public MetadataChangeSet getModifiedMetadataChangeSet() {
        zzpu();
        if (this.zzadV != null) {
            return new MetadataChangeSet(this.zzadV);
        }
        return null;
    }

    public int getStatus() {
        zzpu();
        return this.zzwS;
    }

    public List<String> getTrackingTags() {
        zzpu();
        return new ArrayList(this.zzadW);
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public int getType() {
        return 2;
    }

    public void snooze() {
        zzv(true);
    }

    public String toString() {
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", this.zzacT, Integer.valueOf(this.zzwS), this.zzadW == null ? "<null>" : "'" + TextUtils.join("','", this.zzadW) + "'");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i | 1);
    }
}
