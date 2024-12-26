package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class Contents implements SafeParcelable {
    public static final Parcelable.Creator<Contents> CREATOR = new zzb();
    final int zzCY;
    final ParcelFileDescriptor zzYZ;
    final int zzacR;
    final int zzacS;
    final DriveId zzacT;
    final boolean zzacU;

    Contents(int i, ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, DriveId driveId, boolean z) {
        this.zzCY = i;
        this.zzYZ = parcelFileDescriptor;
        this.zzacR = i2;
        this.zzacS = i3;
        this.zzacT = driveId;
        this.zzacU = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzacT;
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.zzYZ.getFileDescriptor());
    }

    public int getMode() {
        return this.zzacS;
    }

    public OutputStream getOutputStream() {
        return new FileOutputStream(this.zzYZ.getFileDescriptor());
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.zzYZ;
    }

    public int getRequestId() {
        return this.zzacR;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public boolean zzpc() {
        return this.zzacU;
    }
}
