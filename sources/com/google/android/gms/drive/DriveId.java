package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.internal.zzar;
import com.google.android.gms.drive.internal.zzas;
import com.google.android.gms.drive.internal.zzx;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzrn;

/* loaded from: classes.dex */
public class DriveId implements SafeParcelable {
    public static final Parcelable.Creator<DriveId> CREATOR = new zzd();
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    final int zzCY;
    final long zzacO;
    private volatile String zzacQ;
    final String zzadd;
    final long zzade;
    final int zzadf;
    private volatile String zzadg;

    DriveId(int i, String str, long j, long j2, int i2) {
        this.zzacQ = null;
        this.zzadg = null;
        this.zzCY = i;
        this.zzadd = str;
        boolean z = true;
        zzu.zzV(!"".equals(str));
        if (str == null && j == -1) {
            z = false;
        }
        zzu.zzV(z);
        this.zzade = j;
        this.zzacO = j2;
        this.zzadf = i2;
    }

    public DriveId(String str, long j, long j2, int i) {
        this(1, (str == null || !str.startsWith("generated-android-")) ? str : null, j, j2, i);
    }

    public static DriveId decodeFromString(String str) {
        zzu.zzb(str.startsWith("DriveId:"), "Invalid DriveId: " + str);
        return zzk(Base64.decode(str.substring("DriveId:".length()), 10));
    }

    public static DriveId zzcs(String str) {
        zzu.zzu(str);
        return new DriveId(str, -1L, -1L, -1);
    }

    static DriveId zzk(byte[] bArr) {
        try {
            zzar zzl = zzar.zzl(bArr);
            return new DriveId(zzl.versionCode, "".equals(zzl.zzafX) ? null : zzl.zzafX, zzl.zzafY, zzl.zzafV, zzl.zzafZ);
        } catch (zzrm e) {
            throw new IllegalArgumentException();
        }
    }

    private byte[] zzph() {
        zzas zzasVar = new zzas();
        zzasVar.zzafY = this.zzade;
        zzasVar.zzafV = this.zzacO;
        return zzrn.zzf(zzasVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzacQ == null) {
            this.zzacQ = "DriveId:" + Base64.encodeToString(zzpb(), 10);
        }
        return this.zzacQ;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.zzacO != this.zzacO) {
            zzx.zzu("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
        }
        if (driveId.zzade == -1 && this.zzade == -1) {
            return driveId.zzadd.equals(this.zzadd);
        }
        if (this.zzadd == null || driveId.zzadd == null) {
            return driveId.zzade == this.zzade;
        }
        if (driveId.zzade == this.zzade) {
            if (driveId.zzadd.equals(this.zzadd)) {
                return true;
            }
            zzx.zzu("DriveId", "Unexpected unequal resourceId for same DriveId object.");
        }
        return false;
    }

    public String getResourceId() {
        return this.zzadd;
    }

    public int getResourceType() {
        return this.zzadf;
    }

    public int hashCode() {
        return (this.zzade == -1 ? this.zzadd : String.valueOf(this.zzacO) + String.valueOf(this.zzade)).hashCode();
    }

    public final String toInvariantString() {
        if (this.zzadg == null) {
            this.zzadg = Base64.encodeToString(zzph(), 10);
        }
        return this.zzadg;
    }

    public String toString() {
        return encodeToString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    final byte[] zzpb() {
        zzar zzarVar = new zzar();
        zzarVar.versionCode = this.zzCY;
        zzarVar.zzafX = this.zzadd == null ? "" : this.zzadd;
        zzarVar.zzafY = this.zzade;
        zzarVar.zzafV = this.zzacO;
        zzarVar.zzafZ = this.zzadf;
        return zzrn.zzf(zzarVar);
    }
}
